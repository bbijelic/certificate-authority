package com.github.bbijelic.ca.api.certificate.profiles;

import io.dropwizard.Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bbijelic.ca.api.certificate.profiles.CertificateProfilesApiService;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Certificate profile API bundle
 * 
 * @author Bojan Bijelić
 */
@Singleton
public class CertificateProfilesApiBundle implements Bundle {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CertificateProfilesApiBundle.class);
    
    @Override
    public void initialize(Bootstrap< ? > arg0) {

    }
    
    /**
     * Certificate profiles API service
     */
    private CertificateProfilesApiService apiService;
    
    /**
     * Constructor
     * 
     * @param apiService the Certificate Profiles API service
     */
    @Inject
    public CertificateProfilesApiBundle(CertificateProfilesApiService apiService){
        this.apiService = apiService;
    }
              
    @Override
    public void run(Environment env) {    
        LOGGER.info("Registering CertificateProfilesApi resource");
        
        // Register the certificate profile API
        env.jersey().register(apiService);        
    }
    
}
