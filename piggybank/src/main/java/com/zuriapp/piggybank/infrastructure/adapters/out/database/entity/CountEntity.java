package com.zuriapp.piggybank.infrastructure.adapters.out.database.entity;

import com.zuriapp.piggybank.domain.enums.CountType;
import com.zuriapp.piggybank.domain.enums.Currency;
import com.zuriapp.piggybank.domain.enums.Status;
import com.zuriapp.piggybank.domain.models.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
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
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private UserEntity user;

    @OneToMany(fetch = FetchType.LAZY)
    private List<TransactionEntity> transactions;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
