package com.united.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.united.exception.CustomJSONParseErrorException;

@ControllerAdvice
public class AppControllerAdvice extends ResponseEntityExceptionHandler{

	@ExceptionHandler({CustomJSONParseErrorException.class})
    public ResponseEntity<String> handleParseException(HttpStatus status, CustomJSONParseErrorException e) {
		return ResponseEntity.status(status).body(e.getMessage());
    }
}



