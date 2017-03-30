package com.github.bbijelic.ca.api.certificate.profiles.entity;

/**
 * Certificate profile entity
 * 
 * @author Bojan Bijelić
 */
public class CertificateProfile {
   
    /**
     * ID
     */
    private Long id;
   
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
   
    /**
     * Certificate profile name
     */
    private String name;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Certificate profile description
     */
    private String description;
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
}
