package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response;

import com.zuriapp.piggybank.domain.Person;
import com.zuriapp.piggybank.domain.enums.CountType;
import com.zuriapp.piggybank.domain.enums.Currency;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Data
public class CountResponse {

    private Long id;
    private String name;
    private CountType type;
    private BigDecimal amount;
    private Currency currency;
    private Person person;
    private List<TransactionResponse> transactions;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
