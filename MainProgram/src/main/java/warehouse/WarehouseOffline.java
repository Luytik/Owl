package warehouse;

import goods.Goods;
import goods.GoodsWareHouse;
import goods.Status;
import goods.UnitsMeasurement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WarehouseOffline implements SaveReadDB{

    private Connection connection;
    private Statement statement;
    private final String sql = "CREATE TABLE if NOT EXISTS warehouse (\n"
            + "idGoods integer primary key AUTOINCREMENT,\n"
            + "GoodsName text NOT NULL UNIQUE ,\n"
            + "UnitsMeasurement text NOT NULL,\n"
            + "Status text NOT NULL,\n"
            + "amount real\n"
            + ");";

    public WarehouseOffline(){
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + "Warehouse.db");
            statement = connection.createStatement();
            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<GoodsWareHouse> getAllGoods() {
        final String sql = "SELECT * FROM warehouse";
        List<GoodsWareHouse> listGoods = new ArrayList<>();


        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                GoodsWareHouse g = new GoodsWareHouse(resultSet.getString("GoodsName"),
                        UnitsMeasurement.fromString(resultSet.getString("UnitsMeasurement")),
                        Status.valueOf(resultSet.getString("Status")),
                        resultSet.getDouble("amount"));
                g.setUniqueNumber(resultSet.getInt("idGoods"));
                listGoods.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listGoods;
    }

    @Override
    public void addGoods(Goods goods) {

    }

    @Override
    public void addGoods(Goods goods, double amount) throws SQLException {
        final String sql = "insert into warehouse(idGoods, GoodsName, UnitsMeasurement," +
                "Status, amount) VALUES (?,?,?,?,?)";
            PreparedStatement pStatment = connection.prepareStatement(sql);
            pStatment.setString(2, goods.getName());
            pStatment.setString(3, goods.getUnit().getFullname());
            pStatment.setString(4, goods.getStatus().toString());
            pStatment.setDouble(5, amount);
            pStatment.executeUpdate();

    }

    @Override
    public void updateAmount(Goods goods, double amount) {

    }

    @Override
    public void updateName(Goods goods, String name) {

    }

    @Override
    public void removeGoods(Goods goods) {

    }
}
