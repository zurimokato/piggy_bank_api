package com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers;

import com.zuriapp.piggybank.domain.models.Count;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.CountRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.CountResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {TransactionRestMapper.class})
public interface CountRestMapper {


    Count toDomain(CountRequest countRequest);
    CountResponse toResponse(Count source);
}
