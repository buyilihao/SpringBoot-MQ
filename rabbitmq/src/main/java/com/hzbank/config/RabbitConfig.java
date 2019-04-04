package com.hzbank.config;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.PublisherCallbackChannel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

//    private static String EXCHANGE_NAME = "directExchange";
    private static String TOPIC_EXCHANGE_NAME = "topicExchange";


    @Bean
    public Queue topicQueue() {
        return new Queue("topic");
    }

    @Bean
    public Queue rabbitQueue(){
        return new Queue("rabbitMQ");
    }

    //创建一个topic类型的交换机
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }

    //将交换机和队列绑定
    @Bean
    public Binding bindTopic(Queue topicQueue,TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue).to(topicExchange).with("*.orange.*");
    }

    @Bean
    public Binding bindTopic1(Queue rabbitQueue,TopicExchange topicExchange) {
        return BindingBuilder.bind(rabbitQueue).to(topicExchange).with("*.*.rabbit");
    }

    @Bean
    public Binding bindTopic2(Queue rabbitQueue,TopicExchange topicExchange) {
        return BindingBuilder.bind(rabbitQueue).to(topicExchange).with("lazy.#");
    }

//    @Bean
//    public Channel publishCallChannel(){
//        return new PublisherCallbackChannel()
//    }

    //创建两个队列
//    @Bean
//    public Queue helloQueue() {
//        return new Queue("hello");
//    }

//    //创建一个direct类型的交换机
//    @Bean
//    public DirectExchange directExchange() {
//        return new DirectExchange(EXCHANGE_NAME);
//    }
//
//    //将交换机和队列绑定
//    @Bean
//    public Binding bindDirect(Queue helloQueue,DirectExchange directExchange) {
//        //routing key is hello
//        return BindingBuilder.bind(helloQueue).to(directExchange).with("hello");
//    }
//
//    @Bean
//    public Binding bindDirect1(Queue helloQueue,DirectExchange directExchange) {
//        //routing key is world
//        return BindingBuilder.bind(helloQueue).to(directExchange).with("world");
//    }
//
//    @Bean
//    public Binding bindDirect3(Queue rabbitQueue,DirectExchange directExchange) {
//        //routing key is rabbitMQ
//        return BindingBuilder.bind(rabbitQueue).to(directExchange).with("rabbitMQ");
//    }

//    //创建一个fanout的交换机
//    @Bean
//    public FanoutExchange fanoutExchange() {
//        return new FanoutExchange("fanoutExchange");
//    }
//
//    //将交换机和队列绑定
//    @Bean
//    public Binding bindFanout1(Queue helloQueue,FanoutExchange fanoutExchange) {
//        return BindingBuilder.bind(helloQueue).to(fanoutExchange);
//    }
//
//    @Bean
//    public Binding bindFanout2(Queue rabbitQueue,FanoutExchange fanoutExchange) {
//        return BindingBuilder.bind(rabbitQueue).to(fanoutExchange);
//    }
}
