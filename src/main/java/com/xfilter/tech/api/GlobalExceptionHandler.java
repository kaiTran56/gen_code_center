package com.xfilter.tech.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.context.MessageSource;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(value = { IllegalArgumentException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        Locale locale = request.getLocale();
        String errorMessage = messageSource.getMessage("error.invalid.argument", null, locale);
        return errorMessage;
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleGeneralException(Exception ex, WebRequest request) {
        Locale locale = request.getLocale();
        String errorMessage = messageSource.getMessage("error.general", null, locale);
        return errorMessage;
    }
}
