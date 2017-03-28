package com.github.bbijelic.ca.api.certificate.profiles.api;

import com.github.bbijelic.ca.api.certificate.profiles.model.*;
import com.github.bbijelic.ca.api.certificate.profiles.api.CertificateProfilesApiService;
import com.github.bbijelic.ca.api.certificate.profiles.api.factories.CertificateProfilesApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import com.github.bbijelic.ca.api.certificate.profiles.model.CertificateProfile;

import java.util.List;
import com.github.bbijelic.ca.api.certificate.profiles.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/certificate-profiles")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the certificate-profiles API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-03-28T21:15:55.422Z")
public class CertificateProfilesApi  {
   private final CertificateProfilesApiService delegate = CertificateProfilesApiServiceFactory.getCertificateProfilesApi();

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Creates certificate profile", notes = "Creates certificate profile", response = void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "UserSecurity")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = void.class) })
    public Response createCertificateProfile(@ApiParam(value = "Certificate Profile Object" ,required=true) CertificateProfile certificateProfile
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createCertificateProfile(certificateProfile,securityContext);
    }
    @DELETE
    @Path("/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Deletes certificate profile", notes = "Deletes certificate profile identified by an ID", response = void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "UserSecurity")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not found", response = void.class) })
    public Response deleteCertificateProfile(@ApiParam(value = "ID of the certificate profile",required=true) @PathParam("id") Long id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteCertificateProfile(id,securityContext);
    }
    @GET
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Reads all certificate profiles", notes = "Reads all certificate profiles", response = CertificateProfile.class, responseContainer = "List", authorizations = {
        @io.swagger.annotations.Authorization(value = "UserSecurity")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = CertificateProfile.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not found", response = CertificateProfile.class, responseContainer = "List") })
    public Response readAllCertificateProfiles(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.readAllCertificateProfiles(securityContext);
    }
    @GET
    @Path("/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Reads certificate profile", notes = "Returns certificate profile identified by an ID", response = CertificateProfile.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "UserSecurity")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = CertificateProfile.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not found", response = CertificateProfile.class) })
    public Response readCertificateProfile(@ApiParam(value = "ID of the certificate profile",required=true) @PathParam("id") Long id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.readCertificateProfile(id,securityContext);
    }
    @PUT
    @Path("/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Updates certificate profile", notes = "Updates certificate profile identified by an ID", response = void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "UserSecurity")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not found", response = void.class) })
    public Response updateCertificateProfile(@ApiParam(value = "ID of the certificate profile",required=true) @PathParam("id") Long id
,@ApiParam(value = "Certificate Profile Object" ,required=true) CertificateProfile certificateProfile
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateCertificateProfile(id,certificateProfile,securityContext);
    }
}
