package com.hzbank.test;

import com.hzbank.ActiveMQApplication;
import com.hzbank.producer.JmsProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ActiveMQApplication.class)
public class JmsTest {

    @Autowired
    private JmsProducer jmsProducer;

    @Test
    public void send(){
        jmsProducer.sendMessage();
    }
}
