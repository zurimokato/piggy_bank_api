package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request;

import com.zuriapp.piggybank.domain.Category;
import com.zuriapp.piggybank.domain.Count;
import com.zuriapp.piggybank.domain.enums.TransactionType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class TransactionRequest {

    private Long id;
    private String description;
    private BigDecimal amount;
    private LocalDate transactionDate;
    private TransactionType type;
    private Count count;
    private Category category;
    private LocalDateTime createTime;
}
