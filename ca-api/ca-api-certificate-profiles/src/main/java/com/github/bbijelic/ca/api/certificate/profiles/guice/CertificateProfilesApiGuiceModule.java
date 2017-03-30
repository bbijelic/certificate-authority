package com.github.bbijelic.ca.api.certificate.profiles.guice;

import com.github.bbijelic.ca.api.certificate.profiles.CertificateProfilesApiBundle;
import com.github.bbijelic.ca.api.certificate.profiles.CertificateProfilesApiService;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;

public class CertificateProfilesApiGuiceModule extends AbstractModule {
    
    @Override
    protected void configure() {
        
    }
    
    @Provides
    public CertificateProfilesApiService providesCertificateProfilesApiService(){
        return new CertificateProfilesApiService();
    }
    
    @Inject
    @Provides
    public CertificateProfilesApiBundle providesCertificateProfilesApiBundle(CertificateProfilesApiService apiService){
        return new CertificateProfilesApiBundle(apiService);
    }
        
}
