package com.zuriapp.piggybank.domain.models;

import com.zuriapp.piggybank.domain.enums.CountType;
import com.zuriapp.piggybank.domain.enums.Currency;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CountTest {

    private Count getInstance() {
        return Count.builder().build();
    }

    @Test
    void getId() {
        Count count = getInstance();
        Long id = new Random().nextLong();
        count.setId(id);
        assertEquals(id, count.getId());
    }

    @Test
    void getName() {
        Count count = getInstance();
        count.setName("Test");
        assertEquals("Test", count.getName());
    }

    @Test
    void getType() {
        Count count = getInstance();
        count.setType(CountType.BANCO);
        assertEquals(CountType.BANCO, count.getType());
    }

    @Test
    void getAmount() {
        Count count = getInstance();
        BigDecimal amount = BigDecimal.valueOf(new Random().nextDouble());
        count.setAmount(amount);
        assertEquals(amount, count.getAmount());

    }

    @Test
    void getCurrency() {
        Count count = getInstance();
        count.setCurrency(Currency.COP);
        assertEquals(Currency.COP, count.getCurrency());
    }

    @Test
    void getPerson() {
        Count count = getInstance();
        User user = new User();
        count.setUser(user);
        assertEquals(user, count.getUser());
    }

    @Test
    void getCreateTime() {
        Count count = getInstance();
        LocalDateTime create = LocalDateTime.now();
        count.setCreateTime(create);
        assertEquals(create, count.getCreateTime());
    }

    @Test
    void getUpdateTime() {
        Count count = getInstance();
        LocalDateTime update = LocalDateTime.now();
        count.setUpdateTime(update);
        assertEquals(update, count.getUpdateTime());
    }
}