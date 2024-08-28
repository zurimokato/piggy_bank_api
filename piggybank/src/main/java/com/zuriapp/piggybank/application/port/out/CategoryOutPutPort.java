package com.zuriapp.piggybank.application.port.out;

import com.zuriapp.piggybank.application.exceptions.InfrastructureException;
import com.zuriapp.piggybank.domain.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryOutPutPort {
    Category save(Category category) throws InfrastructureException;
    Category findById(Long id);
    Page<Category> findAll(Pageable pageable);
    List<Category> findAll();
}
