package per.gyx.graduationdesign.dao;

import per.gyx.graduationdesign.entity.Task;

public interface TaskMapper {
    int insert(Task record);

    int insertSelective(Task record);
}