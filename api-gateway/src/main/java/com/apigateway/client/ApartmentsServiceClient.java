package com.apigateway.client;

import com.apigateway.responses.Apartment;
import com.apigateway.responses.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "service", configuration = ApartmentsServiceClientConfig.class)
public interface ApartmentsServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/test", consumes = "application/json")
    Apartment test();

    @RequestMapping(method = RequestMethod.GET, value = "/apartments/all", consumes = "application/json")
    Response findAll();

    @RequestMapping(method = RequestMethod.POST, value = "/apartments/add", consumes = "application/json")
    Apartment add(@RequestBody Apartment apartment);

    @RequestMapping(method = RequestMethod.POST, value = "/apartments/add", consumes = "application/json")
    Apartment update(@RequestBody Apartment apartment);

    @RequestMapping(method = RequestMethod.GET, value = "/apartments/delete/{id}")
    String deleteById(@PathVariable Long id);
}
