package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request;

import com.zuriapp.piggybank.domain.enums.Status;
import com.zuriapp.piggybank.domain.models.User;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class BudgetRequest {
    private Long id;
    @NotNull
    private BigDecimal budget;
    private User user;
    private CategoryRequest category;
    private Status status;
}
