package com.zuriapp.piggybank.infrastructure.adapters.out.database;

import com.zuriapp.piggybank.application.port.out.CountOutPort;
import com.zuriapp.piggybank.domain.Count;
import com.zuriapp.piggybank.infrastructure.adapters.out.config.MessageConfigAdapter;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.CountEntity;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper.CountEntityMapper;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.repository.CountCrudRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CountPersistenceAdapter implements CountOutPort {
    private final CountCrudRepository crudRepository;
    private final CountEntityMapper mapper;
    private final MessageConfigAdapter messageConfigAdapter;
    @Override
    public Count save(Count count) throws Exception {
        try{
            return mapper.toDomain( crudRepository.save(mapper.toEntity(count)));

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Count getCountById(Long id) {
        return  mapper.toDomain( crudRepository.findById(id).orElseThrow(
                ()->new EntityNotFoundException(messageConfigAdapter.notFoundResponse())
        ));
    }

    @Override
    public Page<Count> getAllCountsByPerson(Long personId,Pageable pageable) {
        Page<CountEntity>pages=crudRepository.findAllByPersonId(personId,pageable);
        if(pages.isEmpty()){
            throw new EntityNotFoundException(messageConfigAdapter.notFoundResponse());
        }
        return pages.map(mapper::toDomain);
    }
}
