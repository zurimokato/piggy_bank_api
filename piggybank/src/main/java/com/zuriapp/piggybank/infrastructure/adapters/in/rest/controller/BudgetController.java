package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller;

import com.zuriapp.piggybank.application.port.in.budget.CreateBudgetUseCase;
import com.zuriapp.piggybank.application.port.in.budget.FindBudgetUseCase;
import com.zuriapp.piggybank.domain.dto.BaseDataResponse;
import com.zuriapp.piggybank.domain.dto.BaseResponseDTO;
import com.zuriapp.piggybank.domain.dto.PageResponseDTO;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports.BudgetAPI;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.BudgetRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.BudgetResponse;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers.BudgetRestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/budgets")
@CrossOrigin(origins = "http://localhost:8100")
public class BudgetController implements BudgetAPI {
    private final BudgetRestMapper restMapper;
    private final FindBudgetUseCase findBudgetUseCase;
    private final CreateBudgetUseCase createBudgetUseCase;
    @Override
    public ResponseEntity<BaseDataResponse<BudgetResponse>> getBudget(Long id) {
        BaseDataResponse<BudgetResponse> response =new BaseDataResponse<>();
        BudgetResponse budgetResponse=restMapper.toResponse(findBudgetUseCase.findBudgetById(id));
        response.setData(budgetResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PageResponseDTO<BudgetResponse>> getBudgets(Long id, Pageable pageable) {
        PageResponseDTO<BudgetResponse> response =new PageResponseDTO<>();
        Page<BudgetResponse>pages=findBudgetUseCase.findBudgetByPerson(id,pageable).map(restMapper::toResponse);
        response.setData(pages);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponseDTO> createBudget(BudgetRequest budgetRequest) {
        BudgetResponse budgetResponse=restMapper.toResponse(
                createBudgetUseCase.create(restMapper.toModel(budgetRequest)));
        log.info(budgetResponse.toString());
        return new ResponseEntity<>(BaseResponseDTO.getInstance(), HttpStatus.OK);
    }
}
