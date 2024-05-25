package com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers;

import com.zuriapp.piggybank.domain.models.Budget;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.BudgetRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.BudgetResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BudgetRestMapper {

    Budget toModel(BudgetRequest request);
    BudgetResponse toResponse(Budget budget);
}
