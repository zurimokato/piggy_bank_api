package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request;


import com.zuriapp.piggybank.domain.enums.CategoryType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@Builder
public class CategoryRequest {

    private Long id;
    private String name;
    private CategoryType type;
    private BigDecimal budget;
    private LocalDate createTime;
    private LocalDate updateTime;
}
