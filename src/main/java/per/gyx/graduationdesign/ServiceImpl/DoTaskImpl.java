package per.gyx.graduationdesign.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.gyx.graduationdesign.Service.DoTask;
import per.gyx.graduationdesign.Utils.RedisUtils;
import per.gyx.graduationdesign.dao.TaskMapper;
import per.gyx.graduationdesign.entity.Task;

import java.util.ArrayList;
import java.util.LinkedList;

@Service
public class DoTaskImpl implements DoTask {


    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public boolean storeCollectHistory(Task task) {
        System.out.println("准备插入的任务"+task.getCollectcode());
        return taskMapper.insert(task) > 0;
    }
}
