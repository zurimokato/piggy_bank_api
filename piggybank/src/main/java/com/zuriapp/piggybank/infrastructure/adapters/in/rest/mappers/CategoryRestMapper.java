package com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers;

import com.zuriapp.piggybank.domain.models.Category;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.CategoryRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryRestMapper {


    @Mapping(target = "categories", ignore = true)
    @Mapping(target = "categoryFather", source = "category")
    Category toDomain(CategoryRequest source);


    @Mapping(target = "categories", source = "categories")
    @Mapping(target = "category", source = "categoryFather")
    @Mapping(target = "categories.category", ignore = true)
    @Mapping(target = "category.categories", ignore = true)
    CategoryResponse toResponse(Category source);
}
