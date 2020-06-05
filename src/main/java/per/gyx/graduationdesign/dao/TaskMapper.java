package per.gyx.graduationdesign.dao;

import per.gyx.graduationdesign.entity.Task;

public interface TaskMapper {
    int deleteByPrimaryKey(String collectcode);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(String collectcode);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
}