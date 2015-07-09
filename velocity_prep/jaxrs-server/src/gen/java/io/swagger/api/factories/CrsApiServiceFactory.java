package io.swagger.api.factories;

import io.swagger.api.CrsApiService;
import io.swagger.api.impl.CrsApiServiceImpl;

public class CrsApiServiceFactory {

   private final static CrsApiService service = new CrsApiServiceImpl();

   public static CrsApiService getCrsApi()
   {
      return service;
   }
}
