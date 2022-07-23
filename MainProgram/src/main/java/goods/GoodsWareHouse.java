package goods;

public class GoodsWareHouse {
    private int uniqueNumber;
    private String name;
    private UnitsMeasurement unit;
    private double selfPrice;
    private Status status;
    private double amount;



    public GoodsWareHouse(String name, UnitsMeasurement unit, Status status, double amount) {
        this.name = name;
        this.unit = unit;
        this.status = status;
        this.amount = amount;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

