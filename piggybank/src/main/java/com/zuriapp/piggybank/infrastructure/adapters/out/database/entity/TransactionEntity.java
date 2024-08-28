package com.zuriapp.piggybank.infrastructure.adapters.out.database.entity;

import com.zuriapp.piggybank.domain.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class TransactionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;
    @Column(name = "create_time")
    private LocalDateTime createTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "counts_id")
    private CountEntity count;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categories_id")
    private CategoryEntity category;

}
