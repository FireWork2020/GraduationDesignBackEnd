package per.gyx.graduationdesign.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.gyx.graduationdesign.Service.PostMessage;
import per.gyx.graduationdesign.dao.QuestionMapper;
import per.gyx.graduationdesign.entity.Question;

@Service
public class PostMessageImpl implements PostMessage {

    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public void postQuestion(Question question) {
        questionMapper.insert(question);
    }
}
