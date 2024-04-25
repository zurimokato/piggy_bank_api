package com.zuriapp.piggybank.domain.service;

import com.zuriapp.piggybank.application.port.in.category.CreateCategoryUseCase;
import com.zuriapp.piggybank.application.port.in.category.FindCategoryUseCase;
import com.zuriapp.piggybank.application.port.out.CategoryOutPutPort;
import com.zuriapp.piggybank.domain.models.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService implements CreateCategoryUseCase, FindCategoryUseCase {

    private final CategoryOutPutPort categoryPort;

    @Override
    public Category createCategory(Category category) throws Exception {
        return categoryPort.save(category);
    }

    @Override
    public Page<Category> findAllCategories(Pageable request) {
        return categoryPort.findAll(request);
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryPort.findById(id);
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryPort.findAll();
    }
}
