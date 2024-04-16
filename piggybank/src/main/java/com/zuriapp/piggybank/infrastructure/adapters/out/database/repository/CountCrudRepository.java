package com.zuriapp.piggybank.infrastructure.adapters.out.database.repository;

import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.CountEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface CountCrudRepository extends CommonRepository<CountEntity,Long> {
    Page<CountEntity> findAllByPersonId(Long personId,Pageable pageable);
}
