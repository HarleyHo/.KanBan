package com.vsagile.vsagilebackend.exception;

import com.vsagile.vsagilebackend.pojo.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    @ExceptionHandler
    public ResponseMessage<?> handleException(Exception e) {
        return new ResponseMessage<>(500, "error", e.getMessage());
    }
}
