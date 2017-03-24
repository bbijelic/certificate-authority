package com.github.bbijelic.ca.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bbijelic.ca.db.entity.UserEntity;

import io.dropwizard.auth.Authorizer;

/**
 * Service authorizer
 * 
 * @author Bojan Bijelić
 */
public class ServiceAuthorizer implements Authorizer<UserEntity> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceAuthorizer.class);
    
    @Override
    public boolean authorize(UserEntity userEntity, String role) {
        LOGGER.info("Authorizing user '{}' for the role '{}'", userEntity.getName(), role);
        return (userEntity.getRole().equalsIgnoreCase(role)) ? true : false;
    }
    
}
