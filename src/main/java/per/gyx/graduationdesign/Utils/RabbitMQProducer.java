package per.gyx.graduationdesign.Utils;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.gyx.graduationdesign.entity.Task;

@Component
public class RabbitMQProducer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void taskSend(Task task) {
        rabbitTemplate.convertAndSend("task",task);
    }
}
