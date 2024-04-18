package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.exception.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ExceptionResponse {
    private String message;
    private HttpStatus code;
}
