package com.github.bbijelic.ca.certificate.profiles;

import io.dropwizard.testing.junit.ResourceTestRule;

import org.junit.ClassRule;

import com.github.bbijelic.ca.api.certificate.profiles.api.CertificateProfilesApi;

/**
 * Certificate profiles API test
 * 
 * @author Bojan Bijelić
 */
public class CertificateProfilesApiTest {
    
    @ClassRule
    public static final ResourceTestRule resources 
        = ResourceTestRule.builder()
            .addResource(new CertificateProfilesApi())
            .build();
            
    public void testGetCertificateProfile(){
        
        resources.target("/certificate-profiles/10").request().get();
    }
    
}
