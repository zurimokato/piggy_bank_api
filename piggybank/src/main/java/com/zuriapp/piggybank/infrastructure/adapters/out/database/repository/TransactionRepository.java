package com.zuriapp.piggybank.infrastructure.adapters.out.database.repository;

import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.TransactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity,Long> {

    Page<TransactionEntity>findAllByCountId(Long countId,Pageable pageable);
}
