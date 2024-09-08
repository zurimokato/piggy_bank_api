package com.zuriapp.piggybank.domain.service;

import com.zuriapp.piggybank.application.port.out.UserOutPort;
import com.zuriapp.piggybank.domain.enums.Role;
import com.zuriapp.piggybank.domain.models.User;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports.security.JwtSecurityOutPutPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserOutPort userOutPort;
    @Mock
    private JwtSecurityOutPutPort jwtSecurityOutPutPort;
    @InjectMocks
    private UserService userService;

    @Test
    void findUserByUsername() throws Exception {
        final User user = getUserInstance();
        Mockito.when(userOutPort.findByUsername(Mockito.any(String.class)))
                .thenReturn(user);
        var resultado=userService.findUserByUsername("userName");
        assertEquals(user,resultado);
    }

    @Test
    void findUserByToken() throws Exception {
        final User user = getUserInstance();
        Mockito.when(jwtSecurityOutPutPort.extractTokenFromHeader(Mockito.any(String.class)))
                        .thenReturn("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ6dXJpbW9rYXRvIiwiaWF0IjoxNzEzNzMxNDg0LCJleHAiOjE3MTM3MzI5MjR9.C84-XZizr5W9VIC44bHsyjbybra-LmV9ujb7rtkxLAI");
        Mockito.when(jwtSecurityOutPutPort.extractUserName(Mockito.any(String.class)))
                .thenReturn(user.getUsername());
        Mockito.when(userOutPort.findByUsername(Mockito.any(String.class)))
                .thenReturn(user);
        var resultado=userService.findUserByToken("Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ6dXJpbW9rYXRvIiwiaWF0IjoxNzEzNzMxNDg0LCJleHAiOjE3MTM3MzI5MjR9.C84-XZizr5W9VIC44bHsyjbybra-LmV9ujb7rtkxLAI");
        assertEquals(user,resultado);
    }

    private User getUserInstance(){
        return User.builder()
                .id(1L)
                .username("userName")
                .email("noj2304@gmail.com")
                .role(Role.USER)
                .createTime(LocalDateTime.now()).build();
    }
}