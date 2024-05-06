package com.zuriapp.piggybank.domain.models;

import com.zuriapp.piggybank.domain.enums.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserTest {

    private  User getInstance(){
        return User.builder().build();
    }

    @Test
    void getId() {
        User user = getInstance();
        Long id = new Random().nextLong();
        user.setId(id);
        assertEquals(id, user.getId());

    }

    @Test
    void getEmail() {
        User user = getInstance();
        user.setEmail("email@email.com");
        assertEquals("email@email.com", user.getEmail());
    }

    @Test
    void getPerson() {
        User user = getInstance();
        Person person = Person.builder().build();
        user.setPerson(person);
        assertEquals(person, user.getPerson());
    }

    @Test
    void getRole() {
        User user = getInstance();
        user.setRole(Role.USER);
        assertEquals(Role.USER, user.getRole());
    }

    @Test
    void getCreateTime() {
        User user = getInstance();
        LocalDateTime createTime = user.getCreateTime();
        user.setCreateTime(createTime);
        assertEquals(createTime, user.getCreateTime());
    }

    @Test
    void getUpdateTime() {
        User user = getInstance();
        LocalDateTime updateTime = user.getUpdateTime();
        user.setUpdateTime(updateTime);
        assertEquals(updateTime, user.getUpdateTime());
    }
}