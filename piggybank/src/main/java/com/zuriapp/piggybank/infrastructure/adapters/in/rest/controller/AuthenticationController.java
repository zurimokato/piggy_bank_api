package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller;


import com.zuriapp.piggybank.application.usecase.authentication.AuthenticationUseCase;
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

    private final AuthenticationUseCase authenticationUseCase;

    @Override
    public ResponseEntity<JwtAuthenticationResponse> signUp(SignUpRequest request) throws Exception {
        return ResponseEntity.ok(authenticationUseCase.signUp(request));
    }


    @Override
    public ResponseEntity<JwtAuthenticationResponse> signIn( SignInRequest request) {
        return ResponseEntity.ok(authenticationUseCase.signIn(request));
    }

}
