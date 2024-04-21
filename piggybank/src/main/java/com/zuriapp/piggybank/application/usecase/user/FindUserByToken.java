package com.zuriapp.piggybank.application.usecase.user;

import com.zuriapp.piggybank.application.port.IRequestHandler;
import com.zuriapp.piggybank.application.port.out.UserOutPort;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports.security.JwtSecurityOutPutPort;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.UserResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers.UserRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindUserByToken implements IRequestHandler<String, UserResponse> {
    private final JwtSecurityOutPutPort port;

    private final UserOutPort userPort;

    private final UserRestMapper mapper;

    @Override
    public UserResponse handle(String request) throws Exception {

        try {
            String token=port.extractTokenFromHeader(request);
            String userName = port.extractUserName(token);

            return mapper.toUserResponse(userPort.findByUsername(userName));
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }

    }
}
