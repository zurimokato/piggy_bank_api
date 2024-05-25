package com.zuriapp.piggybank.infrastructure.adapters.out.database.entity;

import com.zuriapp.piggybank.domain.enums.CategoryType;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CategoryEntityTest {

    @Test
    void getId() {
        CategoryEntity category=getCategoryEntity();
        category.setId(new Random().nextLong());
        assertNotNull(category.getId());
    }

    @Test
    void getName() {
        CategoryEntity category=getCategoryEntity();
        category.setName("name");
        assertNotNull(category.getName());
    }


    @Test
    void getType() {
        CategoryEntity category=getCategoryEntity();
        category.setType(CategoryType.FIJO);
        assertNotNull(category.getType());
    }

    @Test
    void getCreateTime() {
        CategoryEntity category=getCategoryEntity();
        category.setCreateTime(LocalDateTime.now());
        assertNotNull(category.getCreateTime());
    }

    @Test
    void getUpdateTime() {
        CategoryEntity category=getCategoryEntity();
        category.setUpdateTime(LocalDateTime.now());
        assertNotNull(category.getUpdateTime());
    }

    private CategoryEntity getCategoryEntity() {
        return new CategoryEntity();
    }
}