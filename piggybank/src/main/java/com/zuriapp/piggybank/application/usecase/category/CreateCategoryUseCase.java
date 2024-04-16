package com.zuriapp.piggybank.application.usecase.category;

import com.zuriapp.piggybank.application.port.IRequestHandler;
import com.zuriapp.piggybank.application.port.out.CategoryOutPutPort;
import com.zuriapp.piggybank.domain.dto.BaseResponseDTO;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.CategoryRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers.CategoryRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CreateCategoryUseCase implements IRequestHandler<CategoryRequest, BaseResponseDTO> {
    private final CategoryOutPutPort category;
    private final CategoryRestMapper mapper;
    @Override
    public BaseResponseDTO handle(CategoryRequest request) throws Exception {
         category.save(mapper.toDomain(request));
         return new BaseResponseDTO();
    }
}
