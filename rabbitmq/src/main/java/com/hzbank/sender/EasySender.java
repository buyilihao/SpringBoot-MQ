package com.hzbank.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EasySender {

    @Autowired
    private AmqpTemplate template;

    public void send(){
        String content = "RabbitMQ " + new Date().toLocaleString();
        System.err.println("Sender："+content);
        template.convertAndSend("rabbitMQ",content);
    }
}
