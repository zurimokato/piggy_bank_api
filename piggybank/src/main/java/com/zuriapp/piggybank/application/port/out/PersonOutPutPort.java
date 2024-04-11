package com.zuriapp.piggybank.application.port.out;

import com.zuriapp.piggybank.domain.Person;

public interface PersonOutPutPort {
    Person save(Person person);
    Person findById(Long id);
}
