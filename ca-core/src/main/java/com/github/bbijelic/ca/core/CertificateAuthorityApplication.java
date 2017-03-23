package com.github.bbijelic.ca.core;

import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bbijelic.ca.core.config.CertificateAuthorityConfiguration;
import com.github.bbijelic.ca.db.entity.CertificateAuthorityEntity;

/**
 * Certificate authority application
 * 
 * @author Bojan Bijelić
 */
public class CertificateAuthorityApplication extends Application<CertificateAuthorityConfiguration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CertificateAuthorityApplication.class);

    @Override
    public String getName() {
        return "certificate-authority";
    }

    /**
     * Hibernate bundle initialization
     */
    private final HibernateBundle<CertificateAuthorityConfiguration> hibernate =
         new HibernateBundle<CertificateAuthorityConfiguration>(CertificateAuthorityEntity.class) {
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
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(CertificateAuthorityConfiguration config, Environment env) throws Exception {
        LOGGER.info("Running Certificate Authority Service");
    }

    public static void main(String[] args) throws Exception {
        new CertificateAuthorityApplication().run(new String[]{"server", System.getProperty("service.config")});
    }

}
