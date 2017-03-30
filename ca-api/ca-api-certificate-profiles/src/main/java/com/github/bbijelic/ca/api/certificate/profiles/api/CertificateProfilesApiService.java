package com.github.bbijelic.ca.api.certificate.profiles.api;

import com.github.bbijelic.ca.api.certificate.profiles.api.*;
import com.github.bbijelic.ca.api.certificate.profiles.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import com.github.bbijelic.ca.api.certificate.profiles.model.CertificateProfile;

import java.util.List;
import com.github.bbijelic.ca.api.certificate.profiles.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-03-30T21:23:36.037Z")
public abstract class CertificateProfilesApiService {
    public abstract Response createCertificateProfile(CertificateProfile certificateProfile,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteCertificateProfile(Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response readAllCertificateProfiles(SecurityContext securityContext) throws NotFoundException;
    public abstract Response readCertificateProfile(Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateCertificateProfile(Long id,CertificateProfile certificateProfile,SecurityContext securityContext) throws NotFoundException;
}
