package com.lnight.mq.reliable.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ReturnCallbackConfig implements ApplicationContextAware {

    //需要在application.yaml配置文件中    publisher-returns: true   开启回调
    //当数据从交换价投递到队列失败时，进行回调处理
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        RabbitTemplate rabbitTemplate = applicationContext.getBean(RabbitTemplate.class);
        rabbitTemplate.setReturnsCallback(returned -> log.error("消息发送失败，应答码：{}， 原因：{}， 交换机：{}， 路由key：{}， 消息：{}",
                returned.getReplyCode(), returned.getReplyText(), returned.getExchange(), returned.getRoutingKey(), returned.getMessage()));
    }

}
