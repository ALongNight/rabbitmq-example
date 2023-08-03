package com.lnight.mq.directex;

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
    public void sendMsg2DirectExchange()  {
        String exchange = "lnight.direct";
        String blueMsg = "Hello, blue!";
        String redMsg = "Hello, red!";
        String yellowMsg = "Hello, yellow!";
        rabbitTemplate.convertAndSend(exchange, "blue", blueMsg);
        rabbitTemplate.convertAndSend(exchange, "yellow", yellowMsg);
        rabbitTemplate.convertAndSend(exchange, "red", redMsg);
    }
}
