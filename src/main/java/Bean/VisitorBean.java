package Bean;

public class VisitorBean {
    private int id;
    private int buildNumber;//楼号
    private String visitorName;//访客名
    private String visitorDate;//访问日期
    private String phone;//电话
    private String reason;//原因

    public VisitorBean() {
    }

    public VisitorBean(String visitorName, int buildNumber, String visitorDate, String phone, String reason) {
        this.visitorName = visitorName;
        this.buildNumber = buildNumber;
        this.visitorDate = visitorDate;
        this.phone = phone;
        this.reason = reason;
    }

    public int getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(int buildNumber) {
        this.buildNumber = buildNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorDate() {
        return visitorDate;
    }

    public void setVisitorDate(String visitorDate) {
        this.visitorDate = visitorDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
