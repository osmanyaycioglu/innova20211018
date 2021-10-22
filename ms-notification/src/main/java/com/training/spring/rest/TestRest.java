package com.training.spring.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RefreshScope
public class TestRest {

    @Value("${deneme.str}")
    private String str;

    @GetMapping("/prop")
    public String prop() {
        return this.str;
    }

}
