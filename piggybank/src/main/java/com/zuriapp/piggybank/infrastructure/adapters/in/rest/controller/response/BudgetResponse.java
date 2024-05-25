package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response;

import com.zuriapp.piggybank.domain.enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@Builder
public class BudgetResponse {
    private Long id;
    private BigDecimal budget;
    private PersonResponse person;
    private CategoryResponse category;
    private Status status;
}
