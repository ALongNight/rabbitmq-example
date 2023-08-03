package com.lnight.mq.workerq.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
public class WorkerListener {

    /**
     * 用线程阻塞模仿两个频率不一的worker，
     * 需在配置文件中设置 prefetch: 1 来控制 消费一条取一条
     */

    @RabbitListener(queues = "worker.queue")
    public void listenerWorkerQueue1(String msg) throws InterruptedException {
        System.out.println("消费者1接收到worker.queue的消息：【" + msg + "】") ;
        Thread.sleep(50);
    }

    @RabbitListener(queues = "worker.queue")
    public void listenerWorkerQueue2(String msg) throws InterruptedException {
        System.err.println("消费者2.......接收到worker.queue2的消息：【" + msg + "】" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd HH:mm:ss")));
        Thread.sleep(200);
    }
}
