package com.dany.rabbit.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DanySender1 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i){
        String context = "spring boot dany queue" +" ****** "+i;
        System.err.println("Sender1 : "+context);
        this.rabbitTemplate.convertAndSend("dany",context);
    }
}
