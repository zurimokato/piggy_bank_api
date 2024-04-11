package com.zuriapp.piggybank.application.usecase.user;

import com.zuriapp.piggybank.application.port.IRequestHandler;
import com.zuriapp.piggybank.application.port.out.UserOutPort;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.UserResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers.UserRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindUserByUserNameUseCase implements IRequestHandler<String, UserResponse> {
    private final UserOutPort userOutPort;
    private final UserRestMapper mapper;

    @Override
    public UserResponse handle(String request) throws Exception {
        try {
            return mapper.toUserResponse(userOutPort.findByUsername(request));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }


    }
}
