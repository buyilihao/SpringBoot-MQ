package com.hzbank.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class Message {
    private String id;
    private String msg;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date sendTime;
}
