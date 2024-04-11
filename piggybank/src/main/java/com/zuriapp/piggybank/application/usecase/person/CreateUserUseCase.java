package com.zuriapp.piggybank.application.usecase.person;

import com.zuriapp.piggybank.application.port.IRequestHandler;
import com.zuriapp.piggybank.application.port.out.PersonOutPutPort;
import com.zuriapp.piggybank.application.port.out.UserOutPort;
import com.zuriapp.piggybank.domain.Person;
import com.zuriapp.piggybank.domain.User;
import com.zuriapp.piggybank.domain.enums.Status;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.PersonRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.PersonResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers.PersonRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase implements IRequestHandler<PersonRequest, PersonResponse> {
    private final UserOutPort userOutPort;
    private final PersonOutPutPort personPort;
    private final PersonRestMapper personRestMapper;
    @Override
    public PersonResponse handle(PersonRequest request) throws Exception {
        try {
            Person person=personRestMapper.toDomain(request);
            User user = person.getUser();
            user.setCreateTime(LocalDateTime.now());
            final User saved = userOutPort.save(user);
            person.setUser(saved);
            person.setStatus(Status.ACTIVE);
            person.setCreateTime(LocalDateTime.now());
            person=personPort.save(person);
            return personRestMapper.toResponse(person);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
