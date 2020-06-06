package per.gyx.graduationdesign.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.gyx.graduationdesign.Service.PostMessage;
import per.gyx.graduationdesign.dao.ActivityMapper;
import per.gyx.graduationdesign.dao.ActivityRecordMapper;
import per.gyx.graduationdesign.dao.NoticeMapper;
import per.gyx.graduationdesign.dao.QuestionMapper;
import per.gyx.graduationdesign.entity.Activity;
import per.gyx.graduationdesign.entity.ActivityRecord;
import per.gyx.graduationdesign.entity.Notice;
import per.gyx.graduationdesign.entity.Question;

@Service
public class PostMessageImpl implements PostMessage {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private ActivityRecordMapper activityRecordMapper;

    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public void postQuestion(Question question) {
        questionMapper.insert(question);
    }

    @Override
    public void applyActivity(ActivityRecord record) {
        activityRecordMapper.insert(record);
    }

    @Override
    public void ansQues(Integer id, String ans) {
        questionMapper.updateAnsById(id,ans);
    }


    @Override
    public void releaseNotice(Notice notice) {
        noticeMapper.insert(notice);
    }

    @Override
    public void releaseActivity(Activity activity) {
        activityMapper.insert(activity);
    }
}
