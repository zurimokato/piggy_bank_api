package com.zuriapp.piggybank.domain.service;

import com.zuriapp.piggybank.application.port.in.budget.CreateBudgetUseCase;
import com.zuriapp.piggybank.application.port.in.budget.FindBudgetUseCase;
import com.zuriapp.piggybank.application.port.out.BudgetOutPutPort;
import com.zuriapp.piggybank.domain.models.Budget;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BudgetService implements FindBudgetUseCase, CreateBudgetUseCase {
    private final BudgetOutPutPort budgetOutPutPort;

    @Override
    public Budget create(Budget budget) {
        return budgetOutPutPort.save(budget);
    }

    @Override
    public Page<Budget> findBudgetByPerson(Long userId, Pageable pageable) {
        return budgetOutPutPort.findAllByPerson(userId, pageable);
    }

    @Override
    public Budget findBudgetById(Long id) {
        return budgetOutPutPort.findById(id);
    }
}
