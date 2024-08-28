package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports;

import com.zuriapp.piggybank.application.exceptions.DomainException;
import com.zuriapp.piggybank.domain.dto.BaseDataResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.PersonResponse;
import jakarta.validation.constraints.NotNull;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface PersonAPI {

    @GetMapping()
    ResponseEntity<BaseDataResponse<PersonResponse>> getUser(@NotNull  @PathParam("id") Long id) throws DomainException;

}
