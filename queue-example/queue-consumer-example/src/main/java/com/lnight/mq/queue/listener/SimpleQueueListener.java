package com.lnight.mq.queue.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SimpleQueueListener {

    @RabbitListener(queues = "simple.queue")
    public void listenerSimpleQueue(String msg){
        System.out.println("消费者接收到simple.queue的消息：【" + msg + "】");
    }
}
