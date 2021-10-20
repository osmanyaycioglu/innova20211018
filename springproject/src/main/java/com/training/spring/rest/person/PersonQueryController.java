package com.training.spring.rest.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.rest.Person;
import com.training.spring.rest.person.service.PersonQueryService;

@RestController
@RequestMapping("/api/v1/person/query")
public class PersonQueryController {

    @Autowired
    private PersonQueryService pqs;

    @GetMapping("/get/one")
    public Person getOne(@RequestParam("name") final String name,
                         @RequestParam("surname") final String surname) {
        return this.pqs.get(name,
                            surname);
    }

    @GetMapping("/get/all")
    public List<Person> getAll() {
        return this.pqs.getAll();
    }

    @GetMapping("/get/by/name/{name}")
    public List<Person> getByName(@PathVariable("name") final String name) {
        return this.pqs.getByName(name);
    }


}
