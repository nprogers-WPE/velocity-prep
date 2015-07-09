package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.ZabbixApiService;
import io.swagger.api.factories.ZabbixApiServiceFactory;

import io.swagger.annotations.ApiParam;

import com.sun.jersey.multipart.FormDataParam;

import io.swagger.model.ZabbixListModel;
import io.swagger.model.ZabbixModel;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/zabbix")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(value = "/zabbix", description = "the zabbix API")
public class ZabbixApi  {

   private final ZabbixApiService delegate = ZabbixApiServiceFactory.getZabbixApi();

    @GET
    @Path("/")
    
    
    @io.swagger.annotations.ApiOperation(value = "Get a list of all zabbix errors", notes = "Returns a list of all zabbix errors.", response = ZabbixListModel.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "The result is an array of zabbix errors") })

    public Response getAllZabbixErrors()
    throws NotFoundException {
    return delegate.getAllZabbixErrors();
    }
    @GET
    @Path("/list")
    
    
    @io.swagger.annotations.ApiOperation(value = "Get a list of zabbix errors by date", notes = "Returns a list of zabbix errors", response = ZabbixListModel.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "An array of zabbix errors for given date range") })

    public Response findZabbixbyDate(@ApiParam(value = "Start date for list of zabbix errors, inclusive") @QueryParam("start") String start,
    @ApiParam(value = "End date for list of zabbix errors, exclusive") @QueryParam("end") String end)
    throws NotFoundException {
    return delegate.findZabbixbyDate(start,end);
    }
    @GET
    @Path("/{zabbix_id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Get a single zabbix error", notes = "Returns a single zabbix error based on a ticket ID", response = ZabbixModel.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Zabbix error response"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Zabbix error not found.") })

    public Response findZabbixbyID(@ApiParam(value = "ID of zabbix error to fetch",required=true ) @PathParam("zabbix_id") Integer zabbixId)
    throws NotFoundException {
    return delegate.findZabbixbyID(zabbixId);
    }
}

