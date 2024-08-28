package com.zuriapp.piggybank.domain.service;

import com.zuriapp.piggybank.application.exceptions.DomainException;
import com.zuriapp.piggybank.application.port.out.CategoryOutPutPort;
import com.zuriapp.piggybank.domain.enums.CategoryType;
import com.zuriapp.piggybank.domain.models.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {
    @Mock
    private CategoryOutPutPort outPutPort;


    @InjectMocks
    private CategoryService categoryService;


    @Test
    void save() throws Exception {
        final Category category = getCategory();
        Mockito.when(outPutPort.save(Mockito.any(Category.class)))
                .thenReturn(getCategoryCreated());

        var result = categoryService.createCategory(category);
        assertNotNull(result);

        Mockito.verify(this.outPutPort, Mockito.times(1))
                .save(Mockito.any(Category.class));
    }

    @Test
    void save_shouldThrowException() throws Exception {
        final Category category = getCategory();
        Mockito.when(outPutPort.save(Mockito.any(Category.class))).thenThrow(new DomainException("No se pudo crear el  objeto"));
        var result = assertThrows(DomainException.class,()->categoryService.createCategory(category));
        assertTrue(result.getMessage().contains("No se pudo crear el  objeto"));
    }

    private static Category getCategory() {
        return Category.builder()
                .name("test")
                .type(CategoryType.FIJO)
                .createTime(LocalDate.now())
                .build();
    }

    private static Category getCategoryCreated() {
        Random random = new Random();
        return Category.builder().id(random.nextLong())
                .name("test")
                .type(CategoryType.FIJO)
                .createTime(LocalDate.now())
                .build();
    }

    @Test
    void findById() {

        Mockito.when(this.outPutPort.findById(Mockito.any(Long.class)))
                .thenReturn(getCategoryCreated());
        Category category = categoryService.findCategoryById(new Random().nextLong());

        assertNotNull(category);

    }

    @Test
    void update() throws Exception {
        Mockito.when(this.outPutPort.findById(Mockito.any(Long.class)))
                .thenReturn(getCategoryCreated());
        Mockito.when(this.outPutPort.save(Mockito.any(Category.class))).thenReturn(getCategoryCreated());
        Long id = new Random().nextLong();
        Category category = categoryService.findCategoryById(id);
        category.setName("test");
        Category updated = categoryService.createCategory(category);

        assertNotNull(updated);
        assertEquals("test", updated.getName());

        Mockito.verify(this.outPutPort, Mockito.times(1)).findById(id);

    }

    @Test
    void findAll() {
        Category category1=getCategoryCreated();
        Category category2=getCategoryCreated();
        List<Category> expectedCategories = Arrays.asList(category1, category2);

        Mockito.when(this.outPutPort.findAll())
                .thenReturn(expectedCategories);
        List<Category> actualCategories = categoryService.findAllCategories();

        assertNotNull(actualCategories);
        assertEquals(expectedCategories, actualCategories);
        assertEquals(expectedCategories.size(), actualCategories.size());
        assertTrue(actualCategories.contains(category1));


    }
}