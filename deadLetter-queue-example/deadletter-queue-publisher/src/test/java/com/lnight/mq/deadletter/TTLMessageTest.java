package com.lnight.mq.deadletter;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.UUID;


@Slf4j
@SpringBootTest
public class TTLMessageTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendMsg2SimpleQueue(){
        //创建消息
        Message message = MessageBuilder.withBody("Hello, ttl message".getBytes(StandardCharsets.UTF_8))
//                .setExpiration("5000")  //消息存活时间，单位ms，当消息与队列都设置存活时间则以时间短的为准
                .build();
        //消息ID，需要封装到CorrelationData中
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        //发送消息
        rabbitTemplate.convertAndSend("ttl.direct", "ttl", message, correlationData);
        log.info("消息已成功发送！");
    }
}
