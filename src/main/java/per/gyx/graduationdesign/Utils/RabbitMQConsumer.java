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

import java.nio.channels.Channel;
import java.util.concurrent.locks.ReentrantLock;

@Component

public class RabbitMQConsumer {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    @Autowired
    private DoTask doTask;

    @Autowired
    private RedisUtils redisUtils;

    @RabbitHandler
    @RabbitListener(queues = "test")
    public void receive2(Task task){
        System.out.println("RabbitMQConsumer: "+task.toString());
        redisUtils.deleteListLeft();
    }
    @RabbitHandler
    @RabbitListener(queues = "task")
    public void receive(Task task){
//        System.out.println(taskBytes.toString());
//        Task task = SerializeObject.deSerialize(taskBytes);
//        System.out.println("接收到的消息为:"+task.getCollectcode());
//        redisUtils.deleteListLeft();
//        doTask.storeCollectHistory(task);
        //System.out.println(task.toString());
        //redisUtils.deleteListLeft();
    }


}
