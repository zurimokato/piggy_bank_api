package com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers;

import com.zuriapp.piggybank.domain.Count;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.CountRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.CountResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TransactionRestMapper.class})
public interface CountRestMapper {


    @Mapping(target = "transactions", ignore = true)
    Count toDomain(CountRequest countRequest);
    @Mapping(target = "transactions",source ="transactions")
    CountResponse toResponse(Count source);
}
