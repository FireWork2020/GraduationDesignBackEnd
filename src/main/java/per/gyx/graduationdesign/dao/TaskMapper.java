package per.gyx.graduationdesign.dao;

import java.util.List;
import per.gyx.graduationdesign.entity.Task;
import per.gyx.graduationdesign.entity.TaskExample;

public interface TaskMapper {
    int insert(Task record);

    int insertSelective(Task record);

    List<Task> selectByExample(TaskExample example);

    List<Task> selectByUserName(String userName);

    List<Integer> selectUnCheckedByUserName(String userName);
}