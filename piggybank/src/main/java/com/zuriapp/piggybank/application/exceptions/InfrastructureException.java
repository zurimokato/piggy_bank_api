package com.zuriapp.piggybank.application.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InfrastructureException extends RuntimeException{
    private final String message;
    public InfrastructureException(Exception e) {
        super(e);
        message = e.getMessage();

    }
}
