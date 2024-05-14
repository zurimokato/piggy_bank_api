package com.zuriapp.piggybank.domain.service;

import com.zuriapp.piggybank.application.port.out.TransactionOutPutPort;
import com.zuriapp.piggybank.domain.enums.TransactionType;
import com.zuriapp.piggybank.domain.models.Category;
import com.zuriapp.piggybank.domain.models.Transaction;
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
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @Mock
    private TransactionOutPutPort transactionOutPutPort;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    void createTransaction() throws Exception {
        final Transaction req=getInstance();
        Mockito.when(transactionOutPutPort.save(Mockito.any(Transaction.class)))
                .thenReturn(getInstanceSaved());
        var result = transactionService.createTransaction(req);
        assertNotNull(result);

    }

    @Test
    void findTransactionsByCount() throws Exception {
        final Transaction req=getInstanceSaved();
        final Transaction req2=getInstanceSaved();
        List<Transaction> transactions = List.of(req,req2);
        Page<Transaction>page=new PageImpl<>(transactions);
        Mockito.when(transactionOutPutPort.findAllByCount(Mockito.any(Long.class),Mockito.any(Pageable.class)))
                .thenReturn(page);
        Pageable pageable=Pageable.ofSize(transactions.size());
        var result=transactionService.findTransactionsByCount(new Random().nextLong(),pageable);
        assertNotNull(result);
    }

    @Test
    void findTransactionById() throws Exception {
        Mockito.when(transactionOutPutPort.findByTransactionId(Mockito.any(Long.class)))
                .thenReturn(getInstanceSaved());
        var result=transactionService.findTransactionById(new Random().nextLong());
        assertNotNull(result);
    }

    private Transaction getInstance(){
        return Transaction.builder()
                .amount(new BigDecimal(15))
                .category(Category.builder().id(1L).build())
                .type(TransactionType.EGRESO)
                .description("hijo")
                .transactionDate(LocalDate.now()).build();
    }
    private Transaction getInstanceSaved(){
        return Transaction.builder()
                .id(new Random().nextLong())
                .amount(new BigDecimal(15))
                .category(Category.builder().id(1L).build())
                .type(TransactionType.EGRESO)
                .description("hijo")
                .transactionDate(LocalDate.now()).build();
    }
}