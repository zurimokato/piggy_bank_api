package com.zuriapp.piggybank.domain;

import com.zuriapp.piggybank.domain.enums.TransactionType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Builder
public class Transaction {
    private Long id;
    private String description;
    private BigDecimal amount;
    private LocalDate date;
    private TransactionType type;
    private Count count;
    private Category category;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
