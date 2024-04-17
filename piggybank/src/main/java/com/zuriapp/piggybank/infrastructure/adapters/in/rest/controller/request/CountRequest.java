package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request;

import com.zuriapp.piggybank.domain.Person;
import com.zuriapp.piggybank.domain.enums.CountType;
import com.zuriapp.piggybank.domain.enums.Currency;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@Builder
public class CountRequest {

    private Long id;
    private String name;
    private CountType type;
    private BigDecimal amount;
    private Currency currency;
    private Person person;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}