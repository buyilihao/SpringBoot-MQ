package com.hzbank.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Topic;
import java.util.Date;

@Component
public class TopicProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Topic topic;

    public void sendMessage(){
        String message="发布订阅模式测试 "+new Date().toLocaleString();
        jmsTemplate.convertAndSend(topic,message);
        System.out.println("Producer: send "+message);
    }
}
