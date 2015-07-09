package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import com.sun.jersey.multipart.FormDataParam;

import io.swagger.model.CRListModel;
import io.swagger.model.CRModel;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;

public abstract class CrsApiService {
  
      public abstract Response getAllCRs()
      throws NotFoundException;
  
      public abstract Response findCRsbyDate(String start,String end)
      throws NotFoundException;
  
      public abstract Response findCRbyID(Integer crId)
      throws NotFoundException;
  
}
