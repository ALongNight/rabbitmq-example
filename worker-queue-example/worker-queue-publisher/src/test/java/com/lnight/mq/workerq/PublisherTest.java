package com.lnight.mq.workerq;

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
    public void sendMsg2WorkerQueue(){
        String queue = "worker.queue";
        String msg = "Hello, message ----- ";
        for (int i = 0; i < 50; i++) {
            rabbitTemplate.convertAndSend(queue, msg + i);
        }
    }
}
