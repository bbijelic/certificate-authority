package com.github.bbijelic.ca.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bbijelic.ca.db.entity.PrincipalEntity;
import com.github.bbijelic.ca.db.entity.RoleEntity;

import io.dropwizard.auth.Authorizer;

/**
 * Service authorizer
 * 
 * @author Bojan Bijelić
 */
public class ServiceAuthorizer implements Authorizer<PrincipalEntity> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceAuthorizer.class);
    
    @Override
    public boolean authorize(PrincipalEntity principalEntity, String role) {
        LOGGER.info("Authorizing user '{}' for the role '{}'", principalEntity.getName(), role);
        
        // Loop through all principal roles and check
        for(RoleEntity roleEntity : principalEntity.getRoles()){
            if(roleEntity.getSlug().equalsIgnoreCase(role)) return true;
        }
        
        return false;
    }
    
}
