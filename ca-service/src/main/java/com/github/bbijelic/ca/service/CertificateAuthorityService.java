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

import com.github.bbijelic.ca.api.certificate.profiles.CertificateProfilesApiBundle;
import com.github.bbijelic.ca.config.CertificateAuthorityConfiguration;
import com.github.bbijelic.ca.db.dao.PrincipalDao;
import com.github.bbijelic.ca.db.entity.CertificateAuthorityEntity;
import com.github.bbijelic.ca.db.entity.PrincipalEntity;
import com.github.bbijelic.ca.db.entity.RoleEntity;
import com.github.bbijelic.ca.security.ServiceAuthenticator;
import com.github.bbijelic.ca.security.ServiceAuthorizer;

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
         new HibernateBundle<CertificateAuthorityConfiguration>(
                CertificateAuthorityEntity.class, 
                PrincipalEntity.class, 
                RoleEntity.class) {
             
             /**
              * Data source factory getter
              * @param config the service configuration
              * 
              * @return the pooled data source factory
              */
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
        
        bootstrap.addBundle(new CertificateProfilesApiBundle());
                    
    }

    @Override
    public void run(CertificateAuthorityConfiguration config, Environment environment) throws Exception {
        LOGGER.info("Running Certificate Authority Service");
                
        SessionFactory sessionFactory = hibernateBundle.getSessionFactory();
        
        LOGGER.debug("Obtained session factory");
        
        // Initialize principal dao
        PrincipalDao principalDao = new PrincipalDao(sessionFactory);
        
        LOGGER.debug("Initialized User DAO");
        
        // Initialize service authenticator
        ServiceAuthenticator authenticator = 
            new UnitOfWorkAwareProxyFactory(hibernateBundle)
                .create(ServiceAuthenticator.class, PrincipalDao.class, principalDao);
        
        LOGGER.debug("Initialized Service Authenticator");
        
        // Initialize service authorizer
        ServiceAuthorizer authorizer = new ServiceAuthorizer();
        
        LOGGER.debug("Initialized Service Authorizer");
        
        environment.jersey().register(
            new AuthDynamicFeature(
                new BasicCredentialAuthFilter.Builder<PrincipalEntity>()
                    .setAuthenticator(authenticator)
                    .setAuthorizer(authorizer)
                    .setRealm("CERTIFICATE-AUTHORITY-API")
                    .buildAuthFilter()));
                    
        LOGGER.debug("Initialized Auth Dynamic Feature");
        
        // Register roles allowed dynamic feature
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        //If you want to use @Auth to inject a custom Principal type into your resource
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(PrincipalEntity.class));
        
    }

    public static void main(String[] args) throws Exception {
        new CertificateAuthorityService().run(new String[]{"server", System.getProperty("service.config")});
    }

}
