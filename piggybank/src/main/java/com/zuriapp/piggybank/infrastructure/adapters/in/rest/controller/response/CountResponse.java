package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response;

import com.zuriapp.piggybank.domain.enums.Status;
import com.zuriapp.piggybank.domain.enums.CountType;
import com.zuriapp.piggybank.domain.enums.Currency;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
public class CountResponse {

    private Long id;
    private String name;
    private CountType type;
    private BigDecimal amount;
    private Currency currency;
    private Status status;
    private UserResponse user;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
