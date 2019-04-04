package com.hzbank.receiver;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class KafkaReceiver {

    //监听topic01，可以配置多个，用","分割
    @KafkaListener(topics = {"topic01"})
    public void process(ConsumerRecord record){
        //Java8新特性，解决空指针异常
        Optional<Object> message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            /*public boolean isPresent() {
                return value != null;
             }*/
            Object o = message.get();

            log.info("--------- record: "+record);
            log.info("--------- message: "+o);
        }
    }
}
