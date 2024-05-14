package com.zuriapp.piggybank.infrastructure.adapters.out.database.entity;

import com.zuriapp.piggybank.domain.enums.Status;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonEntityTest {

    @Test
    void getId() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(1L);
        assertEquals(1L, personEntity.getId());
    }

    @Test
    void getFirstName() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName("John");
        assertEquals("John", personEntity.getFirstName());
    }

    @Test
    void getFirstLastName() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstLastName("Doe");
        assertEquals("Doe", personEntity.getFirstLastName());
    }

    @Test
    void getSecondName() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setSecondName("John");
        assertEquals("John", personEntity.getSecondName());
    }

    @Test
    void getSecondLastName() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setSecondLastName("Doe");
        assertEquals("Doe", personEntity.getSecondLastName());
    }

    @Test
    void getAge() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setAge(23);
        assertEquals(23, personEntity.getAge());
    }

    @Test
    void getGender() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setGender('M');
        assertEquals('M', personEntity.getGender());
    }

    @Test
    void getNit() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setNit("12345");
        assertEquals("12345", personEntity.getNit());
    }

    @Test
    void getPhone() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setPhone("1234567890");
        assertEquals("1234567890", personEntity.getPhone());
    }

    @Test
    void getStatus() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setStatus(Status.ACTIVE);
        assertEquals(Status.ACTIVE, personEntity.getStatus());
    }

    @Test
    void getUser() {
        PersonEntity personEntity = new PersonEntity();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        personEntity.setUser(userEntity);
        assertEquals(userEntity, personEntity.getUser());
    }

    @Test
    void getCounts() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(1L);
        CountEntity countEntity = new CountEntity();
        countEntity.setId(2L);
        countEntity.setName("name");
        countEntity.setPerson(personEntity);
        List<CountEntity>countEntityList= List.of(countEntity);
        personEntity.setCounts(countEntityList);
        assertEquals(countEntityList, personEntity.getCounts());
    }

    @Test
    void getCreateTime() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setCreateTime(LocalDateTime.now());
        assertNotNull(personEntity.getCreateTime());

    }

    @Test
    void getUpdateTime() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setUpdateTime(LocalDateTime.now());
        assertNotNull(personEntity.getUpdateTime());
    }

    private PersonEntity getPersonEntity() {
        return new PersonEntity();
    }
}