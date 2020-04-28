package com.euclient.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApartmentDoesNotExistException extends RuntimeException {
    public ApartmentDoesNotExistException() {
        super("There is no apartment with such id");
    }
}
