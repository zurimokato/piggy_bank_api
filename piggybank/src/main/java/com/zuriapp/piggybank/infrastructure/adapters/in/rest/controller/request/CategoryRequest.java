package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request;


import com.zuriapp.piggybank.domain.enums.CategoryType;
import com.zuriapp.piggybank.domain.enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;


@Getter
@Setter
@Builder
public class CategoryRequest {

    private Long id;
    private String name;
    private CategoryType type;
    private LocalDate createTime;
    private LocalDate updateTime;
    private Status status;
    private CategoryRequest category;

}
