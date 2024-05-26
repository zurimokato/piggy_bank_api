package com.zuriapp.piggybank.domain.service;

import com.zuriapp.piggybank.application.port.in.authentication.IAuthenticationUseCase;
import com.zuriapp.piggybank.application.port.out.UserOutPort;
import com.zuriapp.piggybank.domain.enums.Role;
import com.zuriapp.piggybank.domain.enums.Status;
import com.zuriapp.piggybank.domain.models.User;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports.security.JwtSecurityOutPutPort;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.SignInRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService implements IAuthenticationUseCase {
    private final UserOutPort port;
    private final PasswordEncoder passwordEncoder;
    private final JwtSecurityOutPutPort jwtSecurityOutPutPort;
    private final AuthenticationManager authenticationManager;

    @Override
    public String signUp(SignUpRequest request) throws Exception {
        var user = User.builder().username(request.getUsername())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .status(Status.ACTIVE)
                .createTime(LocalDateTime.now()).build();
        port.save(user);
        return jwtSecurityOutPutPort.generateToken(user);
    }

    @Override
    public String signIn(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = port.findByUserName(request.getUsername());
        return jwtSecurityOutPutPort.generateToken(user);
    }
}
