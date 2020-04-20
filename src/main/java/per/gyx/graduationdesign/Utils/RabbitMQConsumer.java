package per.gyx.graduationdesign.Utils;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "task")
public class RabbitMQConsumer {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    @RabbitHandler
    public void receive(String msg){
        System.out.println("[task] received message: "+msg);
    }
}
