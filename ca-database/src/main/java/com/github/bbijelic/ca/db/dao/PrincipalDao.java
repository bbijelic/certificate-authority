package com.github.bbijelic.ca.db.dao;

import io.dropwizard.hibernate.AbstractDAO;

import java.util.Optional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.github.bbijelic.ca.db.entity.PrincipalEntity;

/**
 * Principal DAO
 * 
 * @author Bojan Bijelić
 */
public class PrincipalDao extends AbstractDAO<PrincipalEntity>{
    
    /**
     * Constructor
     */
    public PrincipalDao(SessionFactory factory) {
        super(factory);
    }
    
    /**
     * Finds principal by email
     * 
     * @param email the principal email
     * @return the principal entity
     */
    public Optional<PrincipalEntity> findByEmail(String email){
        return Optional.ofNullable((PrincipalEntity) criteria().add(Restrictions.eq("email", email)).uniqueResult());
    }
}
