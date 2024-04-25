package com.zuriapp.piggybank.application.port.out;

import com.zuriapp.piggybank.domain.models.Person;

public interface PersonOutPutPort {
    Person save(Person person)  throws Exception;;
    Person findById(Long id)  throws Exception;;
}
