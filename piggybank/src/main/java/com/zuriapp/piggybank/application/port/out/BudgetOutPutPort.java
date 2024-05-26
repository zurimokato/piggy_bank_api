package com.zuriapp.piggybank.application.port.out;

import com.zuriapp.piggybank.domain.models.Budget;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BudgetOutPutPort {
    Budget save(Budget budget);
    Budget findById(Long id);
    Page<Budget> findAllByPerson(Long userId, Pageable pageable);
}
