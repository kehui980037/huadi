package Bean;

public class DormBean {
    private int id;
    private int buildNumber;
    private int floorNumber;
    private int dormNumber;
    private int peopleCount;




    public DormBean(int id,int buildNumber, int floorNumber, int dormNumber, int peopleCount) {
        this.id = id;
        this.buildNumber = buildNumber;
        this.floorNumber = floorNumber;
        this.dormNumber = dormNumber;
        this.peopleCount = peopleCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(int buildNumber) {
        this.buildNumber = buildNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getDormNumber() {
        return dormNumber;
    }

    public void setDormNumber(int dormNumber) {
        this.dormNumber = dormNumber;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }
}
