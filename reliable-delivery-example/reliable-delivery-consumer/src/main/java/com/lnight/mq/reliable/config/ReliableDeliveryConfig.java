package com.lnight.mq.reliable.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReliableDeliveryConfig {


    @Bean
    public DirectExchange reliableExchange(){
        return new DirectExchange("lnight.reliable", true, false);
    }

    @Bean
    public Queue reliableQueue(){
        return new Queue("reliable.queue", true);
    }

    @Bean
    public Binding binding(Queue reliableQueue, DirectExchange reliableExchange){
        return BindingBuilder.bind(reliableQueue).to(reliableExchange).with("reliable");
    }
}
