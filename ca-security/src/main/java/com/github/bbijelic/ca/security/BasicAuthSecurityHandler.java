package com.github.bbijelic.ca.security;

import org.eclipse.jetty.security.ConstraintMapping;
import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.security.SecurityHandler;
import org.eclipse.jetty.util.security.Constraint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Basic authentication security handler
 * 
 * @author Bojan Bijelić
 */
public class BasicAuthSecurityHandler {
    
    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BasicAuthSecurityHandler.class);
    
    private HashLoginService loginService;
    
    private String configFile;
    
    public BasicAuthSecurityHandler(String configFile){
        this.configFile = configFile;
        
        initializeLoginService();
        initializeConstraint();
        initializeSecurityHandler();
    }
        
    private void initializeLoginService(){
        LOGGER.info("Initializing Login Service");        
        loginService = new HashLoginService();
        loginService.setName("CertificateAuthorityRealm");
        loginService.setConfig(configFile);     
        loginService.setHotReload(true);
    }
    
    private Constraint constraint;
    private ConstraintMapping constraintMapping;
    
    private final static String ROLE = "ADMIN";
    
    private void initializeConstraint(){
        LOGGER.info("Initializing Constraint");
        constraint = new Constraint();
        constraint.setName(Constraint.__BASIC_AUTH);
        constraint.setAuthenticate(true);
        constraint.setRoles(new String[]{ROLE});
        
        constraintMapping = new ConstraintMapping();
        constraintMapping.setConstraint(this.constraint);
        constraintMapping.setPathSpec("/*");
    }
    
    private ConstraintSecurityHandler securityHandler;
    
    private void initializeSecurityHandler(){
        LOGGER.info("Initializing Security Handler");
        securityHandler = new ConstraintSecurityHandler();
        securityHandler.setAuthenticator(new org.eclipse.jetty.security.authentication.BasicAuthenticator());
        securityHandler.setRealmName("CertificateAuthorityRealm");
        securityHandler.addConstraintMapping(this.constraintMapping);
        securityHandler.setLoginService(this.loginService);
    }
    
    public SecurityHandler getSecurityHandler(){
        return this.securityHandler;
    }
}
