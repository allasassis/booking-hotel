package com.api.hotel.security.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(APIException.class)
    public ResponseEntity error400(APIException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
