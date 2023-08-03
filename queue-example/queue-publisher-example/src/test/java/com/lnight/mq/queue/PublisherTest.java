package com.lnight.mq.queue;

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
    public void sendMsg2SimpleQueue(){
        String queue = "simple.queue";
        String msg = "Hello, Spring AMQP!";
        rabbitTemplate.convertAndSend(queue, msg);
        log.info("消息发送成功！");
    }

    @Test
    public void sendMsg2WorkerQueue(){
        String queue = "worker.queue";
        String msg = "Hello, message ----- ";
        for (int i = 0; i < 50; i++) {
            rabbitTemplate.convertAndSend(queue, msg + i);
        }
    }
}
