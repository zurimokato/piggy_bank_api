package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtSecurityOutPutPort {
    String extractUserName(String token);

    String generateToken(UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);

    String extractTokenFromHeader(String authorizationHeader);
}
