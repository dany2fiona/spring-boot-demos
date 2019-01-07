package com.dany.rabbit.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context = "hi, i am message all";
        System.err.println("Sender : "+context);
        this.rabbitTemplate.convertAndSend("topicExchange","topic.1",context);
    }

    public void send1(){
        String context = "hi, i am message 1";
        System.err.println("Sender : "+context);
        this.rabbitTemplate.convertAndSend("topicExchange","topic.message",context);
    }

    public void send2(){
        String context = "hi, i am message 2";
        System.err.println("Sender : "+context);
        this.rabbitTemplate.convertAndSend("topicExchange","topic.messages",context);
    }
}
