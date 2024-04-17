package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller;

import com.zuriapp.piggybank.application.usecase.transaction.CreateTransactionUseCase;
import com.zuriapp.piggybank.application.usecase.transaction.FindAllTransactionByCount;
import com.zuriapp.piggybank.application.usecase.transaction.FindTransactionByIdUseCase;
import com.zuriapp.piggybank.domain.dto.BaseDataResponse;
import com.zuriapp.piggybank.domain.dto.BaseResponseDTO;
import com.zuriapp.piggybank.domain.dto.PageResponseDTO;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports.TransactionAPI;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.QueryTransactionRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.TransactionRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.TransactionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/transactions")
public class TransactionController implements TransactionAPI {
    private final CreateTransactionUseCase transactionUseCase;
    private final FindAllTransactionByCount findAllTransactionByCount;
    private final FindTransactionByIdUseCase findTransactionByIdUseCase;

    @Override
    public ResponseEntity<BaseResponseDTO> createTransaction(TransactionRequest transactionRequest) throws Exception {
        return new ResponseEntity<>(transactionUseCase.handle(transactionRequest), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PageResponseDTO<TransactionResponse>> findTransactionsByCount(Long countId, Pageable pageable) throws Exception {
        PageResponseDTO<TransactionResponse> responseDTO = new PageResponseDTO<>();
        QueryTransactionRequest request = QueryTransactionRequest.builder().countId(countId).pageable(pageable).build();
        responseDTO.setData(findAllTransactionByCount.handle(request));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseDataResponse<TransactionResponse>> findTransactionsById(Long transactionId) throws Exception {
        BaseDataResponse<TransactionResponse> response = new BaseDataResponse<>();
        response.setData(findTransactionByIdUseCase.handle(transactionId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
