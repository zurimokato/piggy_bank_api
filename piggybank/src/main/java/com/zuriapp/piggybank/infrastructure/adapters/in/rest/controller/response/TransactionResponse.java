package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response;

import com.zuriapp.piggybank.domain.Category;
import com.zuriapp.piggybank.domain.Count;
import com.zuriapp.piggybank.domain.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransactionResponse {

    private Long id;
    private String description;
    private BigDecimal amount;
    private LocalDate transactionDate;
    private TransactionType type;
    private CountResponse count;
    private CategoryResponse category;
    private LocalDateTime createTime;
}
