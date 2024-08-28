package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports;

import com.zuriapp.piggybank.application.exceptions.DomainException;
import com.zuriapp.piggybank.domain.dto.BaseDataResponse;
import com.zuriapp.piggybank.domain.dto.BaseResponseDTO;
import com.zuriapp.piggybank.domain.dto.PageResponseDTO;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.TransactionRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.TransactionResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.websocket.server.PathParam;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface TransactionAPI {

    @PostMapping()
    ResponseEntity<BaseResponseDTO> createTransaction(@Valid @RequestBody TransactionRequest transactionRequest) throws DomainException;
    @GetMapping("page")
    ResponseEntity<PageResponseDTO<TransactionResponse>>findTransactionsByCount(@Valid @PathParam("countId") Long countId, Pageable pageable) throws DomainException;
    @GetMapping()
    ResponseEntity<BaseDataResponse<TransactionResponse>>findTransactionsById(@Valid @NotNull @PathParam("transactionId") Long transactionId) throws DomainException;
}
