package per.gyx.graduationdesign.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import per.gyx.graduationdesign.Utils.RabbitMQProducer;
import per.gyx.graduationdesign.entity.Task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/throw")
public class DoThrow {

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    @RequestMapping("/submitTask")
    public boolean submitTask(@RequestBody HashMap<String,Object> params){
        Task task = new Task();
        task.setUsername((String)params.get("userName"));
        String type = (String)params.get("type");
        System.out.println(type);
        task.setType(Integer.parseInt(type));

        task.setGarbagecan((Integer)params.get("can"));
        task.setCollectcode((String)params.get("collectCode"));
        task.setChecked(0);
        Date date = new Date();
        String dataString = new SimpleDateFormat("yyyy-MM-dd").format(date);
        task.setDate(dataString);
        rabbitMQProducer.taskSend(task);
        return true;
    }
}
