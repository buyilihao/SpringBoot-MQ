package com.hzbank.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate template;

    public void send(){
        String content = "RabbitMQ " + new Date().toLocaleString();
        System.err.println("Sender："+content);
        //第一个是交换机名字，第二个是模式类型，第三个是消息内容
        template.convertAndSend("fanoutExchange","fanout",content);
    }
}
