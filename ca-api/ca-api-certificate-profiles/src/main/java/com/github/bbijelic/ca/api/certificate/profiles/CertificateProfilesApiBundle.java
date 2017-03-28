package com.github.bbijelic.ca.api.certificate.profiles;

import io.dropwizard.Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.swagger.config.ScannerFactory;
import io.swagger.jaxrs.config.DefaultJaxrsScanner;
import io.swagger.jaxrs.listing.ApiListingResource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
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
        
        env.jersey().register(new ApiListingResource());
        // Swagger providers
        env.jersey().register(new JacksonJsonProvider());
        
        // Swagger Scanner, which finds all the resources for @Api Annotations
        ScannerFactory.setScanner(new DefaultJaxrsScanner());
        
    }
    
}
