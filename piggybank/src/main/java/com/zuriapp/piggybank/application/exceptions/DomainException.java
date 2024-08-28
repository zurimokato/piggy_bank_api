package com.zuriapp.piggybank.application.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomainException extends RuntimeException{
    private final  String message;
    public DomainException(String message) {
        this.message = message;
    }
   public DomainException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
   }
   public DomainException() {
        this.message=" Domain Exception";
   }

}
