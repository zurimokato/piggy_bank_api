package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller;

import com.zuriapp.piggybank.application.port.in.transaction.CreateTransactionUseCase;
import com.zuriapp.piggybank.application.port.in.transaction.FindTransactionUseCase;
import com.zuriapp.piggybank.domain.dto.BaseDataResponse;
import com.zuriapp.piggybank.domain.dto.BaseResponseDTO;
import com.zuriapp.piggybank.domain.dto.PageResponseDTO;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports.TransactionAPI;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.QueryTransactionRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.TransactionRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.TransactionResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers.TransactionRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/transactions")
@CrossOrigin(origins = "http://localhost:8100")
public class TransactionController implements TransactionAPI {
    private final CreateTransactionUseCase transactionUseCase;
    private final FindTransactionUseCase findTransaction;
    private final TransactionRestMapper mapper;

    @Override
    public ResponseEntity<BaseResponseDTO> createTransaction(TransactionRequest transactionRequest) throws Exception {
        transactionUseCase.createTransaction(mapper.toDomain(transactionRequest));
        return new ResponseEntity<>(BaseResponseDTO.getInstance(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PageResponseDTO<TransactionResponse>> findTransactionsByCount(Long countId, Pageable pageable) throws Exception {
        PageResponseDTO<TransactionResponse> responseDTO = new PageResponseDTO<>();
        responseDTO.setData(findTransaction.findTransactionsByCount(countId,pageable).map(mapper::toResponse));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseDataResponse<TransactionResponse>> findTransactionsById(Long transactionId) throws Exception {
        BaseDataResponse<TransactionResponse> response = new BaseDataResponse<>();
        response.setData(mapper.toResponse(findTransaction.findTransactionById(transactionId)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
