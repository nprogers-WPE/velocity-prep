package io.swagger.api.factories;

import io.swagger.api.DeploysApiService;
import io.swagger.api.impl.DeploysApiServiceImpl;

public class DeploysApiServiceFactory {

   private final static DeploysApiService service = new DeploysApiServiceImpl();

   public static DeploysApiService getDeploysApi()
   {
      return service;
   }
}
