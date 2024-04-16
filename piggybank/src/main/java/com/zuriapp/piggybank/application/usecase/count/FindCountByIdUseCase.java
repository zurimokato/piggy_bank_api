package com.zuriapp.piggybank.application.usecase.count;

import com.zuriapp.piggybank.application.port.IRequestHandler;
import com.zuriapp.piggybank.application.port.out.CountOutPort;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.CountResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers.CountRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindCountByIdUseCase implements IRequestHandler<Long, CountResponse> {
    private final CountRestMapper mapper;
    private final CountOutPort port;

    @Override
    public CountResponse handle(Long request) throws Exception {
        return mapper.toResponse(port.getCountById(request));
    }
}
