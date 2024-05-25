package com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper;

import com.zuriapp.piggybank.domain.models.Budget;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.BudgetEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface BudgetEntityMapper {

    BudgetEntity toEntity(Budget budget);
    Budget toModel(BudgetEntity budgetEntity);
}
