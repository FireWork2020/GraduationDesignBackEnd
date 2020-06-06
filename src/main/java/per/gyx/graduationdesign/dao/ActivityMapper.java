package per.gyx.graduationdesign.dao;

import per.gyx.graduationdesign.entity.Activity;

import java.util.List;

public interface ActivityMapper {
    int deleteByPrimaryKey(Integer activitynum);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer activitynum);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

    List<Activity> selectInfo();
}