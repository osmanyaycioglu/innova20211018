package com.training.spring.rest.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.rest.Person;
import com.training.spring.rest.person.service.PersonService;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonProvisionController {

    @Autowired
    private PersonService ps;

    @PostMapping("/add")
    public String add(@Validated @RequestBody final Person person) {
        this.ps.add(person);
        return "OK";
    }

    @PostMapping("/update")
    public String update(@RequestBody final Person person) {
        return "OK";
    }

    @GetMapping("/deactivate/{pid}")
    public String deactivate(@PathVariable("pid") final Long personId) {
        return "OK";
    }


}
