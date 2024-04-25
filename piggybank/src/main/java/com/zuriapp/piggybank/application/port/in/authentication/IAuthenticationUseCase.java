package com.zuriapp.piggybank.application.port.in.authentication;

import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.SignInRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.SignUpRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.JwtAuthenticationResponse;

public interface IAuthenticationUseCase {
    String signUp(SignUpRequest request) throws Exception;

    String signIn(SignInRequest request);
}
