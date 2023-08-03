package com.lnight.mq.topicex.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class TopicQueueListener {



    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("topic.queue1"),
            exchange = @Exchange(value = "lnight.topic", type = ExchangeTypes.TOPIC),
            key = "china.#"
    ))
    public void listenerTopicQueue1(String msg){
        System.out.println("消费者接收到topic.queue1队列的消息：【 " + msg + "】");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("topic.queue2"),
            exchange = @Exchange(value = "lnight.topic", type = ExchangeTypes.TOPIC),
            key = "#.news"
    ))
    public void listenerTopicQueue2(String msg){
        System.out.println("消费者接收到topic.queue2队列的消息：【 " + msg + "】");
    }

}
