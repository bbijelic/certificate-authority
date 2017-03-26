package com.github.bbijelic.ca.api.certificate.profiles;

import io.dropwizard.Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bbijelic.ca.api.certificate.profiles.api.CertificateProfilesApi;

/**
 * Certificate profile API bundle
 * 
 * @author Bojan Bijelić
 */
public class CertificateProfilesApiBundle implements Bundle {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CertificateProfilesApiBundle.class);
    
    @Override
    public void initialize(Bootstrap< ? > bootstrap) {
        
    }
    
    @Override
    public void run(Environment env) {    
        LOGGER.info("Registering CertificateProfilesApi resource");
        // Register the certificate profile API
        env.jersey().register(new CertificateProfilesApi());
        
    }
    
}
