package per.gyx.graduationdesign.Service;

import per.gyx.graduationdesign.entity.Notice;
import per.gyx.graduationdesign.entity.Question;
import per.gyx.graduationdesign.entity.Task;

import java.util.List;

public interface GetMessage {
    List<Task> getHistoryByUserName(String userName);
    List<Integer> getHistoryByUserNameAndUnChecked(String userName);
    List<Question> getQuesAndAns(String userName);
    List<Notice> getNotice();
}
