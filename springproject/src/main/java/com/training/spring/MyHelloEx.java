package com.training.spring;

public class MyHelloEx {

    private final String prefix;
    private int          counter;

    public MyHelloEx(final String prefixParam) {
        super();
        this.prefix = prefixParam;
    }

    public String hello(final String name) {
        this.counter++;
        return this.prefix + " " + name + " counter : " + this.counter;
    }

}
