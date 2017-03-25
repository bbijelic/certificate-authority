package com.github.bbijelic.ca.security.digest;

/**
 * Digest utils exception
 * 
 * @author Bojan Bijelić
 */
public class DigestUtilsException extends Exception {
    
    public static final long serialVersionUID = 1L;
    
    public DigestUtilsException(String message, Throwable cause){
        super(message, cause);
    }
    
}
