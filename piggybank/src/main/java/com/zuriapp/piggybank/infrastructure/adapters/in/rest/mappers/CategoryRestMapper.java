package com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers;

import com.zuriapp.piggybank.domain.models.Category;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.CategoryRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.CategoryResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryRestMapper {

    Category toDomain(CategoryRequest source);


    CategoryResponse toResponse(Category source);
}
