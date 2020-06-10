package per.gyx.graduationdesign.Service;

import per.gyx.graduationdesign.entity.Task;

public interface DoTask {
    boolean storeCollectHistory(Task task);
    void addGarbageToCan(Integer canID);
    void addScoreToUser(Task task);
}
