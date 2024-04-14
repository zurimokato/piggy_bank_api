package com.zuriapp.piggybank.application.port.out;

import com.zuriapp.piggybank.domain.Count;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CountOutPort {

    Count save(Count count);
    Count getCountById(Long id);
    Page<Count> getAllCounts(Pageable pageable);
}
