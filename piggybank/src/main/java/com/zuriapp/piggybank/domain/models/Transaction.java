package com.zuriapp.piggybank.domain.models;

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
public class Transaction {
    private Long id;
    private String description;
    private BigDecimal amount;
    private LocalDate transactionDate;
    private TransactionType type;
    private Count count;
    private Category category;
    private LocalDateTime createTime;
}
