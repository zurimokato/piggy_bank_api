package com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper;

import com.zuriapp.piggybank.domain.models.Transaction;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CountEntityMapper.class})
public interface TransactionEntityMapper {

    @Mapping(source = "count", target = "count")
    Transaction toDomain(TransactionEntity transactionEntity);

    TransactionEntity toEntity(Transaction transaction);
}
