package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.PrsApiService;
import io.swagger.api.factories.PrsApiServiceFactory;

import io.swagger.annotations.ApiParam;

import com.sun.jersey.multipart.FormDataParam;

import io.swagger.model.PRListModel;
import io.swagger.model.PRModel;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/prs")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(value = "/prs", description = "the prs API")
public class PrsApi  {

   private final PrsApiService delegate = PrsApiServiceFactory.getPrsApi();

    @GET
    @Path("/")
    
    
    @io.swagger.annotations.ApiOperation(value = "Get a list of all PRs", notes = "Returns a list of all PRs.", response = PRListModel.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "The result is an array of PRs") })

    public Response getAllPRs()
    throws NotFoundException {
    return delegate.getAllPRs();
    }
    @GET
    @Path("/list")
    
    
    @io.swagger.annotations.ApiOperation(value = "Get a list of PRs by date", notes = "Returns a list of PRs", response = PRListModel.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "An array of PRs for given date range") })

    public Response findPRsbyDate(@ApiParam(value = "Start date for list of PRs, inclusive") @QueryParam("start") String start,
    @ApiParam(value = "End date for list of PRs, exclusive") @QueryParam("end") String end)
    throws NotFoundException {
    return delegate.findPRsbyDate(start,end);
    }
    @GET
    @Path("/{pr_id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Get a single PR", notes = "Returns a single PR based on a PR ID", response = PRModel.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "PR response"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "PR not found.") })

    public Response findPRbyID(@ApiParam(value = "ID of PR to fetch",required=true ) @PathParam("pr_id") Integer prId)
    throws NotFoundException {
    return delegate.findPRbyID(prId);
    }
}

