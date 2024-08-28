package com.zuriapp.piggybank.application.port.out;

import com.zuriapp.piggybank.application.exceptions.InfrastructureException;
import com.zuriapp.piggybank.domain.models.Count;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CountOutPort {

    Count save(Count count) throws InfrastructureException;
    Count getCountById(Long id)  throws InfrastructureException;
    Page<Count> getAllCountsByPerson(Long userId,Pageable pageable) throws InfrastructureException;
}
