package per.gyx.graduationdesign.entity;

public class Activity {
    private Integer activitynum;

    private String topic;

    private String msg;

    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getActivitynum() {
        return activitynum;
    }

    public void setActivitynum(Integer activitynum) {
        this.activitynum = activitynum;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic == null ? null : topic.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }
}