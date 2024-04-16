package com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper;

import com.zuriapp.piggybank.domain.Category;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {TransactionEntityMapper.class})
public interface CategoryEntityMapper {

    @Mappings({
            @Mapping(source = "transactions",target = "transactions")
    })
    Category toDomain(CategoryEntity categoryEntity);
    @Mappings({
            @Mapping(source = "transactions",target = "transactions")
    })
    CategoryEntity toEntity(Category category);
}
