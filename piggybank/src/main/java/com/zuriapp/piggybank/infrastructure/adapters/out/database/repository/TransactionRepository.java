package com.zuriapp.piggybank.infrastructure.adapters.out.database.repository;

import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.TransactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CommonRepository<TransactionEntity,Long> {

    Page<TransactionEntity>findAllByCountId(Long countId,Pageable pageable);
}
