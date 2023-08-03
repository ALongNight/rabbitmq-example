package com.lnight.mq.simpleq;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@SpringBootTest
public class PublisherTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendMsg2ObjectQueue(){
        String queue = "object.queue";
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("name", "柳岩");
        objectMap.put("age", 18);
        rabbitTemplate.convertAndSend(queue, objectMap);
        log.info("消息发送成功！");
    }
}
