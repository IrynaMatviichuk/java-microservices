package com.euclient.exceptions;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class ValidationExceptionAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest requestAttributes, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, false);
        Throwable error = getError(requestAttributes);
        if (error instanceof ValidationException) {
            errorAttributes.put("errors", ((ValidationException) error).getErrors());
        }

        return errorAttributes;
    }
}
