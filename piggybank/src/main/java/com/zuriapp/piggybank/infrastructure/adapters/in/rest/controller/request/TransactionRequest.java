package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request;

import com.zuriapp.piggybank.domain.models.Category;
import com.zuriapp.piggybank.domain.models.Count;
import com.zuriapp.piggybank.domain.enums.TransactionType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
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
