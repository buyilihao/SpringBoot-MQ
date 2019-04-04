package com.hzbank.sender;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.PublisherCallbackChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
public class TopicSender {
    private static String EXCHANGE_NAME = "topicExchange";

    @Autowired
    private AmqpTemplate template;



    public void sender(String routingKey) throws IOException {
        String content = " RabbitMQ " + new Date().toLocaleString();
        System.err.println("Sender：routingKey="+routingKey+content);
        //第一个参数是交换机，第二个参数是routingKey,第三个参数是要发送的消息,支持实体对象
        //channel.confirmSelect();
        template.convertAndSend(EXCHANGE_NAME,routingKey,content);
    }
}
