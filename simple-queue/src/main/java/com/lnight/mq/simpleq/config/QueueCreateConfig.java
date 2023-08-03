package com.lnight.mq.simpleq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueCreateConfig {

    @Bean
    public Queue simpleQueue(){
        return new Queue("simple.queue");
    }
}
