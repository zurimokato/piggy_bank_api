package com.zuriapp.piggybank.application.port.out;

import com.zuriapp.piggybank.application.exceptions.InfrastructureException;
import com.zuriapp.piggybank.domain.models.Transaction;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface TransactionOutPutPort {
    Transaction save(Transaction transaction) throws InfrastructureException;
    Transaction findByTransactionId(Long transactionId) throws EntityNotFoundException;
    Page<Transaction> findAllByCount(Long count, Pageable pageable) throws EntityNotFoundException;
}
