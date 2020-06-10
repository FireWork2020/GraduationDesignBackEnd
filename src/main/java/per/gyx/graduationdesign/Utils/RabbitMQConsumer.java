package per.gyx.graduationdesign.Utils;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.gyx.graduationdesign.Service.DoTask;
import per.gyx.graduationdesign.entity.Task;


@Component

public class RabbitMQConsumer {

    @Autowired
    private DoTask doTask;

    @Autowired
    private RedisUtils redisUtils;


    @RabbitHandler
    @RabbitListener(queues = "task")
    public void receive(Task task){

        doTask.storeCollectHistory(task);
        doTask.addGarbageToCan(task.getGarbagecan());
        doTask.addScoreToUser(task);

        String imgName = task.getCollectcode();
        redisUtils.deleteCodeFromList(task.getCollectcode());
        QRCodeGenerator.deleteQRCodePic(task.getCollectcode());
    }
}
