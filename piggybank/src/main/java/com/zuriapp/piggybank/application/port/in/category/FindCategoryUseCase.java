package com.zuriapp.piggybank.application.port.in.category;

import com.zuriapp.piggybank.domain.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FindCategoryUseCase {

    Page<Category> findAllCategories(Pageable request);

    Category findCategoryById(Long id);

    List<Category> findAllCategories();
}
