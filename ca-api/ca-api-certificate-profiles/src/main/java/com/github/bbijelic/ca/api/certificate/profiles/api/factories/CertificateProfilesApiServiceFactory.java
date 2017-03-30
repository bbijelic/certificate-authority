package com.github.bbijelic.ca.api.certificate.profiles.api.factories;

import com.github.bbijelic.ca.api.certificate.profiles.api.CertificateProfilesApiService;
import com.github.bbijelic.ca.api.certificate.profiles.api.impl.CertificateProfilesApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-03-30T21:23:36.037Z")
public class CertificateProfilesApiServiceFactory {
    private final static CertificateProfilesApiService service = new CertificateProfilesApiServiceImpl();

    public static CertificateProfilesApiService getCertificateProfilesApi() {
        return service;
    }
}
