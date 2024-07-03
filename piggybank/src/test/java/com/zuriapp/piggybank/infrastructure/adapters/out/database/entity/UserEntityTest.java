package com.zuriapp.piggybank.infrastructure.adapters.out.database.entity;

import com.zuriapp.piggybank.domain.enums.Role;
import com.zuriapp.piggybank.domain.enums.Status;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class UserEntityTest {

    @Test
    void getAuthorities() {
        UserEntity userEntity=getInstance();
        userEntity.setRole(Role.USER);
        assertEquals(List.of(new SimpleGrantedAuthority(Role.USER.name())), userEntity.getAuthorities());
    }

    @Test
    void getUsername() {
        UserEntity user=getInstance();
        user.setUserName("username");
        assertEquals("username",user.getUsername());
    }

    @Test
    void isAccountNonExpired() {
        UserEntity user=getInstance();
        user.setStatus(Status.ACTIVE);
        assertTrue(user.isAccountNonExpired());
    }

    @Test
    void isAccountNonLocked() {
        UserEntity user=getInstance();
        user.setStatus(Status.ACTIVE);
        assertTrue(user.isAccountNonLocked());
    }

    @Test
    void isCredentialsNonExpired() {
        UserEntity user=getInstance();
        user.setStatus(Status.ACTIVE);
        assertTrue(user.isCredentialsNonExpired());
    }

    @Test
    void isEnabled() {
        UserEntity user=getInstance();
        user.setStatus(Status.ACTIVE);
        assertTrue(user.isEnabled());
    }

    @Test
    void getId() {
        UserEntity user=getInstance();
        user.setId(new Random().nextLong());
        assertNotNull(user.getId());
    }

    @Test
    void getPassword() {
        UserEntity user=getInstance();
        user.setPassword("password");
        assertEquals("password",user.getPassword());
    }

    @Test
    void getEmail() {
        UserEntity user=getInstance();
        user.setEmail("email");
        assertEquals("email",user.getEmail());
    }

    @Test
    void getRole() {
        UserEntity user=getInstance();
        user.setRole(Role.USER);
        assertEquals(Role.USER,user.getRole());
    }

    @Test
    void getCreateTime() {
        UserEntity user=getInstance();
        user.setCreateTime(LocalDate.now());
        assertNotNull(user.getCreateTime());
    }

    @Test
    void getUpdateTime() {
        UserEntity user=getInstance();
        user.setUpdateTime(LocalDate.now());
        assertNotNull(user.getUpdateTime());
    }

    @Test
    void getPerson() {
        PersonEntity person= new PersonEntity();
        person.setFirstName("firstName");
        person.setId(1L);
        UserEntity user=getInstance();
        user.setPerson(person);
        assertEquals(person,user.getPerson());
    }


    private UserEntity getInstance(){
        return new UserEntity();
    }
}