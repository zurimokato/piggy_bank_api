package com.zuriapp.piggybank.infrastructure.adapters.out.database;

import com.zuriapp.piggybank.application.port.out.BudgetOutPutPort;
import com.zuriapp.piggybank.domain.models.Budget;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper.BudgetEntityMapper;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.repository.BudgetRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BudgetPersistenceAdapter implements BudgetOutPutPort {
    private final BudgetRepository budgetRepository;
    private final BudgetEntityMapper budgetEntityMapper;
    @Override
    public Budget save(Budget budget) {
        return budgetEntityMapper.toModel(budgetRepository.save(budgetEntityMapper.toEntity(budget)));
    }

    @Override
    public Budget findById(Long id) {
        return budgetEntityMapper.toModel(budgetRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("Could not find budget with id: " + id)
        ));
    }

    @Override
    public Page<Budget> findAllByPerson(Long idPerson, Pageable pageable) {
        return budgetRepository.findAllByPersonId(idPerson,pageable).map(budgetEntityMapper::toModel);
    }
}
