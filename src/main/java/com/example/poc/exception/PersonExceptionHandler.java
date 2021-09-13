package com.example.poc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<String> handleNotFoundException(PersonException personException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(personException.getMessage());
    }
}
