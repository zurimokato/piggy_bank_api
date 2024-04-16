package com.zuriapp.piggybank.infrastructure.adapters.out.database.repository;

import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.PersonEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonCrudRepository extends CommonRepository<PersonEntity,Long> {
}
