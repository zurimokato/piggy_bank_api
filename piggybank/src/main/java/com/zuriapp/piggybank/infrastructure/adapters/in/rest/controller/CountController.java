package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller;


import com.zuriapp.piggybank.application.exceptions.DomainException;
import com.zuriapp.piggybank.application.port.in.count.CreateCountUseCase;
import com.zuriapp.piggybank.application.port.in.count.FindCountUseCase;
import com.zuriapp.piggybank.domain.dto.BaseDataResponse;
import com.zuriapp.piggybank.domain.dto.BaseResponseDTO;
import com.zuriapp.piggybank.domain.dto.PageResponseDTO;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports.CountAPI;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.CountRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.CountResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers.CountRestMapper;
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
    private final FindCountUseCase findCountUseCase;
    private final CountRestMapper mapper;

    @Override
    public ResponseEntity<BaseResponseDTO> createCount(CountRequest request) throws DomainException {
        createCountUseCase.createCount(mapper.toDomain(request));
        return new ResponseEntity<>(BaseResponseDTO.getInstance(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseDataResponse<CountResponse>> getCountById(Long countId) throws DomainException {
        BaseDataResponse<CountResponse> response = new BaseDataResponse<>();
        response.setData(mapper.toResponse(findCountUseCase.findCountById(countId)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PageResponseDTO<CountResponse>> getCountByPerson(Long userId, Pageable pageable) throws DomainException {
        PageResponseDTO<CountResponse> response = new PageResponseDTO<>();
        Page<CountResponse> page = findCountUseCase.findCountUseCase(userId,pageable).map(mapper::toResponse);
        response.setData(page);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
