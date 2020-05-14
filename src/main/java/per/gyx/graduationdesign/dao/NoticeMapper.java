package per.gyx.graduationdesign.dao;

import java.util.List;
import per.gyx.graduationdesign.entity.Notice;
import per.gyx.graduationdesign.entity.NoticeExample;

public interface NoticeMapper {
    int insert(Notice record);

    int insertSelective(Notice record);

    List<Notice> selectByExample(NoticeExample example);

    List<Notice> selectNotice();
}