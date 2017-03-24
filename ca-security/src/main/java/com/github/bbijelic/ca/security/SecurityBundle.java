package com.github.bbijelic.ca.security;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bbijelic.ca.config.CertificateAuthorityConfiguration;
import com.github.bbijelic.ca.db.dao.UserDao;
import com.github.bbijelic.ca.db.entity.UserEntity;

import io.dropwizard.Bundle;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.UnitOfWorkAwareProxyFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Security bundle
 */
public class SecurityBundle implements Bundle {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityBundle.class);
        
    /**
     * Hibernate bundle
     */
    private HibernateBundle<CertificateAuthorityConfiguration> hibernateBundle;
    
    /**
     * Constructor
     * 
     * @param userDao the user dao
     * @param hibernateBundle the hibernate bundle
     */
    public SecurityBundle(HibernateBundle<CertificateAuthorityConfiguration> hibernateBundle){
        this.hibernateBundle = hibernateBundle;
    }
    
    @Override
    public void initialize(Bootstrap< ? > bootstrap) {
        LOGGER.info("Initializing security bundle");
        
    }
    
    @Override
    public void run(Environment environment) {
        LOGGER.info("Running security bundle");
        
        environment.jersey().register(new TestSecurityResource());
        
        SessionFactory sessionFactory = hibernateBundle.getSessionFactory();
        
        LOGGER.debug("Obtained session factory");
        
        // Initialize user dao
        UserDao userDao = new UserDao(sessionFactory);
        
        LOGGER.debug("Initialized User DAO");
        
        // Initialize service authenticator
        ServiceAuthenticator authenticator = 
            new UnitOfWorkAwareProxyFactory(hibernateBundle)
                .create(ServiceAuthenticator.class, UserDao.class, userDao);
        
        LOGGER.debug("Initialized Service Authenticator");
        
        // Initialize service authorizer
        ServiceAuthorizer authorizer = new ServiceAuthorizer();
        
        LOGGER.debug("Initialized Service Authorizer");
        
        environment.jersey().register(
            new AuthDynamicFeature(
                new BasicCredentialAuthFilter.Builder<UserEntity>()
                    .setAuthenticator(authenticator)
                    .setAuthorizer(authorizer)
                    .setRealm("CERTIFICATE AUTHORITY API")
                    .buildAuthFilter()));
                    
        LOGGER.debug("Initialized Auth Dynamic Feature");
        
        // Register roles allowed dynamic feature
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        //If you want to use @Auth to inject a custom Principal type into your resource
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(UserEntity.class));
    }
    
}
