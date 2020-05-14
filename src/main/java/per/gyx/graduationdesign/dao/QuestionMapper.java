package per.gyx.graduationdesign.dao;

import java.util.List;
import per.gyx.graduationdesign.entity.Question;
import per.gyx.graduationdesign.entity.QuestionExample;

public interface QuestionMapper {
    int insert(Question record);

    int insertSelective(Question record);

    List<Question> selectByExample(QuestionExample example);

    List<Question> selectByUserName(String userName);
}