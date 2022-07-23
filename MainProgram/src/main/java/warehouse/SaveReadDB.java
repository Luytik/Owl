package warehouse;

import goods.Goods;
import goods.GoodsWareHouse;

import java.sql.SQLException;
import java.util.List;

public interface SaveReadDB {
    List<GoodsWareHouse> getAllGoods();
    void addGoods(Goods goods);
    void addGoods(Goods goods, double amount) throws SQLException;
    void updateAmount(Goods goods, double amount);
    void updateName(Goods goods, String name);
    void removeGoods(Goods goods);
}
