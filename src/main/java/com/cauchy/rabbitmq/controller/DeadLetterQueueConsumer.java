package com.cauchy.rabbitmq.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.channels.Channel;
import java.util.Date;

@Slf4j
@Component
public class DeadLetterQueueConsumer {

    @RabbitListener
    public void receiveD(Message message, Channel channel)throws IOException {
        String msg = new String(message.getBody());
        log.info("当前时间：{},收到死信队列信息{}",new Date().toString(),msg);
    }
}
