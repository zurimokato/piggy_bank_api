package com.zuriapp.piggybank.infrastructure.adapters.out.database;

import com.zuriapp.piggybank.application.exceptions.InfrastructureException;
import com.zuriapp.piggybank.application.port.out.TransactionOutPutPort;
import com.zuriapp.piggybank.domain.models.Transaction;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.TransactionEntity;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper.TransactionEntityMapper;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionPersistenceAdapter implements TransactionOutPutPort {
    private final TransactionRepository transactionRepository;
    private final TransactionEntityMapper mapper;
    @Value("${response.notfound.message}")
    private String notFoundMessage;

    @Override
    public Transaction save(Transaction transaction) throws InfrastructureException {

        try {
            return mapper.toDomain(transactionRepository.save(mapper.toEntity(transaction)));
        } catch (Exception e) {
            throw new InfrastructureException(e);
        }
    }

    @Override
    public Transaction findByTransactionId(Long transactionId) throws EntityNotFoundException {
        return transactionRepository.findById(transactionId).map(mapper::toDomain)
                .orElseThrow(() -> new EntityNotFoundException(notFoundMessage));

    }

    @Override
    public Page<Transaction> findAllByCount(Long count, Pageable pageable) throws EntityNotFoundException {


        Page<TransactionEntity> transactionEntities = transactionRepository.findAllByCountId(count, pageable);

        if (transactionEntities.isEmpty()) {
            throw new EntityNotFoundException(notFoundMessage);
        }
        return transactionEntities.map(mapper::toDomain);
    }
}
