package per.gyx.graduationdesign.entity;

public class ActivityRecord {
    private Integer activitynum;

    private String username;

    public Integer getActivitynum() {
        return activitynum;
    }

    public void setActivitynum(Integer activitynum) {
        this.activitynum = activitynum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}