package com.lnight.mq.topicex;

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
    public void sendMsg2TopicExchange()  {
        String exchange = "lnight.topic";
        String weather = "今天天气真不错，心情美美哒！";
        String news = "传智教育在深圳上市了！";
        rabbitTemplate.convertAndSend(exchange, "china.weather", weather);
        rabbitTemplate.convertAndSend(exchange, "china.news", news);
    }
}
