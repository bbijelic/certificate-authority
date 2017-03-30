package com.github.bbijelic.ca.security;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Basic authentication bundle
 * 
 * @author Bojan Bijelić
 */
public class BasicAuthenticationBundle implements Bundle {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(BasicAuthenticationBundle.class);
    
    /**
     * Authentication configuration filename
     */
    private static final String AUTH_CONFIG_FILENAME = "auth.cfg";
    
    @Override
    public void initialize(Bootstrap< ? > bootstrap) {
        LOGGER.info("Initializing BasicAuthenticationBundle");
    }
    
    @Override
    public void run(Environment environment) {
        LOGGER.info("Running BasicAuthenticationBundle");
        
        // Get filename
        URL usersConfigfileUrl = BasicAuthenticationBundle.class.getClassLoader().getResource(AUTH_CONFIG_FILENAME);
        String usersConfigPath = usersConfigfileUrl.getPath();    
        
        // Set security handler
        BasicAuthSecurityHandler securityHandler = new BasicAuthSecurityHandler(usersConfigPath);
        environment.getApplicationContext().setSecurityHandler(securityHandler.getSecurityHandler());
    }
    
}
