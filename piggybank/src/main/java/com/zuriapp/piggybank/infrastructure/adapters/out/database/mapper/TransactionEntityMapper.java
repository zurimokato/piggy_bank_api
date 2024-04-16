package com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper;

import com.zuriapp.piggybank.domain.Transaction;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring",uses = {CountEntityMapper.class})
public interface TransactionEntityMapper {

    @Mappings({
            @Mapping(source = "count",target = "count")
    })

    Transaction toDomain(TransactionEntity transactionEntity);
    TransactionEntity toEntity(Transaction transaction);
}
