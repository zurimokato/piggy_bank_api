package com.zuriapp.piggybank.domain.service;

import com.zuriapp.piggybank.application.exceptions.DomainException;
import com.zuriapp.piggybank.application.port.in.transaction.CreateTransactionUseCase;
import com.zuriapp.piggybank.application.port.in.transaction.FindTransactionUseCase;
import com.zuriapp.piggybank.application.port.out.TransactionOutPutPort;
import com.zuriapp.piggybank.domain.models.Transaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionService implements CreateTransactionUseCase, FindTransactionUseCase {
    private final TransactionOutPutPort transactionOutPutPort;

    @Override
    public Transaction createTransaction(Transaction transaction) throws DomainException {

        try {
            transaction.setCreateTime(LocalDateTime.now());
            return transactionOutPutPort.save(transaction);
        } catch (Exception e) {
            throw new DomainException(e.getMessage());
        }

    }

    @Override
    public Page<Transaction> findTransactionsByCount(Long countId, Pageable pageable) throws DomainException {
        try {
            return transactionOutPutPort.findAllByCount(countId,pageable);
        }catch (Exception e){
            throw new DomainException(e.getMessage());

        }

    }

    @Override
    public Transaction findTransactionById(Long id) throws DomainException {
        try {
            return transactionOutPutPort.findByTransactionId(id);
        }catch (Exception e){
            throw new DomainException(e.getMessage());
        }

    }
}
