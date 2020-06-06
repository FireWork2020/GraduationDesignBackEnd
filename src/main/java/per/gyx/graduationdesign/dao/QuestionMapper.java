package per.gyx.graduationdesign.dao;

import io.lettuce.core.dynamic.annotation.Param;
import per.gyx.graduationdesign.entity.Question;

import java.util.List;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    List<Question> selectByUserName(String userName);
    List<Question> selectAll();

    void updateAnsById(@Param("id")Integer id, @Param("ans")String ans);
}