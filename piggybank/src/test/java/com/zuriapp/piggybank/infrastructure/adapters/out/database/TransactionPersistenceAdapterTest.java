package com.zuriapp.piggybank.infrastructure.adapters.out.database;

import com.zuriapp.piggybank.domain.enums.CountType;
import com.zuriapp.piggybank.domain.enums.Currency;
import com.zuriapp.piggybank.domain.enums.TransactionType;
import com.zuriapp.piggybank.domain.models.Category;
import com.zuriapp.piggybank.domain.models.Count;
import com.zuriapp.piggybank.domain.models.Transaction;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.CategoryEntity;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.CountEntity;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.TransactionEntity;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper.TransactionEntityMapper;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class TransactionPersistenceAdapterTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private TransactionEntityMapper transactionEntityMapper;

    @InjectMocks
    private TransactionPersistenceAdapter transactionPersistenceAdapter;

    @Test
    void save() throws Exception {
        final Transaction transaction = getTransaction();
        Mockito.when(transactionEntityMapper.toEntity(Mockito.any(Transaction.class))).thenReturn(getTransactionEntity());
        Mockito.when(transactionRepository.save(Mockito.any(TransactionEntity.class))).thenReturn(getTransactionEntitySaved());
        Mockito.when(transactionEntityMapper.toDomain(Mockito.any(TransactionEntity.class))).thenReturn(getTransactionSaved());

        var result = transactionPersistenceAdapter.save(transaction);
        assertNotNull(result);
    }

    @Test
    void findByTransactionId() {
        Mockito.when(transactionRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.of(getTransactionEntitySaved()));
        Mockito.when(transactionEntityMapper.toDomain(Mockito.any(TransactionEntity.class))).thenReturn(getTransactionSaved());
        var result = transactionPersistenceAdapter.findByTransactionId(1L);
        assertNotNull(result);
    }

    @Test
    void findAllByCount() {

        Pageable pageable=Pageable.ofSize(getlist().size());
        Mockito.when(transactionRepository.findAllByCountId(Mockito.any(Long.class),Mockito.any(Pageable.class))).thenReturn(getPage());
        Mockito.when(transactionEntityMapper.toDomain(Mockito.any(TransactionEntity.class))).thenReturn(getTransactionSaved());
        var result = transactionPersistenceAdapter.findAllByCount(1L, pageable);
        assertNotNull(result);
    }

    @Test
    void save_shouldThrowException_whenRepositoryThrowsException() {
        Transaction transaction = getTransaction();
        Mockito.when(transactionEntityMapper.toEntity(transaction)).thenReturn(getTransactionEntity());
        Mockito.doThrow(new RuntimeException("Repository error")).when(transactionRepository).save(Mockito.any(TransactionEntity.class));

        assertThatThrownBy(() -> transactionPersistenceAdapter.save(transaction))
                .isInstanceOf(Exception.class)
                .hasMessageContaining("Repository error");
    }

    @Test
    void findByTransactionId_shouldThrowEntityNotFoundException_whenTransactionNotFound() {
        Long transactionId = 1L;
        Mockito.when(transactionRepository.findById(transactionId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> transactionPersistenceAdapter.findByTransactionId(transactionId))
                .isInstanceOf(EntityNotFoundException.class);
    }

    private Transaction getTransaction() {
        return Transaction.builder()
                .description("description")
                .type(TransactionType.EGRESO)
                .amount(new BigDecimal(1))
                .category(Category.builder().id(1L).build())
                .count(Count.builder().id(1L).build()).build();
    }

    private Transaction getTransactionSaved() {
        Transaction transaction=getTransaction();
        transaction.setId(1L);
        transaction.setCreateTime(LocalDateTime.now());
        return Transaction.builder().build();
    }

    private List<TransactionEntity> getlist() {
        return List.of(getTransactionEntitySaved(),getTransactionEntitySaved(),getTransactionEntitySaved());
    }

    private Page<TransactionEntity> getPage() {
        return new PageImpl<>(getlist());
    }

    private TransactionEntity getTransactionEntity() {
        CategoryEntity cat = new CategoryEntity();
        cat.setId(1L);
        cat.setName("cat");
        CountEntity countEntity = new CountEntity();
        countEntity.setId(1L);
        countEntity.setCurrency(Currency.COP);
        countEntity.setType(CountType.BANCO);
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAmount(new BigDecimal(1));
        transactionEntity.setDescription("description");
        transactionEntity.setType(TransactionType.EGRESO);
        transactionEntity.setCategory(cat);
        transactionEntity.setCount(countEntity);
        return transactionEntity;
    }

    private TransactionEntity getTransactionEntitySaved() {
        TransactionEntity transactionEntity = getTransactionEntity();
        transactionEntity.setId(1L);
        transactionEntity.setTransactionDate(LocalDateTime.now());
        return transactionEntity;
    }

}