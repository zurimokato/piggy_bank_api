package com.zuriapp.piggybank.infrastructure.adapters.out.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonRepository<T,S> extends JpaRepository<T,S> {
}
