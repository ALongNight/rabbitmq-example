package com.lnight.mq.workerq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueCreateConfig {

    @Bean
    public Queue workerQueue(){
        return new Queue("worker.queue");
    }
}
