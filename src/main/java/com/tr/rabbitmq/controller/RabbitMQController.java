package com.tr.rabbitmq.controller;

import com.tr.rabbitmq.sender.Sender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author taorun
 * @date 2023/1/12 11:41
 */
@RestController
public class RabbitMQController {

    @Resource
    private Sender sender;

    /**
     * 发送消息
     *
     * @param msg
     */
    @GetMapping("/send/{queue}/{msg}")
    public void send(@PathVariable String queue, @PathVariable String msg) {
        sender.send(queue, msg);
    }

    /**
     * 发送并接收返回消息
     *
     * @param queue
     * @param msg
     * @return
     */
    @GetMapping("/sendAndReceive/{queue}/{msg}")
    public String sendAndReceive(@PathVariable String queue, @PathVariable String msg) {
        return sender.sendAndReceive(queue, msg);
    }

}
