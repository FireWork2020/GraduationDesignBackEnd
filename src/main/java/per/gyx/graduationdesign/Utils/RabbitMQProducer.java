package per.gyx.graduationdesign.Utils;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.gyx.graduationdesign.entity.Task;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class RabbitMQProducer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void taskSend(Task task) {
        try{
            System.out.println("生产者："+task.getCollectcode());
            byte[] taskBytes = SerializeObject.serialize(task);
            this.rabbitTemplate.convertAndSend("task",taskBytes);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
