package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller;

import com.zuriapp.piggybank.application.usecase.category.CreateCategoryUseCase;
import com.zuriapp.piggybank.application.usecase.category.FindAllCategoryUseCase;
import com.zuriapp.piggybank.application.usecase.category.FindByCategoryUseCase;
import com.zuriapp.piggybank.application.usecase.category.FindListCategoryUseCase;
import com.zuriapp.piggybank.domain.dto.BaseDataResponse;
import com.zuriapp.piggybank.domain.dto.BaseResponseDTO;
import com.zuriapp.piggybank.domain.dto.PageResponseDTO;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports.CategoryAPI;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.CategoryRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/categories")
public class CategoryController implements CategoryAPI {
    private final CreateCategoryUseCase createCategoryUseCase;
    private final FindByCategoryUseCase findByCategoryUseCase;
    private final FindAllCategoryUseCase findAllCategoryUseCase;
    private final FindListCategoryUseCase findListCategoryUseCase;

    @Override
    public ResponseEntity<BaseResponseDTO> createCategory(CategoryRequest request) throws Exception {
        return new ResponseEntity<>(createCategoryUseCase.handle(request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseDataResponse<List<CategoryResponse>>> findList() throws Exception {
        List<CategoryResponse> responses = findListCategoryUseCase.handle("");
        BaseDataResponse<List<CategoryResponse>> response = new BaseDataResponse<>();
        response.setData(responses);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PageResponseDTO<CategoryResponse>> findPage(Pageable pageable) throws Exception {
        PageResponseDTO<CategoryResponse> response = new PageResponseDTO<>();
        Page<CategoryResponse> page = findAllCategoryUseCase.handle(pageable);
        response.setData(page);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseDataResponse<CategoryResponse>> findById(Long categoryId) throws Exception {
        CategoryResponse categoryResponse = findByCategoryUseCase.handle(categoryId);
        BaseDataResponse<CategoryResponse> response = new BaseDataResponse<>();
        response.setData(categoryResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
