package com.lnight.mq.reliable.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.amqp.rabbit.retry.RepublishMessageRecoverer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ErrorMessageConfig {

    private static final String EXCHANGE = "error.direct";

    private static final String ROUTING_KEY = "error";

    @Bean
    public DirectExchange errorMessageChange(){
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Queue errorQueue(){
        return new Queue("error.queue");
    }

    @Bean
    public Binding errorMessageBinding(DirectExchange errorMessageChange, Queue errorQueue){
        return BindingBuilder.bind(errorQueue).to(errorMessageChange).with(ROUTING_KEY);
    }

    /**
     * 当消费者处理异常时，会将消息重新投递到error.queue队列
     */
    @Bean
    public MessageRecoverer republishMessageRecoverer(RabbitTemplate rabbitTemplate){
        return new RepublishMessageRecoverer(rabbitTemplate, EXCHANGE, ROUTING_KEY);
    }


}
