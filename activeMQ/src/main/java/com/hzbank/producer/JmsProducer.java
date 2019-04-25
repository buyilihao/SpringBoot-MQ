package com.hzbank.producer;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import java.util.Date;

@Component
public class JmsProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    Destination destination = new ActiveMQQueue("p2p");

    /**
     * 发送消息
     */
    public void sendMessage(){

        String message="点对点模式测试 "+new Date().toLocaleString();
        jmsTemplate.convertAndSend(destination,message);
        System.out.println("Producer: send "+message);
    }
}
