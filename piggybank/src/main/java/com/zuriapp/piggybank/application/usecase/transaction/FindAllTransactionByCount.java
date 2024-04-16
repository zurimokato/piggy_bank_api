package com.zuriapp.piggybank.application.usecase.transaction;

import com.zuriapp.piggybank.application.port.IRequestHandler;
import com.zuriapp.piggybank.application.port.out.TransactionOutPutPort;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.QueryTransactionRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.TransactionResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers.TransactionRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAllTransactionByCount implements IRequestHandler<QueryTransactionRequest, Page<TransactionResponse>> {
    private final TransactionRestMapper mapper;
    private final TransactionOutPutPort port;

    @Override
    public Page<TransactionResponse> handle(QueryTransactionRequest request) throws Exception {
        return port.findAllByCount(request.getCountId(), request.getPageable())
                .map(mapper::toResponse);
    }
}
