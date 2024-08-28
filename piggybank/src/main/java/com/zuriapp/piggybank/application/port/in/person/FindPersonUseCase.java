package com.zuriapp.piggybank.application.port.in.person;

import com.zuriapp.piggybank.application.exceptions.DomainException;
import com.zuriapp.piggybank.domain.models.Person;

public interface FindPersonUseCase {
    Person findPersonById(Long id) throws DomainException;
}
