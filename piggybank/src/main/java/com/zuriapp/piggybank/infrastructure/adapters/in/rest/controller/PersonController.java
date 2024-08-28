package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller;


import com.zuriapp.piggybank.application.exceptions.DomainException;
import com.zuriapp.piggybank.application.port.in.person.FindPersonUseCase;
import com.zuriapp.piggybank.domain.dto.BaseDataResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports.PersonAPI;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.PersonResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers.PersonRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Valid
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/person")
@CrossOrigin(origins = "http://localhost:8100")
public class PersonController implements PersonAPI {
    private final FindPersonUseCase findPersonByIdUseCase;
    private final PersonRestMapper mapper;

    @Override
    public ResponseEntity<BaseDataResponse<PersonResponse>> getUser(Long id) throws DomainException {
        BaseDataResponse<PersonResponse> response = new BaseDataResponse<>();
        response.setData(mapper.toResponse(findPersonByIdUseCase.findPersonById(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
