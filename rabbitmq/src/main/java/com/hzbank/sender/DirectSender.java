package com.hzbank.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DirectSender {

    private static String EXCHANGE_NAME = "directExchange";

    @Autowired
    private AmqpTemplate template;

    String content = "RabbitMQ " + new Date().toLocaleString();

    public void sendHello(){

        System.err.println("Sender："+content);
        //第一个是交换机的名称，第二个是routingKey，第三个是消息。
        template.convertAndSend(EXCHANGE_NAME,"hello",content+" Hello");
    }

    public void sendWorld(){
        System.err.println("Sender："+content);
        //第一个是交换机的名称，第二个是routingKey，第三个是消息。
        template.convertAndSend(EXCHANGE_NAME,"world",content+" World");
    }

    public void sendRabbitMQ(){
        System.err.println("Sender："+content);
        //第一个是交换机的名称，第二个是routingKey，第三个是消息。
        template.convertAndSend(EXCHANGE_NAME,"rabbitMQ",content+" RabbitMQ");
    }
}
