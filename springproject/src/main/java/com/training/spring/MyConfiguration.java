package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MyConfiguration {

    @Autowired
    private Environment env;

    @Value("${hello.prefix}")
    private String      prefix;

    @Bean
    public MyHelloEx creatHelloExENG() {
        return new MyHelloEx("hello");
    }

    @Bean
    public MyHelloEx creatHelloExTR() {
        return new MyHelloEx("merhaba");
    }

    @Bean({
            "lang_esp",
            "abc"
    })
    @Qualifier("xyz")
    public MyHelloEx creatHelloESP() {
        return new MyHelloEx("ola");
    }


    @Bean("dynamic")
    public MyHelloEx creatDynamic() {
        // String propertyLoc = this.env.getProperty("hello.prefix");
        return new MyHelloEx(this.prefix);
    }


}
