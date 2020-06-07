package per.gyx.graduationdesign.entity;

public class Task implements java.io.Serializable{
    private String username;
    private Integer type;
    private String collectcode;
    private String date;
    private Integer checked;
    private Integer garbagecan;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCollectcode() {
        return collectcode;
    }

    public void setCollectcode(String collectcode) {
        this.collectcode = collectcode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public Integer getGarbagecan() {
        return garbagecan;
    }

    public void setGarbagecan(Integer garbagecan) {
        this.garbagecan = garbagecan;
    }
}
