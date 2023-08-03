package com.lnight.mq.deadletter.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TTLMessageConfig {

    @Bean
    public DirectExchange ttlDirectExchange(){
        return new DirectExchange("ttl.direct");
    }

    @Bean
    public Queue ttlQueue(){
        return QueueBuilder
                .durable("ttl.queue")
                .ttl(10000) //消息存活时间，单位ms，但当10秒未消费将投递到死信交换机
                .deadLetterExchange("dl.direct")
                .deadLetterRoutingKey("dl")
                .build();
    }

    @Bean
    public Binding ttlBinding(DirectExchange ttlDirectExchange, Queue ttlQueue){
        return BindingBuilder.bind(ttlQueue).to(ttlDirectExchange).with("ttl");
    }
}
