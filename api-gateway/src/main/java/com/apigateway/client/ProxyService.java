package com.apigateway.client;

import com.apigateway.responses.Apartment;
import com.apigateway.responses.Response;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Component
public class ProxyService {

    private static final String BACKEND_A = "service";

    @Autowired
    ApartmentsServiceClient apartmentsServiceClient;

    @CircuitBreaker(name = BACKEND_A, fallbackMethod = "fallback")
    public Response findAll() {
        return apartmentsServiceClient.findAll();
    }

    @Retry(name = BACKEND_A)
    public Apartment add(Apartment apartment) {
        return apartmentsServiceClient.add(apartment);
    }

    @Retry(name = BACKEND_A)
    public  Apartment update(Apartment apartment) {
        return apartmentsServiceClient.update(apartment);
    }

    @Retry(name = BACKEND_A)
    public String deleteById(@PathVariable Long id) {
        return apartmentsServiceClient.deleteById(id);
    }

    public Response fallback(Throwable e) {
        return new Response(null, new ArrayList<>());
    }
}
