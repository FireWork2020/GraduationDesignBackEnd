package per.gyx.graduationdesign.Service;

import per.gyx.graduationdesign.entity.*;

import java.util.List;

public interface GetMessage {
    List<Task> getHistoryByUserName(String userName);
    List<Integer> getHistoryByUserNameAndUnChecked(String userName);
    List<Question> getQuesAndAns(String userName);
    List<Question> getQuestion();
    List<Notice> getNotice();
    User getUserRecordByUserName(String userName);
    List<Activity> getVolunteerInfo();
    List<Task> getAllCollectHistory();
    List<User> getUserInfo();
    List<GarbageCan> getCans();
}
