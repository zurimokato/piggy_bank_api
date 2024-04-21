package com.zuriapp.piggybank.infrastructure.adapters.out.database;

import com.zuriapp.piggybank.application.port.out.UserOutPort;
import com.zuriapp.piggybank.domain.User;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper.UserEntityMapper;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.repository.UserCrudRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserOutPort {
    private final UserCrudRepository userCrudRepository;
    private final UserEntityMapper mapper;
    @Value("${response.notfound.message}")
    private String notFoundMessage;

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
                .orElseThrow(() -> new EntityNotFoundException(notFoundMessage)));
    }


    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userCrudRepository.findUserEntityByUserName(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public User findByEmail(String email) {
        return mapper.toDomain(userCrudRepository.findUserEntityByEmail(email).orElseThrow(() ->
                new  IllegalArgumentException("Invalid email or password")));
    }

    @Override
    public User findByUserName(String userName) {
        return mapper.toDomain(userCrudRepository.findUserEntityByUserName(userName).orElseThrow(() ->
                new  IllegalArgumentException("Invalid email or password")));
    }
}
