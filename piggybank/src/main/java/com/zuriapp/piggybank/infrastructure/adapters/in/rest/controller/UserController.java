package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller;

import com.zuriapp.piggybank.application.port.in.person.CreatePersonUseCase;
import com.zuriapp.piggybank.application.port.in.user.FindUserUseCase;
import com.zuriapp.piggybank.domain.dto.BaseDataResponse;
import com.zuriapp.piggybank.domain.dto.BaseResponseDTO;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports.UserAPI;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.PersonRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.UserRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.PersonResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.UserResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers.PersonRestMapper;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers.UserRestMapper;
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

    private final CreatePersonUseCase createUserUseCase;
    private final FindUserUseCase findUserUseCase;
    private final UserRestMapper mapper;
    private final PersonRestMapper personMapper;

    @Override
    public ResponseEntity<BaseResponseDTO> createUser(PersonRequest request) throws Exception {
        PersonResponse person = personMapper.toResponse(createUserUseCase.createPerson(personMapper.toDomain(request)));
        log.info("User created: {}", person);
        return new ResponseEntity<>(BaseResponseDTO.getInstance(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponseDTO> updateUser(String userName, UserRequest request) throws Exception {
        UserResponse user = mapper.toUserResponse(findUserUseCase.findUserByUsername(userName));
        log.info("User toUpdate: {}", user);
        return new ResponseEntity<>(BaseResponseDTO.getInstance(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseDataResponse<UserResponse>> getUser(String userName) throws Exception {
        BaseDataResponse<UserResponse> queryUserResponse = new BaseDataResponse<>();
        queryUserResponse.setData(mapper.toUserResponse(findUserUseCase.findUserByUsername(userName)));
        return new ResponseEntity<>(queryUserResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseDataResponse<UserResponse>> getUserByToken(String authorizationHeader) throws Exception {
        UserResponse user = mapper.toUserResponse(findUserUseCase.findUserByToken(authorizationHeader));
        BaseDataResponse<UserResponse> queryUserResponse = new BaseDataResponse<>();
        queryUserResponse.setData(user);
        return new ResponseEntity<>(queryUserResponse, HttpStatus.OK);
    }
}
