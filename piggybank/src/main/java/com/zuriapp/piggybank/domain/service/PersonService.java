package com.zuriapp.piggybank.domain.service;

import com.zuriapp.piggybank.application.exceptions.DomainException;
import com.zuriapp.piggybank.application.port.in.person.CreatePersonUseCase;
import com.zuriapp.piggybank.application.port.in.person.FindPersonUseCase;
import com.zuriapp.piggybank.application.port.out.PersonOutPutPort;
import com.zuriapp.piggybank.application.port.out.UserOutPort;
import com.zuriapp.piggybank.domain.enums.Status;
import com.zuriapp.piggybank.domain.models.Person;
import com.zuriapp.piggybank.domain.models.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService implements CreatePersonUseCase, FindPersonUseCase {
    private final UserOutPort userOutPort;
    private final PersonOutPutPort personPort;

    @Override
    public Person createPerson(Person person) throws DomainException {
        try {
            User user = person.getUser();
            user.setCreateTime(LocalDateTime.now());
            if(user.getId()==null) {
                final User saved = userOutPort.save(user);
                person.setUser(saved);
            }
            person.setStatus(Status.ACTIVE);
            person.setCreateTime(LocalDateTime.now());
            return personPort.save(person);
        }catch (Exception e) {
            throw new DomainException(e.getMessage());
        }
    }

    @Override
    public Person findPersonById(Long id) throws DomainException {
        try {
            return personPort.findById(id);
        }catch (Exception e) {
            throw new DomainException(e.getMessage());
        }
    }
}
