package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports;

import com.zuriapp.piggybank.application.exceptions.DomainException;
import com.zuriapp.piggybank.domain.dto.BaseDataResponse;
import com.zuriapp.piggybank.domain.dto.BaseResponseDTO;
import com.zuriapp.piggybank.domain.dto.PageResponseDTO;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.CountRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.CountResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.websocket.server.PathParam;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



public interface CountAPI {

    @PostMapping
    ResponseEntity<BaseResponseDTO>createCount(@Valid @RequestBody CountRequest request) throws DomainException;
    @GetMapping("by-id")
    ResponseEntity<BaseDataResponse<CountResponse>> getCountById(@Valid @NotNull @PathParam("countId") Long countId) throws DomainException;
    @GetMapping()
    ResponseEntity<PageResponseDTO<CountResponse>>getCountByPerson(@Valid @NotNull @PathParam("userId")Long userId, Pageable pageable) throws DomainException;
}
