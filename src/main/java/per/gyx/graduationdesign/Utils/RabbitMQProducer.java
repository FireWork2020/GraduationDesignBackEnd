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
    @Autowired
    private RedisUtils redisUtils;

    public void testTaskSend(Task task){
        rabbitTemplate.convertAndSend("test",task);
    }
    public void taskSend(Task task) {
        System.out.println("生产者："+task.getCollectcode());
        byte[] taskBytes = new byte[0];
        try {
            taskBytes = SerializeObject.serialize(task);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.rabbitTemplate.convertAndSend("task",taskBytes);


    }
}
