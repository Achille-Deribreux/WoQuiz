package com.woquiz.exception.model;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException e){
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.NOT_FOUND);
    }
}
