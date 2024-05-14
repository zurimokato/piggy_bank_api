package com.zuriapp.piggybank.domain.models;

import com.zuriapp.piggybank.domain.enums.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserTest {

    private User getInstance() {
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
    void hashCodeTest() {
        User user = getInstance();
        User other = getInstance();
        assertEquals(user.hashCode(), other.hashCode());
        assertEquals(user.equals(other),other.equals(user));
    }

    @Test
    void hashCodeNotTest() {
        User user = getInstance();
        user.setId(1L);
        User other = getInstance();
        other.setId(2L);
        assertNotEquals(user.hashCode(), other.hashCode());
        assertNotEquals(user.equals(other),other.equals(user));
    }

    @Test
     void toStringTest() {
        User user = getInstance();
        String toString = user.toString();
        assertNotNull(toString);
    }

    @Test
    void getEmail() {
        User user = getInstance();
        user.setEmail("email@email.com");
        assertEquals("email@email.com", user.getEmail());
    }
    @Test
    void setUsername(){
        User user = getInstance();
        user.setUsername("username");
        assertEquals("username", user.getUsername());
    }
    @Test
    void setPassword(){
        User user = getInstance();
        user.setPassword("password");
        assertEquals("password", user.getPassword());
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

    @Test
    void emptyConstructorTest() {
        User user = new User();
        assertNotNull(user);
    }

    @Test
    void getAuthorities() {
        User user = getInstance();
        user.setRole(Role.USER);
        assertEquals(Role.USER, user.getRole());
        assertEquals(List.of(new SimpleGrantedAuthority(Role.USER.name())), user.getAuthorities());
    }

    @Test
    void isAccountNonExpired() {
        User user = getInstance();
        assertTrue(user.isAccountNonExpired());

    }

    @Test
    void isAccountNonLocked() {
        User user = getInstance();
        assertTrue(user.isAccountNonLocked());

    }

    @Test
    void isCredentialsNonExpired() {
        User user = getInstance();
        assertTrue(user.isCredentialsNonExpired());
    }

    @Test
    void isEnabled() {

        User user = getInstance();
        assertTrue(user.isEnabled());
    }

}