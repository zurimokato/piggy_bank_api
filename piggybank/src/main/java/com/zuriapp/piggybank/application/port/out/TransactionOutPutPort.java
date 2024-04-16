package com.zuriapp.piggybank.application.port.out;

import com.zuriapp.piggybank.domain.Transaction;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface TransactionOutPutPort {
    Transaction save(Transaction transaction) throws Exception;
    Transaction findByTransactionId(Long transactionId) throws EntityNotFoundException;;
    Page<Transaction> findAllByCount(Long count, Pageable pageable) throws EntityNotFoundException;;
}
