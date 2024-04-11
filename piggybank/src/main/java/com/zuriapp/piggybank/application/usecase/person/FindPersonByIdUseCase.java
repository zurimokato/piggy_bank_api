package com.zuriapp.piggybank.application.usecase.person;

import com.zuriapp.piggybank.application.port.IRequestHandler;
import com.zuriapp.piggybank.application.port.out.PersonOutPutPort;
import com.zuriapp.piggybank.domain.Person;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.PersonResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers.PersonRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindPersonByIdUseCase implements IRequestHandler<Long, PersonResponse> {
    private final PersonOutPutPort outPutPort;
    private final PersonRestMapper mapper;
    @Override
    public PersonResponse handle(Long request) throws Exception {

        Person person=outPutPort.findById(request);

        return mapper.toResponse(person);
    }
}
