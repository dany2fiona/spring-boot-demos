package com.dany.rabbit.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "dany")
public class DanyReceiver2 {
    @RabbitHandler
    public void process(String dany){
        System.err.println("Receiver 2: "+dany);
    }
}
