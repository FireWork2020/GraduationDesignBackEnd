package per.gyx.graduationdesign.Service;

import per.gyx.graduationdesign.entity.Activity;
import per.gyx.graduationdesign.entity.ActivityRecord;
import per.gyx.graduationdesign.entity.Notice;
import per.gyx.graduationdesign.entity.Question;

public interface PostMessage {
    void postQuestion(Question question);
    void applyActivity(ActivityRecord record);
    void ansQues(Integer id,String ans);
    void releaseNotice(Notice notice);
    void releaseActivity(Activity activity);
}
