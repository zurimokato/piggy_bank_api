package com.zuriapp.piggybank.infrastructure.adapters.out.database;

import com.zuriapp.piggybank.application.port.out.TransactionOutPutPort;
import com.zuriapp.piggybank.domain.Transaction;
import com.zuriapp.piggybank.infrastructure.adapters.out.config.MessageConfigAdapter;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.TransactionEntity;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper.TransactionEntityMapper;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionPersistenceAdapter implements TransactionOutPutPort {
    private final TransactionRepository transactionRepository;
    private final TransactionEntityMapper mapper;
    private final MessageConfigAdapter messageAdapter;

    @Override
    public Transaction save(Transaction transaction) throws Exception {

        try {
            return mapper.toDomain(transactionRepository.save(mapper.toEntity(transaction)));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Transaction findByTransactionId(Long transactionId) throws EntityNotFoundException {
        return transactionRepository.findById(transactionId).map(mapper::toDomain)
                .orElseThrow(() -> new EntityNotFoundException(messageAdapter.notFoundResponse()));

    }

    @Override
    public Page<Transaction> findAllByCount(Long count, Pageable pageable) throws EntityNotFoundException {


        Page<TransactionEntity> transactionEntities = transactionRepository.findAllByCountId(count, pageable);

        if (transactionEntities.isEmpty()) {
            throw new EntityNotFoundException(messageAdapter.notFoundResponse());
        }
        return transactionEntities.map(mapper::toDomain);
    }
}
