package com.dany.rabbit.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DanySender2 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i){
        String context = "spring boot dany queue" +" ****** "+i;
        System.err.println("Sender2 : "+context);
        this.rabbitTemplate.convertAndSend("dany",context);
    }
}
