package com.lnight.mq.queue.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueCreateConfig {

    @Bean
    public Queue simpleQueue(){
        return new Queue("simple.queue");
    }


    @Bean
    public Queue workerQueue(){
        return new Queue("worker.queue");
    }
}
