package com.zuriapp.piggybank.domain.models;

import com.zuriapp.piggybank.domain.enums.CategoryType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Builder
public class Category {
    private Long id;
    private String name;
    private CategoryType type;
    private BigDecimal budget;
    private LocalDate createTime;
    private LocalDate updateTime;
}
