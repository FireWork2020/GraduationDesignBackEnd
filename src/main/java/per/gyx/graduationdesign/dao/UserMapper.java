package per.gyx.graduationdesign.dao;

import per.gyx.graduationdesign.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String username);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUserRecordByUserName(String userName);

    List<User> selectUserInfo();

}