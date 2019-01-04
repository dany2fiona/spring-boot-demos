package com.dany.rabbit.object;

import com.dany.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(User user){
        System.err.println("Sender object: "+user.toString());
        this.rabbitTemplate.convertAndSend("object",user);
    }
}
