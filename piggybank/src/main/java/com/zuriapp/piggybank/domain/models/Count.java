package com.zuriapp.piggybank.domain.models;

import com.zuriapp.piggybank.domain.enums.CountType;
import com.zuriapp.piggybank.domain.enums.Currency;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@Builder
public class Count {
    private Long id;
    private String name;
    private CountType type;
    private BigDecimal amount;
    private Currency currency;
    private Person person;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
