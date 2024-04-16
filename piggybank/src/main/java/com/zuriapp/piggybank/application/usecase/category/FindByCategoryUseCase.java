package com.zuriapp.piggybank.application.usecase.category;

import com.zuriapp.piggybank.application.port.IRequestHandler;
import com.zuriapp.piggybank.application.port.out.CategoryOutPutPort;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.CategoryResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers.CategoryRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindByCategoryUseCase implements IRequestHandler<Long, CategoryResponse> {
    private final CategoryRestMapper mapper;
    private final CategoryOutPutPort port;
    @Override
    public CategoryResponse handle(Long request) throws Exception {
        return mapper.toResponse(port.findById(request));
    }
}
