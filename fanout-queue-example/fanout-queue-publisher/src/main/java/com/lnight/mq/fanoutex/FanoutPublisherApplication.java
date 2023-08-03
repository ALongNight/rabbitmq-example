package com.lnight.mq.fanoutex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FanoutPublisherApplication {

    public static void main(String[] args) {
        SpringApplication.run(FanoutPublisherApplication.class, args);
    }
}
