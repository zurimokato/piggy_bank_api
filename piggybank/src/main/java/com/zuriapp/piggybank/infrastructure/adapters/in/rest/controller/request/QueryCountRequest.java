package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
@Builder
public class QueryCountRequest {
    private Long personId;
    private Pageable pageable;
}
