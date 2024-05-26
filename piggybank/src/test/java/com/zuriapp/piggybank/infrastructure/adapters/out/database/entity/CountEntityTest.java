package com.zuriapp.piggybank.infrastructure.adapters.out.database.entity;

import com.zuriapp.piggybank.domain.enums.CountType;
import com.zuriapp.piggybank.domain.enums.Currency;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountEntityTest {

    @Test
    void getId() {
        CountEntity category = getCountEntity();
        category.setId(1L);
        assertEquals(category.getId(), 1L);
    }

    @Test
    void getName() {
        CountEntity category = getCountEntity();
        category.setName("Test");
        assertEquals("Test", category.getName());
    }

    @Test
    void getType() {
        CountEntity category = getCountEntity();
        category.setType(CountType.BANCO);
        assertEquals(category.getType(), CountType.BANCO);
    }

    @Test
    void getCurrency() {
        CountEntity category = getCountEntity();
        category.setCurrency(Currency.COP);
        assertEquals(category.getCurrency(), Currency.COP);

    }

    @Test
    void getAmount() {
        CountEntity category = getCountEntity();
        category.setAmount(new BigDecimal(1));
        assertEquals(category.getAmount(), new BigDecimal(1));
    }

    @Test
    void getPerson() {
        CountEntity category = getCountEntity();
        UserEntity user = new UserEntity();
        user.setUserName("firstName");
        user.setId(1L);
        category.setUser(user);
        assertEquals(category.getUser(), user);
    }

    @Test
    void getTransactions() {
        CountEntity category = getCountEntity();
        TransactionEntity transaction = new TransactionEntity();
        transaction.setAmount(new BigDecimal(1));
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setId(1L);
        List<TransactionEntity> transactions = List.of(transaction);
        category.setTransactions(transactions);
        assertEquals(category.getTransactions(), transactions);
    }

    @Test
    void getCreateTime() {
        CountEntity category = getCountEntity();
        category.setCreateTime(LocalDateTime.now());
        assertEquals(category.getCreateTime(), LocalDateTime.now());
    }

    @Test
    void getUpdateTime() {
        CountEntity category = getCountEntity();
        category.setUpdateTime(LocalDateTime.now());
        assertEquals(category.getUpdateTime(), LocalDateTime.now());
    }

    private CountEntity getCountEntity() {
        return new CountEntity();
    }
}