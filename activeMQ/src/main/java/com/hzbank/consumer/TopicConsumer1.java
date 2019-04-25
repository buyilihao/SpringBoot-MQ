package com.hzbank.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer1 {

    @JmsListener(destination = "topic")
    public void receiver(String msg) {
        System.out.println("Consumer1: reveive "+msg);
    }
}
