package com.zuriapp.piggybank.infrastructure.adapters.out.database;

import com.zuriapp.piggybank.domain.enums.Role;
import com.zuriapp.piggybank.domain.models.Person;
import com.zuriapp.piggybank.domain.models.User;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.UserEntity;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper.UserEntityMapper;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.repository.UserCrudRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserPersistenceAdapterTest {
    @Mock
    private UserCrudRepository userCrudRepository;
    @Mock
    private UserEntityMapper userEntityMapper;
    @InjectMocks
    private UserPersistenceAdapter userPersistenceAdapter;

    @Test
    void save() throws Exception {
        final User requests = getUserModel();
        Mockito.when(userEntityMapper.toEntity(Mockito.any(User.class))).thenReturn(getUserEntity());
        Mockito.when(userEntityMapper.toDomain(Mockito.any(UserEntity.class))).thenReturn(getUserSaved());
        Mockito.when(userCrudRepository.saveAndFlush(Mockito.any(UserEntity.class))).thenReturn(getUserEntitySaved());
        var result = userPersistenceAdapter.save(requests);
        assertNotNull(result);
    }

    @Test
    void findUsernameBy() {
        Mockito.when(userCrudRepository.findUserEntitiesByUserName(Mockito.any(String.class)))
                .thenReturn(Optional.of(getUserEntitySaved()));
        Mockito.when(userEntityMapper.toDomain(Mockito.any(UserEntity.class))).thenReturn(getUserSaved());
        var resp = userPersistenceAdapter.findByUsername("test");
        assertNotNull(resp);
    }


    @Test
    void findByEmail() {
        Mockito.when(userCrudRepository.findUserEntityByEmail(Mockito.any(String.class)))
                .thenReturn(Optional.of(getUserEntitySaved()));
        Mockito.when(userEntityMapper.toDomain(Mockito.any(UserEntity.class))).thenReturn(getUserSaved());
        var resp = userPersistenceAdapter.findByEmail("test@test.com");
        assertNotNull(resp);
    }

    @Test
    void findUserByName() {

        Mockito.when(userCrudRepository.findUserEntityByUserName(Mockito.any(String.class)))
                .thenReturn(Optional.of(getUserEntitySaved()));
        Mockito.when(userEntityMapper.toDomain(Mockito.any(UserEntity.class))).thenReturn(getUserSaved());
        var resp = userPersistenceAdapter.findUserByName("test");
        assertNotNull(resp);
    }

    private User getUserModel() {
        return User.builder().username("test")
                .email("test@test.com")
                .person(Person.builder()
                        .id(1L).build())
                .password("password")
                .role(Role.USER).build();
    }

    private User getUserSaved() {
        User user = getUserModel();
        user.setId(new Random().nextLong());
        return user;
    }

    private UserEntity getUserEntitySaved() {
        UserEntity entity = getUserEntity();
        entity.setId(new Random().nextLong());
        entity.setCreateTime(LocalDate.now());
        return entity;
    }

    private UserEntity getUserEntity() {
        UserEntity entity = new UserEntity();
        entity.setUserName("test");
        entity.setPassword("password");
        entity.setRole(Role.USER);
        return entity;
    }

}