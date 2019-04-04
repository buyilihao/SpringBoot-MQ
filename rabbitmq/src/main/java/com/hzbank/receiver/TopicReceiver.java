package com.hzbank.receiver;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="topic")
public class TopicReceiver {

    @RabbitHandler
    public void process(String topic){
        System.err.println("Topic Receiver 3: "+topic);
    }

}
