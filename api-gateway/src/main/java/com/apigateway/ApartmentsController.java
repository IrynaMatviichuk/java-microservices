package com.apigateway;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class ApartmentsController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/apartments/all")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String allApartments() {
        String response = restTemplate.exchange(
                "http://client/apartments/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>() {}).getBody();
        System.out.println(response.getClass());
        return response;
    }

    @PostMapping("/apartments/add")
//    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public void createApartment() {
        Apartments apartments = new Apartments();
//        HttpEntity<Apartments> requestBody = new HttpEntity<>(apartments);
        System.out.println("\n\n\nhere");
        Apartments response = restTemplate.postForObject(
                "http://client/apartments/create",
                apartments,
                Apartments.class
        );

        System.out.println(response);
    }

    public String fallbackMethod() {
        return "error";
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
