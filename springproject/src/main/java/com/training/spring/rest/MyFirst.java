package com.training.spring.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class MyFirst {

    @Value("${server.port}")
    private int port;

    @GetMapping("/hello")
    //@RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/hello2/{abc}")
    public String xyz(@PathVariable("abc") final String name) {
        return "Hello " + name + " from : " + this.port;
    }

    @GetMapping("/hello20/{abc}/dfg/{jkl}")
    public String xyz(@PathVariable("abc") final String name,
                      @PathVariable("jkl") final String surname) {
        return "Hello " + name + " " + surname;
    }

    @GetMapping("/hello3")
    public String hello3(@RequestParam("abc") final String name,
                         @RequestParam("jkl") final String surname) {
        return "Hello " + name + " " + surname;
    }

    @GetMapping("/hello4/{abc}")
    public String hello4(@PathVariable("abc") final String name,
                         @RequestParam("jkl") final String surname) {
        return "Hello " + name + " " + surname;
    }

    @PostMapping("/hello5")
    public String hello5(@RequestBody final Person personParam) {
        return "Hello 5 : "
               + personParam.getName()
               + " "
               + personParam.getSurname()
               + " h:"
               + personParam.getHeight()
               + " w:"
               + personParam.getWeight();
    }

    @GetMapping("/hello6")
    public String hello6(@RequestHeader("abc") final String name,
                         @RequestHeader("jkl") final String surname) {
        return "Hello 6 " + name + " " + surname;
    }

    @PostMapping("/hello9")
    public Person hello9(@Validated @RequestBody final Person personParam) {
        personParam.setName("test");
        return personParam;
    }

    @PostMapping(value = "/hello10",
                 consumes = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 },
                 produces = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 })
    public Person hello10(@RequestBody final Person personParam) {
        personParam.setName("test");
        return personParam;
    }


    @GetMapping("/hello100/{komut}")
    public ResponseEntity<?> process(@PathVariable("komut") final String command,
                                     final HttpServletRequest hr) {
        switch (command) {
            case "print":
                String parameterLoc = hr.getParameter("xyz");
                System.out.println(parameterLoc);

                return ResponseEntity.status(HttpStatus.OK)
                                     .header("xyz",
                                             "shsh")
                                     .body("test");
            case "add":
                String p1 = hr.getParameter("name");
                String p2 = hr.getParameter("surname");
                return ResponseEntity.status(HttpStatus.OK)
                                     .header("xyz",
                                             "shsh")
                                     .header("Content-Type",
                                             "application/json")
                                     .body(new Person());

            default:
                break;
        }
        return ResponseEntity.ok("FAILED");
    }


    @GetMapping("/hello7/add")
    public ResponseEntity<Person> hello7(@RequestParam("name") final String name,
                                         @RequestParam("surname") final String surname) {
        return ResponseEntity.ok(new Person().setName(name)
                                             .setSurname(surname)
                                             .setWeight(95)
                                             .setHeight(200));
    }


}
