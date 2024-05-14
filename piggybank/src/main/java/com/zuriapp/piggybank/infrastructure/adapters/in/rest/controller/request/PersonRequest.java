package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PersonRequest {

    private Long id;

    @NotNull
    @NotBlank
    @Size( max = 45)
    private String firstName;
    @NotNull
    @NotBlank
    @Size( max = 45)
    private String firstLastName;
    @Size( max = 45)
    private String secondName;
    @Size( max = 45)
    private String secondLastName;
    @NotNull
    private Integer age;
    @NotNull
    private char gender;
    @NotNull
    @NotBlank
    private String nit;
    @NotNull
    @NotBlank
    @Size( max = 10)
    private String phone;

    private UserRequest user;
}
