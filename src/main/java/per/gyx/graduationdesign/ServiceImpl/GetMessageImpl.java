package per.gyx.graduationdesign.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.gyx.graduationdesign.Service.GetMessage;
import per.gyx.graduationdesign.dao.NoticeMapper;
import per.gyx.graduationdesign.dao.QuestionMapper;
import per.gyx.graduationdesign.dao.TaskMapper;
import per.gyx.graduationdesign.entity.Notice;
import per.gyx.graduationdesign.entity.Question;
import per.gyx.graduationdesign.entity.Task;

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