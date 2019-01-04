package com.dany.rabbitmq;

import com.dany.rabbit.many.DanySender1;
import com.dany.rabbit.many.DanySender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyTest {
    @Autowired
    private DanySender1 danySender1;

    @Autowired
    private DanySender2 danySender2;

    @Test
    public void oneToMany() throws Exception{
        for (int i = 0; i<100; i++){
            danySender1.send(i);
        }
    }

    @Test
    public void manyToMany() throws Exception{
        for (int i=0;i<100;i++){
            danySender1.send(i);
            danySender2.send(i);
        }
    }
}
