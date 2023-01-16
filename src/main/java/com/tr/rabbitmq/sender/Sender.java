package com.tr.rabbitmq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 消息发送者 Sender
 *
 * @author taorun
 * @date 2023/1/12 11:42
 */
@Component
public class Sender {

    @Resource
    private AmqpTemplate amqpTemplate;

    public void send(String queue, String msg) {
        // 方式一
        amqpTemplate.convertAndSend(queue, msg);

        // 方式二
//        amqpTemplate.send(queue, createMessage(msg));
    }

    public String sendAndReceive(String queue, String msg) {
        Message receive = amqpTemplate.sendAndReceive(queue, createMessage(msg));
        return receive.toString();
    }

    private static Message createMessage(String msg) {
        Message message = MessageBuilder.withBody(msg.getBytes())
                .setMessageId(UUID.randomUUID().toString())
                .setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
                .setCorrelationId(UUID.randomUUID().toString())
                .build();
        return message;
    }

}
