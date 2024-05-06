package com.zuriapp.piggybank.domain.models;

import com.zuriapp.piggybank.domain.enums.CategoryType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

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
        assertEquals(category.getId(), 1L);

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

        assertEquals(category.getType(), CategoryType.FIJO);
    }

    @Test
    void getBudget() {
        Category category = getInstance();
        category.setBudget(new BigDecimal(new Random().nextLong()));
    }

    @Test
    void getCreateTime() {
        Category category = getInstance();
        LocalDate createTime = LocalDate.now();
        category.setCreateTime(createTime);
        assertEquals(category.getCreateTime(), createTime);
    }

    @Test
    void getUpdateTime() {
        Category category = getInstance();
        LocalDate updateTime = LocalDate.now();
        category.setUpdateTime(updateTime);
        assertEquals(category.getUpdateTime(), updateTime);
    }


}