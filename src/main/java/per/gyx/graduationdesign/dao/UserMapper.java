package per.gyx.graduationdesign.dao;

import per.gyx.graduationdesign.entity.User;
import per.gyx.graduationdesign.entity.UserKey;
import per.gyx.graduationdesign.entity.UserWithBLOBs;

public interface UserMapper {
    int deleteByPrimaryKey(UserKey key);

    int insert(UserWithBLOBs record);

    int insertSelective(UserWithBLOBs record);

    UserWithBLOBs selectByPrimaryKey(UserKey key);

    int updateByPrimaryKeySelective(UserWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserWithBLOBs record);

    int updateByPrimaryKey(User record);
}