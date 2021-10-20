package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@Controller
//@Repository
//@Service
//@Configuration
public class SpringprojectApplication {

    private final MyHello myHello1;

    private final MyHello myHello2;

    private final MyHello myHello3;

    private MyHello       myHello4;

    @Autowired
    @Qualifier("dynamic")
    private MyHelloEx     myHelloEx;

    public SpringprojectApplication(final MyHello myHello1Param,
                                    final MyHello myHello2Param,
                                    final MyHello myHello3Param) {
        super();
        this.myHello1 = myHello1Param;
        this.myHello2 = myHello2Param;
        this.myHello3 = myHello3Param;
        this.sayHello1("ali");
        this.sayHello2("ali");
        this.sayHello3("ali");
    }

    @Autowired
    public void injectHello(final MyHello myHello4) {
        this.myHello4 = myHello4;
    }

    //    @PostConstruct
    //    public void init() {
    //        this.sayHello1("ali");
    //        this.sayHello2("ali");
    //        this.sayHello3("ali");
    //    }

    //    @PreDestroy
    //    public void destroy() {
    //
    //    }

    public void sayHello1(final String name) {
        System.out.println(this.myHello1.hello(name));
    }

    public void sayHello2(final String name) {
        System.out.println(this.myHello2.hello(name));
    }

    public void sayHello3(final String name) {
        System.out.println(this.myHello3.hello(name));
    }

    public static void main(final String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringprojectApplication.class,
                                                                       args);

        MyHello helloLoc = new MyHello();
        String str = helloLoc.hello("osman");
        System.out.println(str);

        SpringprojectApplication beanLoc = context.getBean(SpringprojectApplication.class);
        beanLoc.sayHello1("ali");
        beanLoc.sayHello2("ali");
        beanLoc.sayHello3("ali");
        String hello2Loc = beanLoc.myHelloEx.hello("ali");
        System.out.println(hello2Loc);

    }

}
