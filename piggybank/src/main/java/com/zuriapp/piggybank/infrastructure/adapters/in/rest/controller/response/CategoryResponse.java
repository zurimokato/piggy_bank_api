package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response;


import com.zuriapp.piggybank.domain.enums.CategoryType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class CategoryResponse {

    private Long id;
    private String name;
    private CategoryType type;
    private BigDecimal budget;
    private LocalDate createTime;
    private LocalDate updateTime;
}
