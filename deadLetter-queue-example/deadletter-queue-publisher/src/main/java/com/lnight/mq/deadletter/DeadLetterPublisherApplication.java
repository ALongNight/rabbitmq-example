package com.lnight.mq.deadletter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeadLetterPublisherApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeadLetterPublisherApplication.class, args);
    }
}
