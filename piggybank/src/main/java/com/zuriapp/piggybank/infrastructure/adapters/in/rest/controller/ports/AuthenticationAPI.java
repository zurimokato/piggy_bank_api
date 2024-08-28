package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports;

import com.zuriapp.piggybank.application.exceptions.DomainException;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.SignInRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.SignUpRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.JwtAuthenticationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthenticationAPI {
    @PostMapping("/signUp")
     ResponseEntity<JwtAuthenticationResponse> signUp(@RequestBody SignUpRequest request) throws DomainException;


    @PostMapping("/signIn")
     ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody SignInRequest request) ;
}
