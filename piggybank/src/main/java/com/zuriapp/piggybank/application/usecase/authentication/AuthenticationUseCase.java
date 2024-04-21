package com.zuriapp.piggybank.application.usecase.authentication;

import com.zuriapp.piggybank.application.port.in.IAuthenticationUseCase;
import com.zuriapp.piggybank.application.port.out.UserOutPort;
import com.zuriapp.piggybank.domain.User;
import com.zuriapp.piggybank.domain.enums.Role;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.SignInRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.SignUpRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.JwtAuthenticationResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports.security.JwtSecurityOutPutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationUseCase implements IAuthenticationUseCase {

    private final UserOutPort port;
    private final PasswordEncoder passwordEncoder;
    private final JwtSecurityOutPutPort jwtSecurityOutPutPort;
    private final AuthenticationManager authenticationManager;
    @Override
    public JwtAuthenticationResponse signUp(SignUpRequest request) throws Exception {
        var user = User.builder().username(request.getUsername())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();
        port.save(user);
        var jwt = jwtSecurityOutPutPort.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = port.findByUserName(request.getUsername());
        var jwt = jwtSecurityOutPutPort.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
