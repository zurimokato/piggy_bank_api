package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request;

import lombok.Data;
import org.springframework.data.domain.Pageable;

@Data
public class QueryTransactionRequest {
    private Long countId;
    private Pageable pageable;
}
