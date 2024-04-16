package com.zuriapp.piggybank.application.usecase.category;

import com.zuriapp.piggybank.application.port.IRequestHandler;
import com.zuriapp.piggybank.application.port.out.CategoryOutPutPort;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.CategoryResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers.CategoryRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindListCategoryUseCase implements IRequestHandler<String, List<CategoryResponse>> {
    private final CategoryRestMapper mapper;
    private final CategoryOutPutPort port;
    @Override
    public List<CategoryResponse> handle(String request) throws Exception {
        return port.findAll().stream().map(mapper::toResponse).toList();
    }
}
