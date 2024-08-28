package com.zuriapp.piggybank.domain.models;

import com.zuriapp.piggybank.domain.enums.CountType;
import com.zuriapp.piggybank.domain.enums.Currency;
import com.zuriapp.piggybank.domain.enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@Builder
public class Count implements Serializable {
    private Long id;
    private String name;
    private CountType type;
    private BigDecimal amount;
    private Currency currency;
    private Status status;
    private User user;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
