package com.zuriapp.piggybank.domain.service;

import com.zuriapp.piggybank.application.port.out.CountOutPort;
import com.zuriapp.piggybank.domain.enums.CountType;
import com.zuriapp.piggybank.domain.enums.Currency;
import com.zuriapp.piggybank.domain.models.Count;
import com.zuriapp.piggybank.domain.models.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class CountServiceTest {
    @Mock
    private CountOutPort countOutPort;

    @InjectMocks
    private CountService countService;

    @Test
    void createCount() throws Exception {
        final Count count = getCountInstance();
        Mockito.when(countOutPort.save(Mockito.any(Count.class)))
                .thenReturn(getCountInstanceSaved());
        var result = countService.createCount(count);
        assertNotNull(result);
    }

    @Test
    void findCountUseCase() throws Exception {
        List<Count> counts = new ArrayList<>() ;
        counts.add(getCountInstanceSaved());
        Page<Count>page=new PageImpl<>(counts);
        Pageable pageable=Pageable.ofSize(counts.size());
        Mockito.when(countOutPort.getAllCountsByPerson(Mockito.any(Long.class),Mockito.any(Pageable.class)))
                .thenReturn(page);
        var result =countService.findCountUseCase(new Random().nextLong(),pageable);
        assertNotNull(result);
        assertEquals(counts.size(), result.getTotalElements());

    }

    @Test
    void findCountById() throws Exception {
        Mockito.when(countOutPort.getCountById(Mockito.anyLong()))
                .thenReturn(getCountInstanceSaved());

        var result = countService.findCountById(new Random().nextLong());
        assertNotNull(result);
    }

    Count getCountInstance(){
        return Count.builder()
                .type(CountType.BANCO)
                .name("BANCOLOMBIA")
                .amount(new BigDecimal(new Random().nextLong()))
                .currency(Currency.COP)
                .person(Person.builder().id(1L).build())
                .build();
    }

    Count getCountInstanceSaved(){
        return Count.builder()
                .id(new Random().nextLong())
                .type(CountType.BANCO)
                .name("BANCOLOMBIA")
                .amount(new BigDecimal(new Random().nextLong()))
                .currency(Currency.COP)
                .person(Person.builder().id(1L).build())
                .build();
    }
}