package com.lnight.mq.deadletter.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DeadLetterListener {


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "dl.queue", declare = "true"),
            exchange = @Exchange("dl.direct"),
            key = "dl"
    ))
    public void listenerDlQueue(String message){
        log.info("消费者接收到dl.queue的延迟消息：【{}】", message);
    }
}
