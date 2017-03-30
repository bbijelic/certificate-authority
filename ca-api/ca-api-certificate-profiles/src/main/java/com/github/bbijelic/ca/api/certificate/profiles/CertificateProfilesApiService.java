package com.github.bbijelic.ca.api.certificate.profiles;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bbijelic.ca.api.certificate.profiles.model.CertificateProfile;
import com.google.inject.Singleton;

/**
 * Certificate profile API service implementation
 * 
 * @author Bojan Bijelić
 */
@Path("/certificate-profiles")
@Singleton
@SuppressWarnings("unused")
public class CertificateProfilesApiService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(CertificateProfilesApiService.class);
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCertificateProfile(CertificateProfile certificateProfile) {
        
        LOGGER.debug("Profile: {}", certificateProfile.toString());
        
        // do some magic!
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCertificateProfile(@PathParam("id") Long id) {
        // do some magic!
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response readAllCertificateProfiles() {
        // do some magic!
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readCertificateProfile(@PathParam("id") Long id) {
        // do some magic!
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCertificateProfile(@PathParam("id")Long id, CertificateProfile certificateProfile) {
        // do some magic!
        return Response.ok().build();
    }

}
