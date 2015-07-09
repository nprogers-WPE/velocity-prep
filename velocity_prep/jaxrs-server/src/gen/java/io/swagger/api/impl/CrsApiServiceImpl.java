package io.swagger.api.impl;

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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CrsApiServiceImpl extends CrsApiService {
  
      @Override
      public Response getAllCRs()
      throws NotFoundException {
          // load all crs from file into list
          // for each of these, create a new CR object
          // and add it to the list
          // create a new cr list object
          // set the count
          // set the list
          String csvFile = "/Users/natalie.rogers/velocity_prep/jaxrs-server/crs.csv";
          BufferedReader br = null;
          String line = "";
          String cvsSplitBy = ",";

          try {

              br = new BufferedReader(new FileReader(csvFile));
              while ((line = br.readLine()) != null) {

                  // use comma as separator
                  String[] stuff = line.split(cvsSplitBy);

                  System.out.println(stuff.toString());

              }

          } catch (FileNotFoundException e) {
              e.printStackTrace();
          } catch (IOException e) {
              e.printStackTrace();
          } finally {
              if (br != null) {
                  try {
                      br.close();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }
          }

          System.out.println("Done");
          return null;
          //return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
      }
  
      @Override
      public Response findCRsbyDate(String start,String end)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }
  
      @Override
      public Response findCRbyID(Integer crId)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }
  
}
