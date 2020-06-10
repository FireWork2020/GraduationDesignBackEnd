package per.gyx.graduationdesign.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.gyx.graduationdesign.Service.DoTask;
import per.gyx.graduationdesign.Utils.RedisUtils;
import per.gyx.graduationdesign.dao.GarbageCanMapper;
import per.gyx.graduationdesign.dao.TaskMapper;
import per.gyx.graduationdesign.dao.UserMapper;
import per.gyx.graduationdesign.entity.Task;

@Service
public class DoTaskImpl implements DoTask {


    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private GarbageCanMapper garbageCanMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean storeCollectHistory(Task task) {
        return taskMapper.insert(task) > 0;
    }

    @Override
    public void addGarbageToCan(Integer canID) {
        garbageCanMapper.updateStateByCanID(canID);
    }

    @Override
    public void addScoreToUser(Task task) {
        Integer type = task.getType();
        String userName = task.getUsername();
        if(type == 0){
            userMapper.updateType1(userName);
        }else if(type == 1){
            userMapper.updateType2(userName);
        }else if(type == 2){
            userMapper.updateType3(userName);
        }else if(type == 3){
            userMapper.updateType4(userName);
        }
    }
}
