package goods;

import java.util.Map;

public class ExtendedGoods extends Goods {
    private Map<Goods, Double> consistOf;



    public ExtendedGoods(Map<Goods, Double> consistOf) {
        this.consistOf = consistOf;

    }

    public ExtendedGoods(String name, UnitsMeasurement unit, Map<Goods, Double> consistOf, Status status) {
        super(name, unit, status);
        this.consistOf = consistOf;

    }

    public Map<Goods, Double> getConsistOf() {
        return consistOf;
    }

    public void setConsistOf(Map<Goods, Double> consistOf) {
        this.consistOf = consistOf;
    }



    public void addComponent(Goods goods, Double amount) {
        consistOf.put(goods, amount);
    }

    @Override
    public void setSelfPrice(double selfPrice) {
        super.setSelfPrice(selfPrice);
    }

    @Override
    public double getSelfPrice() {
        return 0;
    }
}
