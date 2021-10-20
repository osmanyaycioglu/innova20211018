package com.training.spring.rest.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.rest.Person;
import com.training.spring.rest.person.data.PersonStorage;

@Service
public class PersonQueryService {

    @Autowired
    private PersonStorage pst;

    public Person get(final String name,
                      final String surname) {
        return this.pst.get(name + surname);
    }

    public List<Person> getAll() {
        return this.pst.getAll();
    }

    public List<Person> getByName(final String nameParam) {
        return this.pst.getByName(nameParam);
    }


}
