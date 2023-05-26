package com.springweb.flux.controller;

import com.springweb.flux.exception.ErrorResponse;
import com.springweb.flux.exception.InputException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    public ResponseEntity<ErrorResponse> errorResponse( InputException input){
        var errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(input.getErrorCode());
        errorResponse.setMessage(input.getMessage());
        errorResponse.setInput(input.getInput());
        return  ResponseEntity.badRequest().body(errorResponse);
    }
}
