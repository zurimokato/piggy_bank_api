package com.zuriapp.piggybank.infrastructure.adapters.out.database;

import com.zuriapp.piggybank.domain.enums.CountType;
import com.zuriapp.piggybank.domain.enums.Currency;
import com.zuriapp.piggybank.domain.models.Count;
import com.zuriapp.piggybank.domain.models.Person;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.CountEntity;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.PersonEntity;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper.CountEntityMapper;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.repository.CountCrudRepository;
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
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CountPersistenceAdapterTest {

    @Mock
    private CountCrudRepository countCrudRepository;
    @Mock
    private CountEntityMapper countEntityMapper;
    @InjectMocks
    private CountPersistenceAdapter countPersistenceAdapter;

    @Test
    void save() throws Exception {
        Mockito.when(countCrudRepository.save(Mockito.any(CountEntity.class))).thenReturn(getEntityToSaved());
        Mockito.when(countEntityMapper.toEntity(Mockito.any(Count.class))).thenReturn(getEntityToSave());
        Mockito.when(countEntityMapper.toDomain(Mockito.any(CountEntity.class))).thenReturn(getCountSaved());
        var result = countPersistenceAdapter.save(Count.builder().build());
        assertNotNull(result);
    }

    @Test
    void getCountById() {
        Mockito.when(countEntityMapper.toDomain(Mockito.any(CountEntity.class))).thenReturn(Count.builder().build());
        Mockito.when(countCrudRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(getEntityToSaved()));
        var result = countPersistenceAdapter.getCountById(1L);
        assertNotNull(result);
    }

    @Test
    void getAllCountsByPerson() {
        Mockito.when(countEntityMapper.toDomain(Mockito.any(CountEntity.class))).thenReturn(Count.builder().build());
        Mockito.when(countCrudRepository.findAllByPersonId(Mockito.anyLong(), Mockito.any(Pageable.class))).thenReturn(getCountEntitiesPage());
        var result = countPersistenceAdapter.getAllCountsByPerson(1L, Pageable.unpaged());
        assertNotNull(result);
    }

    private Count getCountToSave() {
        return Count.builder()
                .name("test")
                .type(CountType.BANCO)
                .currency(Currency.COP)
                .amount(new BigDecimal(1))
                .person(Person.builder().id(1L)
                        .firstName("John").build())
                .build();
    }

    private Count getCountSaved() {
        Count c = getCountToSave();
        c.setId(new Random().nextLong());
        return c;
    }

    private CountEntity getEntityToSave() {
        PersonEntity person = new PersonEntity();
        person.setFirstName("John");
        person.setId(1L);
        CountEntity countEntity = new CountEntity();
        countEntity.setAmount(new BigDecimal(1));
        countEntity.setCurrency(Currency.COP);
        countEntity.setType(CountType.BANCO);
        countEntity.setPerson(person);
        return countEntity;
    }

    private CountEntity getEntityToSaved() {
        CountEntity countEntity = getEntityToSave();
        countEntity.setId(new Random().nextLong());
        return countEntity;
    }

    private List<CountEntity> getCountEntities() {
        return List.of(getEntityToSaved(), getEntityToSave(), getEntityToSave());
    }

    private Page<CountEntity> getCountEntitiesPage() {
        return new PageImpl<>(getCountEntities());
    }
}