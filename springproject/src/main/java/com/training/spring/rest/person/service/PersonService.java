package com.training.spring.rest.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.rest.Person;
import com.training.spring.rest.person.data.PersonStorage;

@Service
public class PersonService {

    @Autowired
    private PersonStorage pst;

    public void add(final Person personParam) {
        this.pst.add(personParam);
    }


}
