package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller;

import com.zuriapp.piggybank.application.usecase.count.CreateCountUseCase;
import com.zuriapp.piggybank.application.usecase.count.FinCountByPersonUseCase;
import com.zuriapp.piggybank.application.usecase.count.FindCountByIdUseCase;
import com.zuriapp.piggybank.domain.dto.BaseDataResponse;
import com.zuriapp.piggybank.domain.dto.BaseResponseDTO;
import com.zuriapp.piggybank.domain.dto.PageResponseDTO;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports.CountAPI;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.CountRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.QueryCountRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.CountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/counts")
@CrossOrigin(origins = "http://localhost:8100")
public class CountController implements CountAPI {
    private final CreateCountUseCase createCountUseCase;
    private final FindCountByIdUseCase findCountByIdUseCase;
    private final FinCountByPersonUseCase finCountByPersonUseCase;
    @Override
    public ResponseEntity<BaseResponseDTO> createCount(CountRequest request) throws Exception {
        return new ResponseEntity<>(createCountUseCase.handle(request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseDataResponse<CountResponse>> getCountById(Long countId) throws Exception {
        BaseDataResponse<CountResponse> response= new BaseDataResponse<>();
        response.setData(findCountByIdUseCase.handle(countId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PageResponseDTO<CountResponse>> getCountByPerson(Long idPerson, Pageable pageable) throws Exception {
        PageResponseDTO<CountResponse> response= new PageResponseDTO<>();
        QueryCountRequest request=QueryCountRequest.builder().personId(idPerson).pageable(pageable).build();
        Page<CountResponse>page=finCountByPersonUseCase.handle(request);
        response.setData(page);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
