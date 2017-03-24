package com.github.bbijelic.ca.service;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.UnitOfWorkAwareProxyFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bbijelic.ca.config.CertificateAuthorityConfiguration;
import com.github.bbijelic.ca.db.dao.UserDao;
import com.github.bbijelic.ca.db.entity.CertificateAuthorityEntity;
import com.github.bbijelic.ca.db.entity.UserEntity;
import com.github.bbijelic.ca.security.ServiceAuthenticator;
import com.github.bbijelic.ca.security.ServiceAuthorizer;
import com.github.bbijelic.ca.security.TestSecurityResource;

/**
 * Certificate authority application
 * 
 * @author Bojan Bijelić
 */
public class CertificateAuthorityService extends Application<CertificateAuthorityConfiguration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CertificateAuthorityService.class);

    @Override
    public String getName() {
        return "certificate-authority";
    }

    /**
     * Hibernate bundle initialization
     */
    private final HibernateBundle<CertificateAuthorityConfiguration> hibernateBundle =
         new HibernateBundle<CertificateAuthorityConfiguration>(CertificateAuthorityEntity.class, UserEntity.class) {
             public PooledDataSourceFactory getDataSourceFactory(CertificateAuthorityConfiguration config) {
                 return config.getDatabaseConfiguration()
                              .getDataSourceFactory();
             }
         };

    @Override
    public void initialize(Bootstrap<CertificateAuthorityConfiguration> bootstrap) {
        super.initialize(bootstrap);

        LOGGER.info("Initializing Certificate Authority Service");

        // Add hibernate bundle
        bootstrap.addBundle(hibernateBundle);
                    
    }

    @Override
    public void run(CertificateAuthorityConfiguration config, Environment environment) throws Exception {
        LOGGER.info("Running Certificate Authority Service");
                
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
        
        environment.jersey().register(new TestSecurityResource());
    }

    public static void main(String[] args) throws Exception {
        new CertificateAuthorityService().run(new String[]{"server", System.getProperty("service.config")});
    }

}
