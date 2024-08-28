package com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper;

import com.zuriapp.piggybank.domain.models.Category;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {TransactionEntityMapper.class})
public interface CategoryEntityMapper {

    @Mappings({
            @Mapping(target = "categories",source = "categories"),
            @Mapping(target = "categoryFather",source = "category"),
            @Mapping(target = "categories.category",ignore = true),
            @Mapping(target = "categoryFather.categories",ignore = true),
    })

    Category toDomain(CategoryEntity categoryEntity);

    @Mapping(target = "category",source = "categoryFather")
    CategoryEntity toEntity(Category category);
}
