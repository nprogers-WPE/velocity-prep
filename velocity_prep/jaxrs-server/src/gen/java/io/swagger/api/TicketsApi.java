package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.TicketsApiService;
import io.swagger.api.factories.TicketsApiServiceFactory;

import io.swagger.annotations.ApiParam;

import com.sun.jersey.multipart.FormDataParam;

import io.swagger.model.TicketListModel;
import io.swagger.model.TicketModel;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/tickets")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(value = "/tickets", description = "the tickets API")
public class TicketsApi  {

   private final TicketsApiService delegate = TicketsApiServiceFactory.getTicketsApi();

    @GET
    @Path("/")
    
    
    @io.swagger.annotations.ApiOperation(value = "Get a list of all tickets", notes = "Returns a list of all tickets.", response = TicketListModel.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "The result is an array of tickets") })

    public Response getAllTickets()
    throws NotFoundException {
    return delegate.getAllTickets();
    }
    @GET
    @Path("/list")
    
    
    @io.swagger.annotations.ApiOperation(value = "Get a list of tickets by date", notes = "Returns a list of tickets", response = TicketListModel.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "An array of tickets for given date range") })

    public Response findTicketsbyDate(@ApiParam(value = "Start date for list of tickets, inclusive") @QueryParam("start") String start,
    @ApiParam(value = "End date for list of tickets, exclusive") @QueryParam("end") String end)
    throws NotFoundException {
    return delegate.findTicketsbyDate(start,end);
    }
    @GET
    @Path("/{ticket_id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Get a single ticket", notes = "Returns a single ticket based on a ticket ID", response = TicketModel.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Ticket response"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "ticket not found.") })

    public Response findTicketbyID(@ApiParam(value = "ID of ticket to fetch",required=true ) @PathParam("ticket_id") Integer ticketId)
    throws NotFoundException {
    return delegate.findTicketbyID(ticketId);
    }
}

