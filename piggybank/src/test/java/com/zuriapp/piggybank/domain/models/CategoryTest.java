package com.zuriapp.piggybank.domain.models;

import com.zuriapp.piggybank.domain.enums.CategoryType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CategoryTest {

    Category getInstance(){
        return  Category.builder().build();
    }

    @Test
    void getId() {
        Category category = getInstance();
        category.setId(1L);
        assertEquals(1L,category.getId());

    }

    @Test
    void getName() {
        Category category = getInstance();
        category.setName("test");
        assertEquals("test", category.getName());
    }

    @Test
    void getType() {
        Category category = getInstance();
        category.setType(CategoryType.FIJO);

        assertEquals(CategoryType.FIJO,category.getType());
    }



    @Test
    void getCreateTime() {
        Category category = getInstance();
        LocalDate createTime = LocalDate.now();
        category.setCreateTime(createTime);
        assertEquals(createTime,category.getCreateTime());
    }

    @Test
    void getUpdateTime() {
        Category category = getInstance();
        LocalDate updateTime = LocalDate.now();
        category.setUpdateTime(updateTime);
        assertEquals(updateTime,category.getUpdateTime());
    }


}