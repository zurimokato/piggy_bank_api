package com.zuriapp.piggybank.application.usecase.count;

import com.zuriapp.piggybank.application.port.IRequestHandler;
import com.zuriapp.piggybank.application.port.out.CountOutPort;
import com.zuriapp.piggybank.domain.Count;
import com.zuriapp.piggybank.domain.dto.BaseResponseDTO;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.CountRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers.CountRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCountUseCase implements IRequestHandler<CountRequest, BaseResponseDTO> {
    private final CountOutPort port;
    private final CountRestMapper countRestMapper;
    @Override
    public BaseResponseDTO handle(CountRequest request) throws Exception {
        Count count=countRestMapper.toDomain(request);
        count=port.save(count);
        return new BaseResponseDTO();
    }
}
