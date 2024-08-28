package com.zuriapp.piggybank.application.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationException extends RuntimeException{
    private final String message;

    public AuthenticationException(String message) {
        this.message = message;
    }

    public AuthenticationException() {
        this.message = "Ha ocurrido un error al momento de hacer la autenticación";
    }
}
