package com.lnight.mq.reliable;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@Slf4j
@SpringBootTest
public class PublisherTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendMsg2ReliableQueue(){
        String exchange = "confirm.topic";
        String msg = "Hello, Spring amqp!";
        String id = UUID.randomUUID().toString();
        CorrelationData correlationData = new CorrelationData(id);
        correlationData.getFuture().addCallback(result -> {
            if (result.isAck()) {
                log.info("消息投递到交换机成功！数据ID：{}", correlationData.getId());
            } else {
                log.error("消息投递到交换机失败！数据ID：{}", correlationData.getId());
            }
        }, ex -> log.error("消息发送异常！数据ID：{}", correlationData.getId()));
        //给一个错误的交换机名称，模拟投递到交换机失败的案例
//        rabbitTemplate.convertAndSend(exchange + "cc", "confirm.test", msg, correlationData);
        //给一个错误的routingKey模拟从交换机投递到队列失败的案例
//        rabbitTemplate.convertAndSend(exchange, "1.confirm.test", msg, correlationData);
        rabbitTemplate.convertAndSend(exchange, "confirm.test", msg, correlationData);
    }
}
