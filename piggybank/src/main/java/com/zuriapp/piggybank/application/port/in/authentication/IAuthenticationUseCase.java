package com.zuriapp.piggybank.application.port.in.authentication;

import com.zuriapp.piggybank.application.exceptions.AuthenticationException;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.SignInRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.SignUpRequest;

public interface IAuthenticationUseCase {
    String signUp(SignUpRequest request) throws AuthenticationException;

    String signIn(SignInRequest request);
}
