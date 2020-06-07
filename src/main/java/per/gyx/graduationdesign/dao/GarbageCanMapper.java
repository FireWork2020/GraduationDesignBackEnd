package per.gyx.graduationdesign.dao;

import per.gyx.graduationdesign.entity.GarbageCan;

import java.util.List;

public interface GarbageCanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GarbageCan record);

    int insertSelective(GarbageCan record);

    GarbageCan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GarbageCan record);

    int updateByPrimaryKey(GarbageCan record);

    void updateStateByCanID(Integer id);

    List<GarbageCan> selectCans();
}