package com.tr.rabbitmq.listener;

import com.rabbitmq.client.Channel;
import com.tr.rabbitmq.config.RabbitMQConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息监听者 Listener
 *
 * @author taorun
 * @date 2023/1/12 11:45
 */
@Component
@RabbitListener(queues = {RabbitMQConfig.QUEUE_1, RabbitMQConfig.QUEUE_2}) // 监听指定队列
public class Listener {

    /**
     * 接收处理消息
     *
     * @return
     */
    @RabbitHandler
    public String process(String msg, Message message, Channel channel) {
        System.out.println("接收到消息：" + msg);
        return "处理完成消息：" + msg;
    }

}
