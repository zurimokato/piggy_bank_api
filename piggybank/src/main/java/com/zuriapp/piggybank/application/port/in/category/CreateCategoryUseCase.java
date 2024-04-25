package com.zuriapp.piggybank.application.port.in.category;

import com.zuriapp.piggybank.domain.models.Category;

public interface CreateCategoryUseCase {

    Category createCategory(Category category) throws Exception;
}
