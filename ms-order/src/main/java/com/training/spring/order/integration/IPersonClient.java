package com.training.spring.order.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.spring.order.error.RestClientException;

@FeignClient(value = "PERSON")
@RequestMapping("/first")
public interface IPersonClient {


    @GetMapping("/hello2/{abc}")
    public String hello2(@PathVariable("abc") final String name) throws RestClientException;

    @GetMapping("/hello20/{abc}/dfg/{jkl}")
    public String hello20(@PathVariable("abc") final String name,
                          @PathVariable("jkl") final String surname) throws RestClientException;

    @GetMapping("/hello3")
    public String hello3(@RequestParam("abc") final String name,
                         @RequestParam("jkl") final String surname) throws RestClientException;

    @GetMapping("/hello4/{abc}")
    public String hello4(@PathVariable("abc") final String name,
                         @RequestParam("jkl") final String surname) throws RestClientException;

    @PostMapping("/hello9")
    public Person hello9(@RequestBody final Person personParam) throws RestClientException;

}
