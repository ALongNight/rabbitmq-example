package com.lnight.mq.deadletter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeadLetterConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeadLetterConsumerApplication.class, args);
    }
}
