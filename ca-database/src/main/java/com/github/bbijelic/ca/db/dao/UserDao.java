package com.github.bbijelic.ca.db.dao;

import io.dropwizard.hibernate.AbstractDAO;

import java.util.Optional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.github.bbijelic.ca.db.entity.UserEntity;

/**
 * User DAO
 * 
 * @author Bojan Bijelić
 */
public class UserDao extends AbstractDAO<UserEntity>{
    
    /**
     * Constructor
     */
    public UserDao(SessionFactory factory) {
        super(factory);
    }
    
    /**
     * Finds user by email
     * 
     * @param email the user email
     * @return the user entity
     */
    public Optional<UserEntity> findByEmail(String email){
        return Optional.ofNullable((UserEntity) criteria().add(Restrictions.eq("email", email)).uniqueResult());
    }
}
