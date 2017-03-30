package com.github.bbijelic.ca.api.certificate.profiles.api.impl;

import com.github.bbijelic.ca.api.certificate.profiles.api.*;
import com.github.bbijelic.ca.api.certificate.profiles.model.*;

import com.github.bbijelic.ca.api.certificate.profiles.model.CertificateProfile;

import java.util.List;
import com.github.bbijelic.ca.api.certificate.profiles.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-03-30T21:44:00.224Z")
public class CertificateProfilesApiServiceImpl extends CertificateProfilesApiService {
    @Override
    public Response createCertificateProfile(CertificateProfile certificateProfile, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteCertificateProfile(Long id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response readAllCertificateProfiles(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response readCertificateProfile(Long id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateCertificateProfile(Long id, CertificateProfile certificateProfile, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
