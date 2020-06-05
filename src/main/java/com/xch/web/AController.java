package com.xch.web;

import com.xch.config.PropertiesX;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a")
@Slf4j
public class AController {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private PropertiesX propertiesX;

    @RequestMapping("/x")
    public void ss(){
        log.info("send msg to que1");
        amqpTemplate.convertAndSend("dx1","xx","1111");
    }

    @RequestMapping("/x2")
    public void s1(){
        log.info("load name = " + propertiesX.getName());
    }
}
