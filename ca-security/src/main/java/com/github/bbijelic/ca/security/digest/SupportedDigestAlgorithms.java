package com.github.bbijelic.ca.security.digest;

/**
 * Supported Digest Algorithms
 * 
 * @author Bojan Bijelić
 */
public enum SupportedDigestAlgorithms {
    
    /**
     * SHA-256 digest
     */
    SHA256("SHA-256");
    
    private String value;
    
    SupportedDigestAlgorithms(String value){
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
}
