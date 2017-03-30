package com.github.bbijelic.ca.service;

import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bbijelic.ca.api.certificate.profiles.CertificateProfilesApiBundle;
import com.github.bbijelic.ca.api.certificate.profiles.guice.CertificateProfilesApiGuiceModule;
import com.github.bbijelic.ca.config.CertificateAuthorityConfiguration;
import com.github.bbijelic.ca.db.entity.CertificateAuthorityEntity;
import com.github.bbijelic.ca.security.BasicAuthenticationBundle;
import com.hubspot.dropwizard.guice.GuiceBundle;

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
                CertificateAuthorityEntity.class) {
             
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
    
    /**
     * Google Guice drependency injection
     */
    private GuiceBundle<CertificateAuthorityConfiguration> guiceBundle;

    @Override
    public void initialize(Bootstrap<CertificateAuthorityConfiguration> bootstrap) {
        super.initialize(bootstrap);

        LOGGER.info("Initializing Certificate Authority Service");

        // Initializing google guice dependency injection
        guiceBundle = GuiceBundle.<CertificateAuthorityConfiguration>newBuilder()
            .addModule(new CertificateProfilesApiGuiceModule())
            .setConfigClass(CertificateAuthorityConfiguration.class)
            .build();

        // Add guice bundle
        bootstrap.addBundle(guiceBundle);

        // Add hibernate bundle
        bootstrap.addBundle(hibernateBundle);
        
        // Add Basic authentication bundle
        bootstrap.addBundle(new BasicAuthenticationBundle());
        
        // Add Certificate Profiles API bundle
        bootstrap.addBundle(guiceBundle.getInjector().getInstance(CertificateProfilesApiBundle.class));
                    
    }
        
    @Override
    public void run(CertificateAuthorityConfiguration config, Environment environment) throws Exception {
        LOGGER.info("Running Certificate Authority Service");
    }
    
    public static void main(String[] args) throws Exception {
        new CertificateAuthorityService().run(new String[]{"server", System.getProperty("service.config")});
    }

}
