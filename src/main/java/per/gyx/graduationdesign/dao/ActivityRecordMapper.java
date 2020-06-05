package per.gyx.graduationdesign.dao;

import per.gyx.graduationdesign.entity.ActivityRecord;

public interface ActivityRecordMapper {
    int insert(ActivityRecord record);

    int insertSelective(ActivityRecord record);
}