package com.apigateway.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class FeignExceptionHandler {

    @ExceptionHandler(FeignException.BadRequest.class)
    public Map<String, Object> handleFeignStatusException(FeignException ex) throws JSONException {
        return new JSONObject(ex.contentUTF8()).toMap();
    }
}
