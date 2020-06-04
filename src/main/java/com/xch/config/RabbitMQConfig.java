package com.xch.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitMQConfig {
    @Bean(name = "que1")
    public Queue queue1(){
        log.info(" que1 queen add");
        return new Queue("que1");
    }

    @Bean(name = "dx1")
    public DirectExchange exchange(){
        return new DirectExchange("dx1",true,true);
    }

    @Bean
    public Binding binding(DirectExchange dx1, Queue que1){
        return BindingBuilder.bind(que1).to(dx1).with("xx");
    }
}
