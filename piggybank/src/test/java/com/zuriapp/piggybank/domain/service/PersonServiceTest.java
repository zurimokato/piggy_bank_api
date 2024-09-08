package com.zuriapp.piggybank.domain.service;

import com.zuriapp.piggybank.application.port.out.PersonOutPutPort;
import com.zuriapp.piggybank.application.port.out.UserOutPort;
import com.zuriapp.piggybank.domain.enums.Status;
import com.zuriapp.piggybank.domain.models.Person;
import com.zuriapp.piggybank.domain.models.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonOutPutPort personOutPutPort;
    @Mock
    private UserOutPort userOutPort;
    @InjectMocks
    private PersonService personService;

    @Test
    void createPerson() throws Exception {
        final Person person = getPersonInstance();
        final Person saved = getPersonInstanceSaved();
        Mockito.when(personOutPutPort.save(Mockito.any(Person.class))).thenReturn(saved);
        var result = personService.createPerson(person);
        assertNotNull(result);
        assertEquals(1L,saved.getId());
    }

    @Test
    void findPersonById() throws Exception {
        final Person saved = getPersonInstanceSaved();
        Mockito.when(personOutPutPort.findById(Mockito.any(Long.class))).thenReturn(saved);
        var result = personService.findPersonById(new Random().nextLong());
        assertNotNull(result);
    }

    private Person getPersonInstance() {
        return Person.builder()
                .nit("1081825493")
                .age(28)
                .phone("3135572399")
                .user(User.builder().id(1L).build())
                .gender('M')
                .firstName("Jhoan")
                .firstLastName("Olivo")
                .createTime(LocalDateTime.now())
                .status(Status.ACTIVE).build();
    }

    private Person getPersonInstanceSaved() {
        return Person.builder()
                .id(1L)
                .nit("1081825493")
                .age(28)
                .phone("3135572399")
                .gender('M')
                .user(User.builder().id(1L).build())
                .firstName("Jhoan")
                .firstLastName("Olivo")
                .createTime(LocalDateTime.now())
                .status(Status.ACTIVE).build();
    }
}