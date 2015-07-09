package io.swagger.api.factories;

import io.swagger.api.ZabbixApiService;
import io.swagger.api.impl.ZabbixApiServiceImpl;

public class ZabbixApiServiceFactory {

   private final static ZabbixApiService service = new ZabbixApiServiceImpl();

   public static ZabbixApiService getZabbixApi()
   {
      return service;
   }
}
