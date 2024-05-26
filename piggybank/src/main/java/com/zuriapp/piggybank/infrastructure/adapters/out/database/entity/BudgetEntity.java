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
    private String name;
    private Status status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id")
    private UserEntity user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categories_id")
    private CategoryEntity category;


}
