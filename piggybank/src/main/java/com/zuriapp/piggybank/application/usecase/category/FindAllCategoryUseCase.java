package com.zuriapp.piggybank.application.usecase.category;

import com.zuriapp.piggybank.application.port.IRequestHandler;
import com.zuriapp.piggybank.application.port.out.CategoryOutPutPort;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.CategoryResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers.CategoryRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAllCategoryUseCase implements IRequestHandler<Pageable,Page<CategoryResponse>> {
    private final CategoryRestMapper mapper;
    private final CategoryOutPutPort port;
    @Override
    public Page<CategoryResponse> handle(Pageable request) throws Exception {
        return port.findAll(request).map(mapper::toResponse);
    }
}
