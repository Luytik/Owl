package warehouse;

import goods.Goods;
import goods.GoodsWareHouse;

import java.sql.SQLException;
import java.time.temporal.TemporalAmount;
import java.util.List;
import java.util.Map;

public class Warehouse {

    //private Warehouse warehouse = new Warehouse();
    private List<GoodsWareHouse> listGoods;
    private SaveReadDB saveReadDB = new WarehouseOffline();

    public Warehouse(){
        listGoods = saveReadDB.getAllGoods();
    }

    /*public Warehouse getInstance() {
        return warehouse;
    }*/

    public List<GoodsWareHouse> getAllGoods(){
        listGoods = saveReadDB.getAllGoods();
        return listGoods;
    }

    public List<GoodsWareHouse> putIntoWarehouse(Goods goods){
        saveReadDB.addGoods(goods);
        listGoods = saveReadDB.getAllGoods();
        return listGoods;
    }

    public List<GoodsWareHouse> putIntoWarehouse(Goods goods, double amount) throws SQLException {
        saveReadDB.addGoods(goods, amount);
        listGoods = saveReadDB.getAllGoods();
        return listGoods;
    }

    public List<GoodsWareHouse> updateAmount(Goods goods, double amount){
        saveReadDB.updateAmount(goods, amount);
        listGoods = saveReadDB.getAllGoods();
        return listGoods;
    }

    public  List<GoodsWareHouse> updateName(Goods goods, String name){
        saveReadDB.updateName(goods, name);
        listGoods = saveReadDB.getAllGoods();
        return listGoods;
    }

    public List<GoodsWareHouse> removeGoods(Goods goods,String name){
        saveReadDB.removeGoods(goods);
        listGoods = saveReadDB.getAllGoods();
        return listGoods;
    }


}
