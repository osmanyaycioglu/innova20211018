package com.training.spring;

import org.springframework.stereotype.Component;

@Component
// @Scope("prototype")
public class MyHello {

    private int counter;

    public String hello(final String name) {
        this.counter++;
        return "Hello " + name + " counter : " + this.counter;
    }

}
