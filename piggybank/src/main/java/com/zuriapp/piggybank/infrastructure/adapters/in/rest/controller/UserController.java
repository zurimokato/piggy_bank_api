package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller;

import com.zuriapp.piggybank.application.usecase.person.CreateUserUseCase;
import com.zuriapp.piggybank.application.usecase.user.FindUserByToken;
import com.zuriapp.piggybank.application.usecase.user.FindUserByUserNameUseCase;
import com.zuriapp.piggybank.domain.dto.BaseDataResponse;
import com.zuriapp.piggybank.domain.dto.BaseResponseDTO;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports.UserAPI;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.PersonRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.UserRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.PersonResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Valid
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
@CrossOrigin(origins = "http://localhost:8100")
public class UserController implements UserAPI {

    private final CreateUserUseCase createUserUseCase;
    private final FindUserByUserNameUseCase findUserByUserNameUseCase;
    private final FindUserByToken findUserByToken;
    @Override
    public ResponseEntity<BaseResponseDTO> createUser(PersonRequest request) throws Exception {
        PersonResponse person=createUserUseCase.handle(request);
        log.info("User created: {}", person);
        return new ResponseEntity<>(new BaseResponseDTO(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponseDTO> updateUser(String userName, UserRequest request)throws Exception {
        UserResponse user=findUserByUserNameUseCase.handle(userName);
        log.info("User toUpdate: {}", user);
        return new ResponseEntity<>(new BaseResponseDTO(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseDataResponse<UserResponse>> getUser(String userName) throws Exception {
        BaseDataResponse<UserResponse> queryUserResponse = new BaseDataResponse<>();
        queryUserResponse.setData(findUserByUserNameUseCase.handle(userName));
        return new ResponseEntity<>(queryUserResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseDataResponse<UserResponse>> getUserByToken(String authorizationHeader) throws Exception {
        UserResponse user=findUserByToken.handle(authorizationHeader);
        BaseDataResponse<UserResponse> queryUserResponse = new BaseDataResponse<>();
        queryUserResponse.setData(user);
        return new ResponseEntity<>(queryUserResponse, HttpStatus.OK);
    }
}
