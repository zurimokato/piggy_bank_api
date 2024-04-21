package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports;

import com.zuriapp.piggybank.domain.dto.BaseDataResponse;
import com.zuriapp.piggybank.domain.dto.BaseResponseDTO;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.PersonRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.UserRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.PersonResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.UserResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



public interface UserAPI {
    @PostMapping()
    ResponseEntity<BaseResponseDTO> createUser(@Valid @RequestBody PersonRequest request) throws Exception;

    @PutMapping()
    ResponseEntity<BaseResponseDTO> updateUser(@NotNull @NotBlank @PathParam("userName") String userName, @RequestBody UserRequest request) throws Exception;

    @GetMapping()
    ResponseEntity<BaseDataResponse<UserResponse>> getUser(@NotNull @NotBlank @PathParam("userName") String userName) throws Exception;


    @GetMapping("/session")
    ResponseEntity<BaseDataResponse<UserResponse>> getUserByToken(@NotNull @NotBlank @RequestHeader("Authorization") String authorizationHeader) throws Exception;


}
