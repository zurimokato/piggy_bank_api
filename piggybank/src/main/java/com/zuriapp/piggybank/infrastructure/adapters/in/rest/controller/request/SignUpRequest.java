package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request;

import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.validation.EmailValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SignUpRequest {
    @NotNull
    @NotBlank
    @Size(min = 2, max = 16)
    private String username;
    @NotNull
    @NotBlank
    @Size(min = 8)
    private String password;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    @EmailValidation
    private String email;
}
