package com.github.bbijelic.ca.api.certificate.profiles.store;

import java.util.Optional;

import com.github.bbijelic.ca.api.certificate.profiles.entity.CertificateProfile;

/**
 * Certificate Profiles store
 */
public class CertificateProfilesStore {
    
    /**
     * Finds certificate profile by an ID
     * 
     * @param id the certificate profile id
     * @return the certificate
     */
    public Optional<CertificateProfile> findById(Long id){
        CertificateProfile certificateProfile = new CertificateProfile();
        certificateProfile.setId(id);
        certificateProfile.setName("Test Certificate Profile Name");
        certificateProfile.setDescription("Test Certificate Profile Name");
        
        return Optional.ofNullable(certificateProfile);
    }
    
}
