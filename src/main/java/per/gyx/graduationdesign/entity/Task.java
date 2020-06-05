package per.gyx.graduationdesign.entity;

public class Task {
    private String collectcode;

    private String username;

    private Integer type;

    private String date;

    private Integer checked;

    public String getCollectcode() {
        return collectcode;
    }

    public void setCollectcode(String collectcode) {
        this.collectcode = collectcode == null ? null : collectcode.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }
}