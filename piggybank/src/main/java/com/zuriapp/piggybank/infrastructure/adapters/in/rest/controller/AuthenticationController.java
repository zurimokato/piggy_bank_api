package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller;


import com.zuriapp.piggybank.application.exceptions.DomainException;
import com.zuriapp.piggybank.application.port.in.authentication.IAuthenticationUseCase;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports.AuthenticationAPI;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.SignInRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.SignUpRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.JwtAuthenticationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Valid
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
@CrossOrigin(origins = "http://localhost:8100")
public class AuthenticationController implements AuthenticationAPI {

    private final IAuthenticationUseCase authenticationUseCase;

    @Override
    public ResponseEntity<JwtAuthenticationResponse> signUp(SignUpRequest request) throws DomainException {
        JwtAuthenticationResponse response = JwtAuthenticationResponse.builder().token(authenticationUseCase.signUp(request)).build();
        return ResponseEntity.ok(response);
    }


    @Override
    public ResponseEntity<JwtAuthenticationResponse> signIn(SignInRequest request) {

        JwtAuthenticationResponse response = JwtAuthenticationResponse.builder().token(authenticationUseCase.signIn(request)).build();
        return ResponseEntity.ok(response);
    }

}
