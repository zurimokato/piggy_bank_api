package com.zuriapp.piggybank.domain;

import com.zuriapp.piggybank.domain.enums.TransactionCategoryType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class TransactionCategory {

    private Long id;
    private String name;
    private String description;
    private BigDecimal budget;
    private TransactionCategoryType type;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
