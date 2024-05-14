package com.zuriapp.piggybank.infrastructure.adapters.out.database.entity;

import com.zuriapp.piggybank.domain.enums.TransactionType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TransactionEntityTest {

    @Test
    void getId() {
        TransactionEntity transactionEntity = getTransactionEntity();
        transactionEntity.setId(1L);
        assertEquals(1L, transactionEntity.getId());
    }

    @Test
    void getDescription() {
        TransactionEntity transactionEntity = getTransactionEntity();
        transactionEntity.setDescription("description");
        assertEquals("description", transactionEntity.getDescription());
    }

    @Test
    void getAmount() {
        TransactionEntity transactionEntity = getTransactionEntity();
        transactionEntity.setAmount(new BigDecimal("100.00"));
        assertEquals(new BigDecimal("100.00"), transactionEntity.getAmount());
    }

    @Test
    void getType() {
        TransactionEntity transactionEntity = getTransactionEntity();
        transactionEntity.setType(TransactionType.EGRESO);
        assertEquals(TransactionType.EGRESO, transactionEntity.getType());
    }

    @Test
    void getTransactionDate() {
        TransactionEntity transactionEntity = getTransactionEntity();
        transactionEntity.setTransactionDate(LocalDateTime.now());
        assertNotNull(transactionEntity.getTransactionDate());
    }

    @Test
    void getCreateTime() {
        TransactionEntity transactionEntity = getTransactionEntity();
        transactionEntity.setCreateTime(LocalDateTime.now());
        assertNotNull(transactionEntity.getCreateTime());

    }

    @Test
    void getCount() {
        TransactionEntity transactionEntity = getTransactionEntity();
        CountEntity count= new CountEntity();
        count.setId(1L);
        transactionEntity.setCount(count);
        assertEquals(count, transactionEntity.getCount());
    }

    @Test
    void getCategory() {
        TransactionEntity transactionEntity = getTransactionEntity();
        CategoryEntity category = new CategoryEntity();
        category.setId(1L);
        transactionEntity.setCategory(category);
        assertEquals(category, transactionEntity.getCategory());
    }

    private TransactionEntity getTransactionEntity() {
        return new TransactionEntity();
    }


}