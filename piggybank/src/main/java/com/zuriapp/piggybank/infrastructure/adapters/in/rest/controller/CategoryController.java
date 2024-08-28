package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller;


import com.zuriapp.piggybank.application.exceptions.DomainException;
import com.zuriapp.piggybank.application.port.in.category.CreateCategoryUseCase;
import com.zuriapp.piggybank.application.port.in.category.FindCategoryUseCase;
import com.zuriapp.piggybank.domain.dto.BaseDataResponse;
import com.zuriapp.piggybank.domain.dto.BaseResponseDTO;
import com.zuriapp.piggybank.domain.dto.PageResponseDTO;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports.CategoryAPI;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.CategoryRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.CategoryResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers.CategoryRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/categories")
@CrossOrigin(origins = "http://localhost:8100")
public class CategoryController implements CategoryAPI {
    private final CreateCategoryUseCase createCategoryUseCase;
    private final FindCategoryUseCase findByCategoryUseCase;
    private final CategoryRestMapper mapper;

    @Override
    public ResponseEntity<BaseResponseDTO> createCategory(CategoryRequest request) throws DomainException {
        createCategoryUseCase.createCategory(mapper.toDomain(request));
        return new ResponseEntity<>(BaseResponseDTO.getInstance(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseDataResponse<List<CategoryResponse>>> findList() throws DomainException {
        List<CategoryResponse> responses = findByCategoryUseCase.findAllCategories().stream().map(mapper::toResponse).toList();
        BaseDataResponse<List<CategoryResponse>> response = new BaseDataResponse<>();
        response.setData(responses);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PageResponseDTO<CategoryResponse>> findPage(Pageable pageable) throws DomainException {
        PageResponseDTO<CategoryResponse> response = new PageResponseDTO<>();
        Page<CategoryResponse> page = findByCategoryUseCase.findAllCategories(pageable).map(mapper::toResponse);
        response.setData(page);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseDataResponse<CategoryResponse>> findById(Long categoryId) throws DomainException {
        CategoryResponse categoryResponse = mapper.toResponse(findByCategoryUseCase.findCategoryById(categoryId));
        BaseDataResponse<CategoryResponse> response = new BaseDataResponse<>();
        response.setData(categoryResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
