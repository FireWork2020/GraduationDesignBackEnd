package per.gyx.graduationdesign.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import per.gyx.graduationdesign.Utils.RabbitMQProducer;
import per.gyx.graduationdesign.entity.Task;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/throw")
public class DoThrow {

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    @RequestMapping("/submitTask")
    public boolean submitTask(@RequestParam("can")Integer can,@RequestParam(name="userName") String userName,@RequestParam(name="type") String type,@RequestParam(name="collectCode") String collectCode){
        Task task = new Task();
        task.setUsername(userName);
        task.setType(Integer.parseInt(type));
        task.setCollectcode(collectCode);
        Date date = new Date();
        String dataString = new SimpleDateFormat("yyyy-MM-dd").format(date);
        task.setDate(dataString);
        task.setGarbagecan(can);
        rabbitMQProducer.taskSend(task);
        return true;
    }
}
