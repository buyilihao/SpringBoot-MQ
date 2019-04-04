package com.hzbank.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "rabbitMQ")
public class RabbitMQReceiver {

    @RabbitHandler
    public void process(String message){
        System.err.println("RabbitMQ Receiver 2: "+message);
    }
}
