package com.zuriapp.piggybank.application.usecase.transaction;


import com.zuriapp.piggybank.application.port.IRequestHandler;
import com.zuriapp.piggybank.application.port.out.TransactionOutPutPort;
import com.zuriapp.piggybank.domain.Transaction;
import com.zuriapp.piggybank.domain.dto.BaseResponseDTO;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.TransactionRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers.TransactionRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTransactionUseCase  implements IRequestHandler<TransactionRequest,BaseResponseDTO> {
    private final TransactionRestMapper mapper;
    private final TransactionOutPutPort port;
    @Override
    public BaseResponseDTO handle(TransactionRequest request) throws Exception {
        Transaction transaction=mapper.toDomain(request);
        port.save(transaction);
        return new BaseResponseDTO();
    }
}
