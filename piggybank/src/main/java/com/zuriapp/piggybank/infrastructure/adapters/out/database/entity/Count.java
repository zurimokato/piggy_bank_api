package com.zuriapp.piggybank.infrastructure.adapters.out.database.entity;

import com.zuriapp.piggybank.domain.enums.CountType;
import com.zuriapp.piggybank.domain.enums.Currency;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "counts")
public class Count implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        @Enumerated(EnumType.STRING)
        private CountType type;

        private BigDecimal amount;

        @Enumerated(EnumType.STRING)
        private Currency currency;

        // Relación con la entidad PersonEntity
        @ManyToOne
        @JoinColumn(name = "personas_id")
        private PersonEntity person;
}
