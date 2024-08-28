package com.zuriapp.piggybank.application.port.out;

import com.zuriapp.piggybank.application.exceptions.InfrastructureException;
import com.zuriapp.piggybank.domain.models.Person;

public interface PersonOutPutPort {
    Person save(Person person)  throws InfrastructureException;
    Person findById(Long id)  throws InfrastructureException;
}
