package com.zuriapp.piggybank.application.port.in.count;

import com.zuriapp.piggybank.application.exceptions.DomainException;
import com.zuriapp.piggybank.domain.models.Count;

public interface CreateCountUseCase {
    Count createCount(Count count) throws DomainException;
}
