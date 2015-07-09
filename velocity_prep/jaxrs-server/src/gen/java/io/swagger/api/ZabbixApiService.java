package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import com.sun.jersey.multipart.FormDataParam;

import io.swagger.model.ZabbixListModel;
import io.swagger.model.ZabbixModel;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;

public abstract class ZabbixApiService {
  
      public abstract Response getAllZabbixErrors()
      throws NotFoundException;
  
      public abstract Response findZabbixbyDate(String start,String end)
      throws NotFoundException;
  
      public abstract Response findZabbixbyID(Integer zabbixId)
      throws NotFoundException;
  
}
