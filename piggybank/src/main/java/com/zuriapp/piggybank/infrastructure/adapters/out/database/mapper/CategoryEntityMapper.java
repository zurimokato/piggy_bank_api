package com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper;

import com.zuriapp.piggybank.domain.Category;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.CategoryEntity;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", uses = {TransactionEntityMapper.class})
public interface CategoryEntityMapper {


    Category toDomain(CategoryEntity categoryEntity);

    CategoryEntity toEntity(Category category);
}
