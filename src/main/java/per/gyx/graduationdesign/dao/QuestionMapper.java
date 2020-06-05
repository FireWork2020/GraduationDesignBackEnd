package per.gyx.graduationdesign.dao;

import per.gyx.graduationdesign.entity.Question;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
}