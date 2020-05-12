package per.gyx.graduationdesign.Service;

import per.gyx.graduationdesign.entity.Task;

import java.util.List;

public interface GetMessage {
    List<Task> getHistoryByUserName(String userName);
    List<Integer> getHistoryByUserNameAndUnChecked(String userName);
}
