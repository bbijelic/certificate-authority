package com.github.bbijelic.ca.security;

import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bbijelic.ca.db.entity.UserEntity;

/**
 * TODO REMOVE ME
 */
@Path("/test")
public class TestSecurityResource {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(TestSecurityResource.class);
        
    @GET
    @RolesAllowed("USER")
    public Response test(@Auth UserEntity userEntity){
        LOGGER.info("User accessed test: {}", userEntity.toString());
                
        return Response.ok().build();
    }
    
}
