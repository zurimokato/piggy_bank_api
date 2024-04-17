package com.zuriapp.piggybank.application.usecase.count;

import com.zuriapp.piggybank.application.port.IRequestHandler;
import com.zuriapp.piggybank.application.port.out.CountOutPort;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.QueryCountRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.CountResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers.CountRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FinCountByPersonUseCase implements IRequestHandler<QueryCountRequest, Page<CountResponse>> {
    private final CountRestMapper mapper;
    private final CountOutPort port;
    @Override
    public Page<CountResponse> handle(QueryCountRequest request) throws Exception {
        return port.getAllCountsByPerson(request.getPersonId(), request.getPageable()).map(mapper::toResponse);
    }
}
