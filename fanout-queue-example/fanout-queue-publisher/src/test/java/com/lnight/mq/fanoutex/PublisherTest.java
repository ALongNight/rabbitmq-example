package com.lnight.mq.fanoutex;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class PublisherTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendMsg2FanoutExchange(){
        String exchange = "lnight.fanout";
        String msg = "Hello, every one!";
        rabbitTemplate.convertAndSend(exchange, "", msg);
    }
}
