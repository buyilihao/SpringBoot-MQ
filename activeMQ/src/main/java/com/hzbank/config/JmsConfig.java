package com.hzbank.config;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class JmsConfig {

    @Bean
    public Topic topic() {
        return new ActiveMQTopic("topic");
    }
}
