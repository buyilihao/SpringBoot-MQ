package com.hzbank.sender;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hzbank.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String,String> template;

    private JSON json=new JSONObject();

    public void sender(){
        Message message=new Message();
        message.setId("001");
        message.setMsg("hello kafka");
        log.info("+++++++ message: "+json.toJSONString(message));
        //第一个参数时topic，第二个时key，第三个是value
        template.send("topic01","kafka",json.toJSONString(message));
    }
}