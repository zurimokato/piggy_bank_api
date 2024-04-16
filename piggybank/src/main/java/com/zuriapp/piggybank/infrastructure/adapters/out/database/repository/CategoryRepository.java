package com.zuriapp.piggybank.infrastructure.adapters.out.database.repository;

import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.CategoryEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CommonRepository<CategoryEntity,Long> {
}
