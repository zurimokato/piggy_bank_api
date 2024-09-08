package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.exception;

import com.zuriapp.piggybank.domain.dto.BaseResponseDTO;
import com.zuriapp.piggybank.domain.dto.ErrorResponseDTO;
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
    public ResponseEntity<BaseResponseDTO> exception(Exception e) {
        BaseResponseDTO response = BaseResponseDTO.getInstance();
        response.setResult("Failed");
        response.setStatus("500");
        response.setError(ErrorResponseDTO.builder()
                .code("500")
                .message(e.getMessage()).build());
        if (logger.isLoggable(Level.INFO)) {
            logger.log(Level.INFO, Arrays.toString(e.getStackTrace()));
        }
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<BaseResponseDTO> entityNotFound(EntityNotFoundException e) {
        BaseResponseDTO response = BaseResponseDTO.getInstance();
        response.setResult("Not Found");
        response.setStatus("404");
        response.setError(ErrorResponseDTO.builder()
                .code("404")
                .message(e.getMessage()).build());
        if (logger.isLoggable(Level.INFO)) {
            logger.log(Level.INFO, Arrays.toString(e.getStackTrace()));
        }
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
