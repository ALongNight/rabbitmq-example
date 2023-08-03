package com.lnight.mq.directex.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class DirectQueueListener {



    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("direct.queue1"),
            exchange = @Exchange(value = "lnight.direct", type = ExchangeTypes.DIRECT),
            key = {"blue", "red"}
    ))
    public void listenerDirectQueue1(String msg){
        System.out.println("消费者接收到direct.queue1队列的消息：【 " + msg + "】");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("direct.queue2"),
            exchange = @Exchange(value = "lnight.direct", type = ExchangeTypes.DIRECT),
            key = {"yellow", "red"}
    ))
    public void listenerDirectQueue2(String msg){
        System.out.println("消费者接收到direct.queue2队列的消息：【 " + msg + "】");
    }

}
