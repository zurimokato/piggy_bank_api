package com.zuriapp.piggybank.infrastructure.adapters.out.database;

import com.zuriapp.piggybank.domain.enums.CategoryType;
import com.zuriapp.piggybank.domain.models.Category;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.CategoryEntity;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper.CategoryEntityMapper;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CategoryPersistenceAdapterTest {

    @Mock
    private CategoryRepository repository;
    @Mock
    private CategoryEntityMapper categoryEntityMapper;
    @InjectMocks
    private CategoryPersistenceAdapter persistenceAdapter;
    @Test
    void save() throws Exception {
        final Category category=getCategoryDomain();
        Mockito.when(categoryEntityMapper.toEntity(Mockito.any(Category.class)))
                .thenReturn(getCategoryEntity());
        Mockito.when(categoryEntityMapper.toDomain(Mockito.any(CategoryEntity.class))).
                thenReturn(getCategoryDomainSaved());
        Mockito.when(repository.save(Mockito.any(CategoryEntity.class)))
                .thenReturn(getCategoryEntitySaved().orElse(null));

        var result=persistenceAdapter.save(category);
        assertNotNull(result);

    }

    @Test
    void findById() {
        Mockito.when(categoryEntityMapper.toDomain(Mockito.any(CategoryEntity.class))).
                thenReturn(getCategoryDomain());
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(getCategoryEntitySaved());
        var result=persistenceAdapter.findById(1L);
        assertNotNull(result);
    }

    @Test
    void findAll() {
        Mockito.when(categoryEntityMapper.toDomain(Mockito.any(CategoryEntity.class))).
                thenReturn(getCategoryDomain());
        Mockito.when(repository.findAll()).thenReturn(categoryEntities());
        var result=persistenceAdapter.findAll();
        assertNotNull(result);

    }

    @Test
    void testFindAll() {
        Mockito.when(categoryEntityMapper.toDomain(Mockito.any(CategoryEntity.class))).
                thenReturn(getCategoryDomain());
        Mockito.when(repository.findAll(Mockito.any(Pageable.class))).thenReturn(categoryEntityPages());
        Pageable pageable=Pageable.ofSize(3);
        var result=persistenceAdapter.findAll(pageable);
        assertNotNull(result);

    }

   private CategoryEntity getCategoryEntity() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName("Test");
        categoryEntity.setType(CategoryType.FIJO);
        return categoryEntity;
    }

    private Optional<CategoryEntity> getCategoryEntitySaved() {
        CategoryEntity categoryEntity = getCategoryEntity();
        categoryEntity.setId(new Random().nextLong());
        return Optional.of(categoryEntity);
    }

    private Category getCategoryDomainSaved() {
        return Category.builder()
                .id(1L).name("Test")
                .type(CategoryType.FIJO)
                .build();
    }

    private Category getCategoryDomain() {
        return Category.builder()
                .name("Test")
                .type(CategoryType.FIJO)
                .build();
    }

    List<CategoryEntity>categoryEntities(){
        return List.of(Objects.requireNonNull(getCategoryEntitySaved().orElse(null)),getCategoryEntitySaved().orElse(null));
    }

    Page<CategoryEntity>categoryEntityPages(){
        return new PageImpl<>(List.of(getCategoryEntity(),getCategoryEntity(),getCategoryEntity()));
    }
}