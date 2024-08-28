package com.zuriapp.piggybank.application.port.in.count;

import com.zuriapp.piggybank.application.exceptions.DomainException;
import com.zuriapp.piggybank.domain.models.Count;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindCountUseCase {

    Page<Count> findCountUseCase(Long personId, Pageable pageable) throws DomainException;

    Count findCountById(Long id) throws DomainException;
}
