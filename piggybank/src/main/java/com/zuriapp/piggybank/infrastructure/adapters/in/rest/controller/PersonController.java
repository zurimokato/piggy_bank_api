package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller;


import com.zuriapp.piggybank.application.usecase.person.FindPersonByIdUseCase;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports.PersonAPI;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.QueryPersonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Valid
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/person")
public class PersonController implements PersonAPI {
    private final FindPersonByIdUseCase findPersonByIdUseCase;
    @Override
    public ResponseEntity<QueryPersonResponse> getUser(Long id) throws Exception {
        QueryPersonResponse response=new QueryPersonResponse();
        response.setPerson(findPersonByIdUseCase.handle(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
