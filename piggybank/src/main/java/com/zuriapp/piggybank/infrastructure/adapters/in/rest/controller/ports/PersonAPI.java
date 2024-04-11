package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports;

import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.QueryPersonResponse;
import jakarta.validation.constraints.NotNull;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface PersonAPI {

    @GetMapping()
    ResponseEntity<QueryPersonResponse> getUser(@NotNull  @PathParam("id") Long id) throws Exception;

}
