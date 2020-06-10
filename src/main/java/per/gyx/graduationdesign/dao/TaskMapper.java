package per.gyx.graduationdesign.dao;

import per.gyx.graduationdesign.entity.Task;

import java.util.List;

public interface TaskMapper {
    int deleteByPrimaryKey(String collectcode);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(String collectcode);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    List<Task> selectByUserName(String userName);
    List<Task> selectAll();

    Object selectUnCheckedByUserName(String userName);

    int updateChecked(String userName);
}