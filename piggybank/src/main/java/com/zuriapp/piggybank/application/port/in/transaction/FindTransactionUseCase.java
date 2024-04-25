package com.zuriapp.piggybank.application.port.in.transaction;

import com.zuriapp.piggybank.domain.models.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindTransactionUseCase {
    Page<Transaction> findTransactionsByCount(Long countId, Pageable pageable);

    Transaction findTransactionById(Long id);
}
