package com.zuriapp.piggybank.infrastructure.adapters.out.database;

import com.zuriapp.piggybank.application.port.out.UserOutPort;
import com.zuriapp.piggybank.domain.User;
import com.zuriapp.piggybank.infrastructure.adapters.out.config.MessageConfigAdapter;
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
    private final MessageConfigAdapter adapter;

    @Override
    public User save(User user) throws Exception {
        try {
            return mapper.toDomain(userCrudRepository.saveAndFlush(mapper.toEntity(user)));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public User findByUsername(String username) {
        return mapper.toDomain(userCrudRepository.findUserEntitiesByUserName(username)
                .orElseThrow(() -> new EntityNotFoundException(adapter.notFoundResponse())));
    }
}
