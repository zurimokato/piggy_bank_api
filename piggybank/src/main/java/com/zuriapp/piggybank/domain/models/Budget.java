package com.zuriapp.piggybank.domain.models;

import com.zuriapp.piggybank.domain.enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class Budget {
    private Long id;
    private BigDecimal amount;
    private Status status;
    private String name;
    private User user;
    private Category category;
}
