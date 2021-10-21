package com.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@EnableConfigServer
public class NodeConfigurationApplication {


    @Scheduled(fixedDelay = 10_000)
    public void name() {
        System.out.println("Çalışitım");
    }

    public static void main(final String[] args) {
        SpringApplication.run(NodeConfigurationApplication.class,
                              args);
    }

}
