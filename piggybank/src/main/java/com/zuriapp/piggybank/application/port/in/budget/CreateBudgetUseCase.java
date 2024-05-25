package com.zuriapp.piggybank.application.port.in.budget;

import com.zuriapp.piggybank.domain.models.Budget;

public interface CreateBudgetUseCase {
    Budget  create(Budget budget);
}
