package com.zuriapp.piggybank.infrastructure.adapters.out.database;

import com.zuriapp.piggybank.application.port.out.CountOutPort;
import com.zuriapp.piggybank.domain.Count;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper.CountEntityMapper;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.repository.CountCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CountPersistenceAdapter implements CountOutPort {
    private final CountCrudRepository crudRepository;
    private final CountEntityMapper mapper;
    @Override
    public Count save(Count count) {
        return mapper.toDomain( crudRepository.save(mapper.toEntity(count)));
    }

    @Override
    public Count getCountById(Long id) {
        return  mapper.toDomain( crudRepository.findById(id).orElse(null));
    }

    @Override
    public Page<Count> getAllCounts(Pageable pageable) {
        return crudRepository.findAll(pageable).map(mapper::toDomain);
    }
}
