package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import com.sun.jersey.multipart.FormDataParam;

import io.swagger.model.DeployListModel;
import io.swagger.model.DeployModel;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;

public abstract class DeploysApiService {
  
      public abstract Response deploysGet()
      throws NotFoundException;
  
      public abstract Response findDeploysbyDate(String start,String end)
      throws NotFoundException;
  
      public abstract Response findDeploysByRepo(String repo)
      throws NotFoundException;
  
      public abstract Response findDeploysByRepo_1(String repo)
      throws NotFoundException;
  
      public abstract Response findDeploysByRepoAndDate(String repo,String start,String end)
      throws NotFoundException;
  
      public abstract Response findDeploysByRepoAndDate_2(String repo,String start,String end)
      throws NotFoundException;
  
      public abstract Response findDeploysByVersion(String repo,String version)
      throws NotFoundException;
  
      public abstract Response findDeploysByVersion_3(String repo,String version)
      throws NotFoundException;
  
}
