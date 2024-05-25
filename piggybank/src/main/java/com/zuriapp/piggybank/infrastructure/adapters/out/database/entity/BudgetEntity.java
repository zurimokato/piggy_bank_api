package com.zuriapp.piggybank.infrastructure.adapters.out.database.entity;

import com.zuriapp.piggybank.domain.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "budgets")
public class BudgetEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal budget;
    private Status status;
    @ManyToOne(fetch = FetchType.EAGER)
    private PersonEntity person;
    @ManyToOne(fetch = FetchType.EAGER)
    private CategoryEntity category;


}
