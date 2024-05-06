package com.zuriapp.piggybank.infrastructure.adapters.out.database;

import com.zuriapp.piggybank.domain.models.Person;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.PersonEntity;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper.PersonEntityMapper;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.repository.PersonCrudRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonPersistenceAdapterTest {

    @Mock
    private PersonCrudRepository personCrudRepository;
    @Mock
    private PersonEntityMapper personEntityMapper;
    @InjectMocks
    private PersonPersistenceAdapter personPersistenceAdapter;

    @Test
    void save() throws Exception {
        Mockito.when(personEntityMapper.toEntity(Mockito.any(Person.class))).thenReturn(getPersonEntityToSave());
        Mockito.when(personCrudRepository.saveAndFlush(Mockito.any(PersonEntity.class))).thenReturn(getPersonEntitySaved());
        Mockito.when(personEntityMapper.toDomain(Mockito.any(PersonEntity.class))).thenReturn(getPersonSaved());
        var result=personPersistenceAdapter.save(getPersonToSave());
        assertNotNull(result);
    }

    @Test
    void findById() {
        Mockito.when(personCrudRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.of(getPersonEntitySaved()));
        Mockito.when(personEntityMapper.toDomain(Mockito.any(PersonEntity.class))).thenReturn(getPersonSaved());
        var result=personPersistenceAdapter.findById(1L);
        assertNotNull(result);

    }

    private Person getPersonToSave(){
        return Person.builder()
                .firstName("John")
                .age(5)
                .nit("1234567")
                .phone("313555769")
                .gender('M')
                .firstLastName("Doe").build();
    }
    private Person getPersonSaved(){
        Person person = getPersonToSave();
        person.setId(new Random().nextLong());
        person.setCreateTime(LocalDateTime.now());
        return person;
    }

    private PersonEntity getPersonEntityToSave() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName("John");
        personEntity.setAge(5);
        personEntity.setGender('M');
        personEntity.setFirstLastName("Doe");
        personEntity.setNit("1234567");
        personEntity.setPhone("1356668");
        return personEntity;
    }
    private PersonEntity getPersonEntitySaved(){
        PersonEntity personEntity = getPersonEntityToSave();
        personEntity.setId(new Random().nextLong());
        return personEntity;
    }
}