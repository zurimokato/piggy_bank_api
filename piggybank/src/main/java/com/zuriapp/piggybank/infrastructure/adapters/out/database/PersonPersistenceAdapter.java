package com.zuriapp.piggybank.infrastructure.adapters.out.database;

import com.zuriapp.piggybank.application.port.out.PersonOutPutPort;
import com.zuriapp.piggybank.domain.models.Person;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper.PersonEntityMapper;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.repository.PersonCrudRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonPersistenceAdapter implements PersonOutPutPort {
    private final PersonCrudRepository personCrudRepository;
    private final PersonEntityMapper mapper;
    @Value("${response.notfound.message}")
    private String notFoundMessage;

    @Override
    public Person save(Person person) throws Exception {
        try {
            return mapper.toDomain(personCrudRepository.saveAndFlush(mapper.toEntity(person)));

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Person findById(Long id) {
        return mapper.toDomain(personCrudRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(notFoundMessage)));
    }
}
