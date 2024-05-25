package com.zuriapp.piggybank.domain.models;

import com.zuriapp.piggybank.domain.enums.TransactionType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class TransactionTest {

    private Transaction getInstance(){
        return Transaction.builder().build();
    }

    @Test
    void getId() {
        Transaction transaction = getInstance();
        Long id = new Random().nextLong();
        transaction.setId(id);
        assertEquals(id, transaction.getId());
    }

    @Test
    void hashCodeTest() {
        Transaction transaction = getInstance();
        Transaction transaction2 = getInstance();
        assertEquals(transaction.hashCode(), transaction2.hashCode());
        assertEquals(transaction.equals(transaction2),transaction2.equals(transaction));
    }

    @Test
    void hashCodeNotTest() {
        Transaction transaction = getInstance();
        Transaction transaction2 = getInstance();
        transaction.setId(1L);
        transaction2.setId(2L);
        assertNotEquals(transaction.hashCode(), transaction2.hashCode());
        assertNotEquals(transaction, transaction2);
    }

    @Test
    void toStringTest() {
        Transaction transaction = getInstance();
        String toString = transaction.toString();
        assertNotNull(toString);
    }

    @Test
    void getDescription() {
        Transaction transaction = getInstance();
        transaction.setDescription("description");
        assertEquals("description", transaction.getDescription());
    }

    @Test
    void getAmount() {
        Transaction transaction = getInstance();
        transaction.setAmount(new BigDecimal("100.00"));
        assertEquals(new BigDecimal("100.00"), transaction.getAmount());
    }

    @Test
    void getTransactionDate() {
        Transaction transaction = getInstance();
        LocalDate transactionDate = LocalDate.now();
        transaction.setTransactionDate(transactionDate);
        assertEquals(transactionDate, transaction.getTransactionDate());
    }

    @Test
    void getType() {
        Transaction transaction = getInstance();
        transaction.setType(TransactionType.EGRESO);
        assertEquals(TransactionType.EGRESO, transaction.getType());
    }

    @Test
    void getCount() {
        Transaction transaction = getInstance();
        Count count= Count.builder().build();
        transaction.setCount(count);
        assertEquals(count, transaction.getCount());
    }

    @Test
    void getCategory() {
        Transaction transaction = getInstance();
        Category category= Category.builder().build();
        transaction.setCategory(category);
        assertEquals(category, transaction.getCategory());
    }

    @Test
    void getCreateTime() {
        Transaction transaction = getInstance();
        LocalDateTime create=LocalDateTime.now();
        transaction.setCreateTime(create);
        assertEquals(create, transaction.getCreateTime());
    }
}