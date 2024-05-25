package com.zuriapp.piggybank.domain.models;

import com.zuriapp.piggybank.domain.enums.Status;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class PersonTest {


    private  Person getInstance(){
        return Person.builder().build();
    }

    @Test
    void getId() {
        Person person = getInstance();
        Long id=new Random().nextLong();
        person.setId(id);
        assertEquals(id,person.getId());
    }
    @Test
    void hashCodeTest() {
        Person person = getInstance();
        Person other = getInstance();
        assertEquals(person.hashCode(), other.hashCode());
        assertEquals(person.equals(other),other.equals(person));
    }

    @Test
    void hashCodeNotTest() {
        Person person= getInstance();
        Person person2 = getInstance();
        person.setId(1L);
        person2.setId(2L);
        assertNotEquals(person.hashCode(), person2.hashCode());
        assertNotEquals(person, person2);
    }

    @Test
    void toStringTest() {
        Person person = getInstance();
        String toString = person.toString();
        assertNotNull(toString);
    }

    @Test
    void getFirstName() {
        Person person = getInstance();
        person.setFirstName("John");
        assertEquals("John",person.getFirstName());

    }

    @Test
    void getFirstLastName() {
        Person person = getInstance();
        person.setFirstLastName("Smith");
        assertEquals("Smith",person.getFirstLastName());

    }

    @Test
    void getSecondName() {
        Person person = getInstance();
        person.setSecondName("John");
        assertEquals("John",person.getSecondName());

    }

    @Test
    void getSecondLastName() {
        Person person = getInstance();
        person.setSecondLastName("Smith");
        assertEquals("Smith",person.getSecondLastName());

    }

    @Test
    void getAge() {
        Person person = getInstance();
        person.setAge(20);
        assertEquals(20,person.getAge());

    }

    @Test
    void getGender() {
        Person person = getInstance();
        person.setGender('M');
        assertEquals('M',person.getGender());

    }

    @Test
    void getNit() {
        Person person = getInstance();
        person.setNit("12345");
        assertEquals("12345",person.getNit());

    }

    @Test
    void getPhone() {
        Person person = getInstance();
        person.setPhone("1234567890");
        assertEquals("1234567890",person.getPhone());

    }

    @Test
    void getStatus() {
        Person person = getInstance();
        person.setStatus(Status.ACTIVE);
        assertEquals(Status.ACTIVE,person.getStatus());

    }

    @Test
    void getUser() {
        Person person = getInstance();
        person.setUser(User.builder().build());
        assertEquals(User.builder().build(),person.getUser());

    }

    @Test
    void getCounts() {
        Person person = getInstance();
        List<Count> counts = new ArrayList<>();
        person.setCounts(counts);
        assertEquals(counts,person.getCounts());


    }

    @Test
    void getCreateTime() {
        Person person = getInstance();
        LocalDateTime createTime = person.getCreateTime();
        person.setCreateTime(createTime);
        assertEquals(createTime,person.getCreateTime());

    }

    @Test
    void getUpdateTime() {
        Person person = getInstance();
        LocalDateTime updateTime = person.getUpdateTime();
        person.setUpdateTime(updateTime);
        assertEquals(updateTime,person.getUpdateTime());

    }
}