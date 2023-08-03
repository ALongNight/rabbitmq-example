package com.lnight.mq.simpleq.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class ObjectQueueListener {

    @RabbitListener(queues = "object.queue")
    public void listenerObjectQueue(Map<String, Object> objectMap){
        System.out.println("消费者接收到object.queue的消息：【" + objectMap + "】");
    }
}
