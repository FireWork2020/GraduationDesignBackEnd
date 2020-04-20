package per.gyx.graduationdesign.dao;

import per.gyx.graduationdesign.entity.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}