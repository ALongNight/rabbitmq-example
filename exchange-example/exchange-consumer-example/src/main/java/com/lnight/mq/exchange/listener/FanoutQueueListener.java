package com.lnight.mq.exchange.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FanoutQueueListener {

    @RabbitListener(queues = "fanout.queue1")
    public void listenerFanoutQueue1(String msg) {
        System.out.println("消费者接收到fanout.queue1队列的消息：【" + msg + "】") ;
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenerWorkerQueue2(String msg) {
        System.out.println("消费者接收到fanout.queue2队列的消息：【" + msg + "】");
    }
}
