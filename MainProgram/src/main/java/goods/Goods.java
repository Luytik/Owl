package goods;

public class Goods {
    private int uniqueNumber;
    private String name;
    private UnitsMeasurement unit;
    private double selfPrice;
    private Status status;

    public Goods(){

    }

    public Goods(String name, UnitsMeasurement unit, Status status) {
        this.name = name;
        this.unit = unit;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UnitsMeasurement getUnit() {
        return unit;
    }

    public void setUnit(UnitsMeasurement unit) {
        this.unit = unit;
    }

    public int getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(int uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public double getSelfPrice() {
        return selfPrice;
    }

    public void setSelfPrice(double selfPrice) {
        this.selfPrice = selfPrice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", unit=" + unit +
                ", uniqueNumber=" + uniqueNumber +
                ", selfPrice=" + selfPrice +
                ", status=" + status +
                '}';
    }
}
