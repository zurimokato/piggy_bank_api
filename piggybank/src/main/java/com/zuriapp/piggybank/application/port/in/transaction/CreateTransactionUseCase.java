package com.zuriapp.piggybank.application.port.in.transaction;

import com.zuriapp.piggybank.application.exceptions.DomainException;
import com.zuriapp.piggybank.domain.models.Transaction;

public interface CreateTransactionUseCase {
    Transaction createTransaction(Transaction transaction) throws DomainException;
}
