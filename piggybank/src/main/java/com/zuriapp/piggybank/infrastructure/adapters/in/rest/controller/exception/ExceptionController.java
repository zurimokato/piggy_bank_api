package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.exception;

import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.exception.response.ExceptionResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


@ControllerAdvice
public class ExceptionController {
    private final Logger logger = Logger.getLogger(ExceptionController.class.getName());
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> exception(Exception e) {
        ExceptionResponse response=ExceptionResponse.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR).message(e.getMessage()).build();
        logger.log(Level.INFO, Arrays.toString(e.getStackTrace()));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionResponse> entityNotFound(EntityNotFoundException e) {
        ExceptionResponse response=ExceptionResponse.builder()
                .code(HttpStatus.NOT_FOUND).message(e.getMessage()).build();
        logger.log(Level.INFO, Arrays.toString(e.getStackTrace()));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
