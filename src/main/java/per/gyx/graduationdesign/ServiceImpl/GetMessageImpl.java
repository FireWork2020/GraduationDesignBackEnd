package per.gyx.graduationdesign.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.gyx.graduationdesign.Service.GetMessage;
import per.gyx.graduationdesign.dao.*;
import per.gyx.graduationdesign.entity.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetMessageImpl implements GetMessage {

    @Autowired
    TaskMapper taskMapper;
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    NoticeMapper noticeMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    GarbageCanMapper garbageCanMapper;


    @Override
    public List<GarbageCan> getCans() {
        return garbageCanMapper.selectCans();
    }

    @Override
    public List<User> getUserInfo() {
        return userMapper.selectUserInfo();
    }

    @Override
    public List<Notice> getNotice() {
        return noticeMapper.selectNotice();
    }

    @Override
    public List<Question> getQuesAndAns(String userName) {
        return questionMapper.selectByUserName(userName);
    }

    @Override
    public List<Task> getHistoryByUserName(String userName) {
        return taskMapper.selectByUserName(userName);
    }
    @Override
    public List<Task> getAllCollectHistory() {
        return taskMapper.selectAll();
    }

    @Override
    public List<Question> getQuestion() {
        return questionMapper.selectAll();
    }

    @Override
    public User getUserRecordByUserName(String userName) {
        return userMapper.selectUserRecordByUserName(userName);
    }

    @Override
    public List<Activity> getVolunteerInfo() {
        return activityMapper.selectInfo();
    }

    @Override
    public List<Integer> getHistoryByUserNameAndUnChecked(String userName) {
        ArrayList<Integer> history = (ArrayList<Integer>)taskMapper.selectUnCheckedByUserName(userName);
        ArrayList<Integer> num = new ArrayList<>(4);
        for(int i = 0;i < 4;i++){
            num.add(0);
        }
        for(Integer iter:history){
            num.set(iter,num.get(iter)+1);
        }
        return num;
    }
}
