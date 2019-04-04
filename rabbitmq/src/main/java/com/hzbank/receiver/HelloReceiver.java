package com.hzbank.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

//    @RabbitHandler
//    public void process(String hello) {
//        System.err.println("Hello World Receiver 1："+hello);
//    }
}
