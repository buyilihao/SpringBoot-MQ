package com.hzbank.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {

    @JmsListener(destination = "p2p")
    public void receive(String message){
        System.out.println("Consumer: reveive  "+message);
    }

}
