package com.zuriapp.piggybank.application.port.in.budget;

import com.zuriapp.piggybank.domain.models.Budget;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindBudgetUseCase {
    Page<Budget> findBudgetByPerson(Long personId,Pageable pageable);
    Budget findBudgetById(Long id);
}
