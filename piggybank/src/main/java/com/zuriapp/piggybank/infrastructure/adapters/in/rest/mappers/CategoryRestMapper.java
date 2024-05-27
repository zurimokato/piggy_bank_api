package com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers;

import com.zuriapp.piggybank.domain.models.Category;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.CategoryRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryRestMapper {

    @Mappings({
            @Mapping(target = "categories",ignore = true),
            @Mapping(target = "category",source = "category"),
    })

    Category toDomain(CategoryRequest source);


    @Mappings({
            @Mapping(target = "categories",source = "categories"),
            @Mapping(target = "category",source = "category"),
            @Mapping(target = "categories.category",ignore = true),
            @Mapping(target = "category.categories",ignore = true),
    })
    CategoryResponse toResponse(Category source);
}
