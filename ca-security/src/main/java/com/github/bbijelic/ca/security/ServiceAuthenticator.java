package com.github.bbijelic.ca.security;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.hibernate.UnitOfWork;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bbijelic.ca.db.dao.UserDao;
import com.github.bbijelic.ca.db.entity.UserEntity;

/**
 * Service authenticator
 * 
 * @author Bojan Bijelić
 */
public class ServiceAuthenticator implements Authenticator<BasicCredentials, UserEntity> {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceAuthenticator.class);
    
    /**
     * User DAO
     */
    private UserDao userDao;
    
    /**
     * Constructor
     * 
     * @param userDao the user dao
     */
    public ServiceAuthenticator(UserDao userDao){
        this.userDao = userDao;
    }
        
    @Override
    @UnitOfWork
    public Optional<UserEntity> authenticate(BasicCredentials credentials) throws AuthenticationException {
        
        LOGGER.info("Authenticating user: {}", credentials.getUsername());
        
        Optional<UserEntity> userOptional = userDao.findByEmail(credentials.getUsername());
        if(userOptional.isPresent()){
            UserEntity userEntity = userOptional.get();
            if(userEntity.getPassword().equals(credentials.getPassword())){
                return userOptional;
            }
        }
        
        return Optional.empty();
    }
    
}
