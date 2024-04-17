package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.ports;

import com.zuriapp.piggybank.domain.dto.BaseDataResponse;
import com.zuriapp.piggybank.domain.dto.BaseResponseDTO;
import com.zuriapp.piggybank.domain.dto.PageResponseDTO;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.CategoryRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.CategoryResponse;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



import java.util.List;

public interface CategoryAPI {
    @PostMapping()
    ResponseEntity<BaseResponseDTO>createCategory(@Valid @RequestBody CategoryRequest request) throws Exception;
    @GetMapping("/list")
    ResponseEntity<BaseDataResponse<List<CategoryResponse>>> findList() throws Exception;
    @GetMapping("/page")
    ResponseEntity<PageResponseDTO<CategoryResponse>> findPage(Pageable pageable) throws Exception;
    @GetMapping()
    ResponseEntity<BaseDataResponse<CategoryResponse>> findById(@PathParam("categoryId") Long categoryId) throws Exception;

}
