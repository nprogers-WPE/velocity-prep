package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import com.sun.jersey.multipart.FormDataParam;

import io.swagger.model.PRListModel;
import io.swagger.model.PRModel;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;

public abstract class PrsApiService {
  
      public abstract Response getAllPRs()
      throws NotFoundException;
  
      public abstract Response findPRsbyDate(String start,String end)
      throws NotFoundException;
  
      public abstract Response findPRbyID(Integer prId)
      throws NotFoundException;
  
}
