package com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers;

import com.zuriapp.piggybank.domain.Category;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.CategoryRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryRestMapper {
    @Mapping(target = "transactions", ignore = true)
    Category toDomain(CategoryRequest source);

    @Mapping(target = "transactions", ignore = true)
    CategoryResponse toResponse(Category source);
}
