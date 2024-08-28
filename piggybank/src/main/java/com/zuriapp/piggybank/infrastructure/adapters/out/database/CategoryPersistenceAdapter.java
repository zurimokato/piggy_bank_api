package com.zuriapp.piggybank.infrastructure.adapters.out.database;

import com.zuriapp.piggybank.application.exceptions.InfrastructureException;
import com.zuriapp.piggybank.application.port.out.CategoryOutPutPort;
import com.zuriapp.piggybank.domain.models.Category;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.CategoryEntity;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper.CategoryEntityMapper;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryOutPutPort {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;
    @Value("${response.notfound.message}")
    private String notFoundMessage;
    @Override
    public Category save(Category category) throws InfrastructureException {
        try{
            return categoryEntityMapper.toDomain(categoryRepository.save(categoryEntityMapper.toEntity(category)));
        }catch (Exception e){
            throw new InfrastructureException(e);
        }

    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).map(categoryEntityMapper::toDomain).orElseThrow(()->new EntityNotFoundException(notFoundMessage));
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        Page<CategoryEntity>categoryEntityPage=categoryRepository.findAll(pageable);
        if(categoryEntityPage.isEmpty()){
            throw new EntityNotFoundException(notFoundMessage);
        }
        return categoryEntityPage.map(categoryEntityMapper::toDomain);
    }

    @Override
    public List<Category> findAll() {

        List<CategoryEntity>categoryEntities=categoryRepository.findAll();
        if(categoryEntities.isEmpty()){
            throw new EntityNotFoundException(notFoundMessage);
        }
        return categoryEntities.stream().map(categoryEntityMapper::toDomain).toList();
    }
}
