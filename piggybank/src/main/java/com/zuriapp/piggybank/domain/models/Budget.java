package com.zuriapp.piggybank.domain.models;

import com.zuriapp.piggybank.domain.enums.Status;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.CategoryEntity;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.PersonEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class Budget {
    private Long id;
    private BigDecimal budget;
    private Status status;
    private User user;
    private CategoryEntity category;
}
