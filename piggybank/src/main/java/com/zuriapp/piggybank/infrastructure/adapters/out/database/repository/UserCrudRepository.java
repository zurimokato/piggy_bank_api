package com.zuriapp.piggybank.infrastructure.adapters.out.database.repository;


import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCrudRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity>findUserEntitiesByUserName(String username);
}
