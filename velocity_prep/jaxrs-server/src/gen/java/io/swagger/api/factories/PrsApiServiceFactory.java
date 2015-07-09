package io.swagger.api.factories;

import io.swagger.api.PrsApiService;
import io.swagger.api.impl.PrsApiServiceImpl;

public class PrsApiServiceFactory {

   private final static PrsApiService service = new PrsApiServiceImpl();

   public static PrsApiService getPrsApi()
   {
      return service;
   }
}
