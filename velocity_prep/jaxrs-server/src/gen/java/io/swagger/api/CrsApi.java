package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.CrsApiService;
import io.swagger.api.factories.CrsApiServiceFactory;

import io.swagger.annotations.ApiParam;

import com.sun.jersey.multipart.FormDataParam;

import io.swagger.model.CRListModel;
import io.swagger.model.CRModel;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/crs")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(value = "/crs", description = "the crs API")
public class CrsApi  {

   private final CrsApiService delegate = CrsApiServiceFactory.getCrsApi();

    @GET
    @Path("/")
    
    
    @io.swagger.annotations.ApiOperation(value = "Get a list of all CRs", notes = "Returns a list of all CRs.", response = CRListModel.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "The result is an array of CRs") })

    public Response getAllCRs()
    throws NotFoundException {
    return delegate.getAllCRs();
    }
    @GET
    @Path("/list")
    
    
    @io.swagger.annotations.ApiOperation(value = "Get a list of CRs by date", notes = "Returns a list of CRs", response = CRListModel.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "An array of CRs for given date range") })

    public Response findCRsbyDate(@ApiParam(value = "Start date for list of CRs, inclusive") @QueryParam("start") String start,
    @ApiParam(value = "End date for list of CRs, exclusive") @QueryParam("end") String end)
    throws NotFoundException {
    return delegate.findCRsbyDate(start,end);
    }
    @GET
    @Path("/{cr_id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Get a single CR", notes = "Returns a single CR based on a CR ID", response = CRModel.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "CR response"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "CR not found.") })

    public Response findCRbyID(@ApiParam(value = "ID of CR to fetch",required=true ) @PathParam("cr_id") Integer crId)
    throws NotFoundException {
    return delegate.findCRbyID(crId);
    }
}

