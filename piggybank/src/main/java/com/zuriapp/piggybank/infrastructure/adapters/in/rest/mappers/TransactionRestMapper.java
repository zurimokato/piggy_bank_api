package com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers;

import com.zuriapp.piggybank.domain.models.Transaction;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.TransactionRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.TransactionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionRestMapper {

    Transaction toDomain(TransactionRequest source);

    TransactionResponse toResponse(Transaction source);
}
