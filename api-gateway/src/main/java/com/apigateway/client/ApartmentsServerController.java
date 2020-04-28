package com.apigateway.client;

import com.apigateway.responses.Apartment;
import com.apigateway.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ApartmentsServerController {

    @Autowired
    ProxyService proxyService;

    @GetMapping("/apartments/all")
    @ResponseBody
    public Response findAll() {
        return  proxyService.findAll();
    }

    @PostMapping("/apartments/add")
    public Apartment add(@RequestBody Apartment apartment) {
        return this.proxyService.add(apartment);
    }

    @PostMapping("/apartments/update")
    public Apartment update(@RequestBody Apartment apartment) {
        return this.proxyService.update(apartment);
    }

    @GetMapping("/apartments/delete/{id}")
    public Map<String, String> deleteById(@PathVariable Long id) {
        return this.proxyService.deleteById(id);
    }
}
