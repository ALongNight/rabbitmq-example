package com.lnight.mq.reliable.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsumerConfirmListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("confirm.queue"),
            exchange = @Exchange(value = "confirm.topic", type = ExchangeTypes.TOPIC),
            key = "confirm.#"
    ))
    public void listenSimpleQueue(String msg){
        log.info("消费者接收到confirm.queue的消息：【{}】", msg);
        //使用 1/0 模拟消费者消费异常，然后在本地进行多次重试后仍失败，将消息重新投递至error.queue队列
        //这样做确保消费端异常数据不会丢失
        //重试相关参数可以在application.yaml文件中配置，失败后重新投递在ErrorMessageConfig类中配置
//        System.out.println(1/0);
        log.info("消费者处理消息成功！");
    }
}
