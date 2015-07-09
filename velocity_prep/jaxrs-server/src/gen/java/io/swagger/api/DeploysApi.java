package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.DeploysApiService;
import io.swagger.api.factories.DeploysApiServiceFactory;

import io.swagger.annotations.ApiParam;

import com.sun.jersey.multipart.FormDataParam;

import io.swagger.model.DeployListModel;
import io.swagger.model.DeployModel;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/deploys")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(value = "/deploys", description = "the deploys API")
public class DeploysApi  {

   private final DeploysApiService delegate = DeploysApiServiceFactory.getDeploysApi();

    @GET
    @Path("/")
    
    
    @io.swagger.annotations.ApiOperation(value = "Get a list of all deploys", notes = "Returns a list of all deploys.", response = DeployListModel.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "The result is an array of deploys") })

    public Response deploysGet()
    throws NotFoundException {
    return delegate.deploysGet();
    }
    @GET
    @Path("/list")
    
    
    @io.swagger.annotations.ApiOperation(value = "Get a list of deploys by date", notes = "Returns a list of deploys", response = DeployListModel.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "An array of deploys for given date range") })

    public Response findDeploysbyDate(@ApiParam(value = "Start date for list of deploys, inclusive") @QueryParam("start") String start,
    @ApiParam(value = "End date for list of deploys, exclusive") @QueryParam("end") String end)
    throws NotFoundException {
    return delegate.findDeploysbyDate(start,end);
    }
    @GET
    @Path("/{repo}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Get a list of all deploys for a repo", notes = "Returns an array of deploys for a single repo", response = DeployListModel.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "deploy response"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Repo not found.") })

    public Response findDeploysByRepo(@ApiParam(value = "Repo name for list of deploys",required=true ) @PathParam("repo") String repo)
    throws NotFoundException {
    return delegate.findDeploysByRepo(repo);
    }
    @GET
    @Path("/{repo}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Get a list of all deploys for a repo", notes = "Returns an array of deploys for a single repo", response = DeployListModel.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "deploy response"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Repo not found.") })

    public Response findDeploysByRepo_1(@ApiParam(value = "Repo name for list of deploys",required=true ) @PathParam("repo") String repo)
    throws NotFoundException {
    return delegate.findDeploysByRepo_1(repo);
    }
    @GET
    @Path("/{repo}/list")
    
    
    @io.swagger.annotations.ApiOperation(value = "Get a list of all deploys for a repo for a given date range", notes = "Returns an array of deploys for a single repo and date range", response = DeployListModel.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "deploy response"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Repo not found.") })

    public Response findDeploysByRepoAndDate(@ApiParam(value = "Repo name for list of deploys",required=true ) @PathParam("repo") String repo,
    @ApiParam(value = "Start date for list of deploys, inclusive") @QueryParam("start") String start,
    @ApiParam(value = "End date for list of deploys, exclusive") @QueryParam("end") String end)
    throws NotFoundException {
    return delegate.findDeploysByRepoAndDate(repo,start,end);
    }
    @GET
    @Path("/{repo}/list")
    
    
    @io.swagger.annotations.ApiOperation(value = "Get a list of all deploys for a repo for a given date range", notes = "Returns an array of deploys for a single repo and date range", response = DeployListModel.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "deploy response"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Repo not found.") })

    public Response findDeploysByRepoAndDate_2(@ApiParam(value = "Repo name for list of deploys",required=true ) @PathParam("repo") String repo,
    @ApiParam(value = "Start date for list of deploys, inclusive") @QueryParam("start") String start,
    @ApiParam(value = "End date for list of deploys, exclusive") @QueryParam("end") String end)
    throws NotFoundException {
    return delegate.findDeploysByRepoAndDate_2(repo,start,end);
    }
    @GET
    @Path("/{repo}/{version}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Get a single deploy with this version number", notes = "Returns a single deploy", response = DeployModel.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "deploy response"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Version not found.") })

    public Response findDeploysByVersion(@ApiParam(value = "Repo name for deploy",required=true ) @PathParam("repo") String repo,
    @ApiParam(value = "Version of deploy",required=true ) @PathParam("version") String version)
    throws NotFoundException {
    return delegate.findDeploysByVersion(repo,version);
    }
    @GET
    @Path("/{repo}/{version}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Get a single deploy with this version number", notes = "Returns a single deploy", response = DeployModel.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "deploy response"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Version not found.") })

    public Response findDeploysByVersion_3(@ApiParam(value = "Repo name for deploy",required=true ) @PathParam("repo") String repo,
    @ApiParam(value = "Version of deploy",required=true ) @PathParam("version") String version)
    throws NotFoundException {
    return delegate.findDeploysByVersion_3(repo,version);
    }
}

