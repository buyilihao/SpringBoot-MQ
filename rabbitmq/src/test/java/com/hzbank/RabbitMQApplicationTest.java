package com.hzbank;

import com.hzbank.sender.DirectSender;
import com.hzbank.sender.EasySender;
import com.hzbank.sender.FanoutSender;
import com.hzbank.sender.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static java.lang.Thread.sleep;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RabbitMQApplication.class)
public class RabbitMQApplicationTest {

    @Autowired
    private EasySender sender;

    @Autowired
    private FanoutSender fanoutSender;

    @Autowired
    private DirectSender directSender;

    @Autowired
    private TopicSender topicSender;

    @Test
    public void topicSender() throws Exception {
        String routingKey = "lazy.quick.yellow.fox";
       topicSender.sender(routingKey);
    }

    @Test
    public void directSender()throws Exception {
//        directSender.sendHello();
//        directSender.sendWorld();
        directSender.sendRabbitMQ();
    }

    @Test
    public void hello() throws Exception {
            sender.send();
    }

    @Test
    public void fanoutSender() throws Exception {
        fanoutSender.send();
    }
}
