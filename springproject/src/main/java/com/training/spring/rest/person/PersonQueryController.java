package com.training.spring.rest.person;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.rest.Person;

@RestController
@RequestMapping("/api/v1/person/query")
public class PersonQueryController {

    @GetMapping("/get/one/{pid}")
    public Person getOne(@PathVariable("pid") final Long personId) {
        return new Person();
    }

    @GetMapping("/get/all")
    public List<Person> getAll() {
        return null;
    }

    @GetMapping("/get/by/name/{name}")
    public List<Person> getByName(@PathVariable("name") final String name) {
        return null;
    }


}
