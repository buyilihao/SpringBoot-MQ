package com.hzbank.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer2 {

    @JmsListener(destination = "topic")
    public void receiver(String msg) {
        System.out.println("Consumer2: reveive "+msg);
    }
}
