package com.github.bbijelic.ca.api.certificate.profiles.api.impl;

import javax.annotation.security.PermitAll;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bbijelic.ca.api.certificate.profiles.api.ApiResponseMessage;
import com.github.bbijelic.ca.api.certificate.profiles.api.CertificateProfilesApiService;
import com.github.bbijelic.ca.api.certificate.profiles.api.NotFoundException;
import com.github.bbijelic.ca.api.certificate.profiles.model.CertificateProfile;

/**
 * Certificate profile API service implementation
 * 
 * @author Bojan Bijelić
 */
public class CertificateProfilesApiServiceImpl extends CertificateProfilesApiService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CertificateProfilesApiServiceImpl.class);

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
