package com.zuriapp.piggybank.application.usecase.transaction;

import com.zuriapp.piggybank.application.port.IRequestHandler;
import com.zuriapp.piggybank.application.port.out.TransactionOutPutPort;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.TransactionResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers.TransactionRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindTransactionByIdUseCase implements IRequestHandler<Long, TransactionResponse> {
    private final TransactionRestMapper mapper;
    private final TransactionOutPutPort port;

    @Override
    public TransactionResponse handle(Long request) throws Exception {
        return mapper.toResponse(port.findByTransactionId(request));
    }
}
