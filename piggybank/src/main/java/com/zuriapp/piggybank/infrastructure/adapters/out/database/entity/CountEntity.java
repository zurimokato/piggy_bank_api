package com.zuriapp.piggybank.infrastructure.adapters.out.database.entity;

import com.zuriapp.piggybank.domain.enums.CountType;
import com.zuriapp.piggybank.domain.enums.Currency;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "COUNTS")
public class CountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private CountType type;
    private Currency currency;
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name = "personas_id")
    private PersonEntity person;

    @OneToMany
    private List<TransactionEntity> transactions;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
