package com.dany.rabbit.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "dany")
public class DanyReceiver1 {
    @RabbitHandler
    public void process(String dany){
        System.err.println("Receiver 1: "+dany);
    }
}
