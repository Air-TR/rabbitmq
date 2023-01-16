package com.tr.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ 配置类
 *
 * @author taorun
 * @date 2023/1/12 11:40
 */
@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_1 = "queue_1";
    public static final String QUEUE_2 = "queue_2";

    /**
     * 创建一个名为 "queue_1" 的队列
     */
    @Bean
    public Queue createPanGoodsQueue(){
        return new Queue(QUEUE_1);
    }

    @Bean
    public Queue createPanOrderQueue(){
        return new Queue(QUEUE_2);
    }

}
