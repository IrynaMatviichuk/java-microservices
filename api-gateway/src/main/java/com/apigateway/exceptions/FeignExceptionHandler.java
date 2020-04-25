package com.apigateway.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class FeignExceptionHandler {

    @ExceptionHandler(FeignException.BadRequest.class)
    public ResponseEntity handleFeignStatusException(FeignException ex) throws JsonProcessingException {
        return ResponseEntity.status(ex.status()).body(new ObjectMapper().readValue(ex.contentUTF8(), HashMap.class));
    }
}
