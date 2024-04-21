package com.zuriapp.piggybank.application.port.in;

import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.SignInRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.SignUpRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.JwtAuthenticationResponse;

public interface IAuthenticationUseCase {
    JwtAuthenticationResponse signUp(SignUpRequest request) throws Exception;

    JwtAuthenticationResponse signIn(SignInRequest request);
}
