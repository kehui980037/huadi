package Bean;

public class PropertyBean {
    private int id;
    private int buildNumber;
    private String goodName;
    private Float price;

    public PropertyBean() {
    }

    public PropertyBean(int id,int buildNumber, String goodName, Float price) {
        this.id = id;
        this.buildNumber = buildNumber;
        this.goodName = goodName;
        this.price = price;
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

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
