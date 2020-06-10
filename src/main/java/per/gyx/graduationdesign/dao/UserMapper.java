package per.gyx.graduationdesign.dao;

import org.apache.ibatis.annotations.Param;
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

    void updateScore(@Param("username")String username,@Param("type") Integer type);

    int updateToZero(String userName);

    int updateType1(String userName);
    int updateType2(String userName);
    int updateType3(String userName);
    int updateType4(String userName);
}