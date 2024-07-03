package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports.security;

import com.zuriapp.piggybank.domain.models.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtSecurityOutPutPort {
    String extractUserName(String token);

    String generateToken(User userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);

    String extractTokenFromHeader(String authorizationHeader);
}
