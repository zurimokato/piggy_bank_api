package com.zuriapp.piggybank.infrastructure.adapters.out.database;

import com.zuriapp.piggybank.application.port.out.UserOutPort;
import com.zuriapp.piggybank.domain.User;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper.UserEntityMapper;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.repository.UserCrudRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserOutPort {
    private final UserCrudRepository userCrudRepository;
    private final UserEntityMapper mapper;
    @Override
    public User save(User user) {
        return mapper.toDomain(userCrudRepository.saveAndFlush(mapper.toEntity(user)));
    }

    @Override
    public User findByUsername(String username) {
        return mapper.toDomain(userCrudRepository.findUserEntitiesByUserName(username)
                .orElseThrow(()-> new EntityNotFoundException("No se encontró la información solicitada")));
    }
}
