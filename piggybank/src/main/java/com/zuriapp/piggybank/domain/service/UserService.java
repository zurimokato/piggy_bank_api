package com.zuriapp.piggybank.domain.service;

import com.zuriapp.piggybank.application.port.in.user.FindUserUseCase;
import com.zuriapp.piggybank.application.port.out.UserOutPort;
import com.zuriapp.piggybank.domain.models.User;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports.security.JwtSecurityOutPutPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements FindUserUseCase {

    private final JwtSecurityOutPutPort port;

    private final UserOutPort userPort;

    @Override
    public User findUserByUsername(String username) throws Exception {
        try {
            return userPort.findByUsername(username);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public User findUserByToken(String request) throws Exception {
        try {
            String token = port.extractTokenFromHeader(request);
            String userName = port.extractUserName(token);

            return userPort.findByUsername(userName);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
}
