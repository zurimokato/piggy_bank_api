package com.zuriapp.piggybank.domain.models;

import com.zuriapp.piggybank.domain.enums.CategoryType;
import com.zuriapp.piggybank.domain.enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Builder
public class Category {
    private Long id;
    private String name;
    private CategoryType type;
    private Status status;
    private Category category;
    private Set<Category> categories = new HashSet<>();
    private LocalDate createTime;
    private LocalDate updateTime;
}
