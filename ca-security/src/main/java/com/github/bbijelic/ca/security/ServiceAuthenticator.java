package com.github.bbijelic.ca.security;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.hibernate.UnitOfWork;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bbijelic.ca.db.dao.PrincipalDao;
import com.github.bbijelic.ca.db.entity.PrincipalEntity;
import com.github.bbijelic.ca.security.digest.DigestUtils;
import com.github.bbijelic.ca.security.digest.DigestUtilsException;
import com.github.bbijelic.ca.security.digest.SupportedDigestAlgorithms;

/**
 * Service authenticator
 * 
 * @author Bojan Bijelić
 */
public class ServiceAuthenticator implements Authenticator<BasicCredentials, PrincipalEntity> {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceAuthenticator.class);
    
    /**
     * User DAO
     */
    private PrincipalDao principalDao;
    
    /**
     * Constructor
     * 
     * @param principalDao the user dao
     */
    public ServiceAuthenticator(PrincipalDao principalDao){
        this.principalDao = principalDao;
    }
    
    /**
     * Authenticates principal with provided basic credentials
     */
    @Override
    @UnitOfWork
    public Optional<PrincipalEntity> authenticate(BasicCredentials credentials) throws AuthenticationException {
        LOGGER.info("Authenticating user: {}", credentials.getUsername());
        // Find the principal in database
        Optional<PrincipalEntity> principalOptional = principalDao.findByEmail(credentials.getUsername());
        
        if(principalOptional.isPresent()){
            // Extract principal entity from optional
            PrincipalEntity principalEntity = principalOptional.get();
            
            // Salted password
            String saltedPassword = credentials.getPassword() + ":" + principalEntity.getSalt();
            
            try {
        
                // SHA-256 salted password digest
                String saltedPasswordDigest = DigestUtils.digest(SupportedDigestAlgorithms.SHA256, saltedPassword);
        
                // Compare password
                if(principalEntity.getPassword().equals(saltedPasswordDigest)){
                    // Principal found, return optional
                    return principalOptional;
                }
                
            } catch(DigestUtilsException due){
                throw new AuthenticationException(due.getMessage(), due);
            }
        
        }
        
        // User not found, return empty optional
        return Optional.empty();
    }
    
}
