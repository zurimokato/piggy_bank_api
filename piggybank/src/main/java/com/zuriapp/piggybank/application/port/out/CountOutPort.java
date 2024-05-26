package com.zuriapp.piggybank.application.port.out;

import com.zuriapp.piggybank.domain.models.Count;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CountOutPort {

    Count save(Count count) throws Exception;
    Count getCountById(Long id)  throws Exception;
    Page<Count> getAllCountsByPerson(Long userId,Pageable pageable) throws Exception;
}
