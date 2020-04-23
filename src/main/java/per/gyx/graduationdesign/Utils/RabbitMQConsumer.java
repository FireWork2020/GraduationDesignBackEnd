package per.gyx.graduationdesign.Utils;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import per.gyx.graduationdesign.Service.DoTask;
import per.gyx.graduationdesign.ServiceImpl.DoTaskImpl;
import per.gyx.graduationdesign.entity.Task;

@Component
@RabbitListener(queues = "task")
public class RabbitMQConsumer {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    @Autowired
    private DoTask doTask;

    @RabbitHandler
    public void receive(byte[] taskBytes){

        doTask.storeCollectHistory(SerializeObject.deSerialize(taskBytes));
    }
}
