package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports;

import com.zuriapp.piggybank.domain.dto.BaseDataResponse;
import com.zuriapp.piggybank.domain.dto.BaseResponseDTO;
import com.zuriapp.piggybank.domain.dto.PageResponseDTO;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.BudgetRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.BudgetResponse;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface BudgetAPI {
    @GetMapping("/find")
    ResponseEntity<BaseDataResponse<BudgetResponse>> getBudget(@PathParam("id")Long id);
    @GetMapping()
    ResponseEntity<PageResponseDTO<BudgetResponse>> getBudgets(@PathParam("personId")Long id, Pageable pageable);
    @PostMapping()
    ResponseEntity<BaseResponseDTO> createBudget(@Valid @RequestBody BudgetRequest budgetRequest);

}
