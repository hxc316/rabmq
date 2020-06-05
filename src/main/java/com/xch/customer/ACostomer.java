package com.xch.customer;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class ACostomer {

    @RabbitListener(queues = {"que1"})
    public void s(String msg, Channel channel, Message message){
        log.info("receive1 msg :" + msg);
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("xxx");
        }
    }

    @RabbitListener(queues = {"que1"})
    public void s2(String msg, Channel channel, Message message){
        log.info("receive2 msg :" + msg);
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("xxx");
        }
    }


}
