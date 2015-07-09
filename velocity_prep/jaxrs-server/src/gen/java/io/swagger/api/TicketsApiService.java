package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import com.sun.jersey.multipart.FormDataParam;

import io.swagger.model.TicketListModel;
import io.swagger.model.TicketModel;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;

public abstract class TicketsApiService {
  
      public abstract Response getAllTickets()
      throws NotFoundException;
  
      public abstract Response findTicketsbyDate(String start,String end)
      throws NotFoundException;
  
      public abstract Response findTicketbyID(Integer ticketId)
      throws NotFoundException;
  
}
