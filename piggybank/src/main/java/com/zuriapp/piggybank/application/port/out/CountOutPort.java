package com.zuriapp.piggybank.application.port.out;

import com.zuriapp.piggybank.domain.Count;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CountOutPort {

    Count save(Count count) throws Exception;
    Count getCountById(Long id)  throws Exception;
    Page<Count> getAllCountsByPerson(Long id,Pageable pageable) throws Exception;
}
