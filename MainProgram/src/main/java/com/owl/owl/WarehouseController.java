package com.owl.owl;

import goods.Goods;
import goods.GoodsWareHouse;
import goods.Status;
import goods.UnitsMeasurement;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.util.converter.DoubleStringConverter;
import warehouse.Warehouse;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WarehouseController implements Initializable {

    Warehouse warehouse = new Warehouse();

    @FXML
    private Button adddGoodsBtn;

    @FXML
    private TableView<GoodsWareHouse> GoodsList;

    @FXML
    private TableColumn<GoodsWareHouse, Double> amountClmn;

    @FXML
    private TableColumn<GoodsWareHouse, Integer> idClmn;

    @FXML
    private TableColumn<GoodsWareHouse, String> nameClmn;

    @FXML
    private TableColumn<GoodsWareHouse, Status> statusClmn;

    @FXML
    private TableColumn<GoodsWareHouse, UnitsMeasurement> unitClmn;

    @FXML
    private Button updateBtn;

    @FXML
    private Label label;

    @FXML
    void updateGoodsList(ActionEvent event) {

    }

    @FXML
    void addGoods(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("addNewGoods.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Добавити новий товар на склад");
            stage.setScene(scene);
            stage.show();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GoodsList.setEditable(true);
        ObservableList<GoodsWareHouse> data = FXCollections.observableArrayList(
                warehouse.getAllGoods()
        );

        //Name Column / Edit name
        nameClmn.setCellValueFactory(new PropertyValueFactory<GoodsWareHouse, String>("name"));
        nameClmn.setCellFactory(TextFieldTableCell.<GoodsWareHouse>forTableColumn());
        nameClmn.setOnEditCommit((CellEditEvent<GoodsWareHouse, String> event) -> {
            TablePosition<GoodsWareHouse, String> pos = event.getTablePosition();
            String newName = event.getNewValue();
            int row = pos.getRow();
            GoodsWareHouse gw = event.getTableView().getItems().get(row);
            gw.setName(newName);
        });
        // units measurement
        ObservableList<UnitsMeasurement> unitList = FXCollections.observableArrayList(//
                UnitsMeasurement.values());
        unitClmn.setCellValueFactory(new PropertyValueFactory<GoodsWareHouse, UnitsMeasurement>("unit"));

        unitClmn.setCellValueFactory(new Callback<CellDataFeatures<GoodsWareHouse, UnitsMeasurement>, ObservableValue<UnitsMeasurement>>() {

            @Override
            public ObservableValue<UnitsMeasurement> call(CellDataFeatures<GoodsWareHouse, UnitsMeasurement> param) {
                GoodsWareHouse gw = param.getValue();
                // F,M
                //String genderCode = person.getGender();
                UnitsMeasurement unit = gw.getUnit();
                return new SimpleObjectProperty<UnitsMeasurement>(unit);
            }
        });
        unitClmn.setCellFactory(ComboBoxTableCell.forTableColumn(unitList));
        unitClmn.setOnEditCommit((CellEditEvent<GoodsWareHouse, UnitsMeasurement> event) -> {
            TablePosition<GoodsWareHouse, UnitsMeasurement> pos = event.getTablePosition();
            UnitsMeasurement newUnit = event.getNewValue();
            int row = pos.getRow();
            GoodsWareHouse gw = event.getTableView().getItems().get(row);
            gw.setUnit(newUnit);
        });
        //Status
        statusClmn.setCellValueFactory(new PropertyValueFactory<GoodsWareHouse, Status>("status"));
        ObservableList<Status> statusList = FXCollections.observableArrayList(//
                Status.values());
        statusClmn.setCellValueFactory(new Callback<CellDataFeatures<GoodsWareHouse, Status>, ObservableValue<Status>>() {
            @Override
            public ObservableValue<Status> call(CellDataFeatures<GoodsWareHouse, Status> param) {
                GoodsWareHouse gw = param.getValue();
                Status status = gw.getStatus();
                return new SimpleObjectProperty<Status>(status);
            }
        });
        statusClmn.setCellFactory(ComboBoxTableCell.forTableColumn(statusList));
        statusClmn.setOnEditCommit((CellEditEvent<GoodsWareHouse, Status> event) -> {
                    TablePosition<GoodsWareHouse, Status> pos = event.getTablePosition();
                    Status newStatus = event.getNewValue();
                    int row = pos.getRow();
                    GoodsWareHouse gw = event.getTableView().getItems().get(row);
                    gw.setStatus(newStatus);
        });

        idClmn.setCellValueFactory(new PropertyValueFactory<GoodsWareHouse, Integer>("uniqueNumber"));
        //
        amountClmn.setCellValueFactory(new PropertyValueFactory<GoodsWareHouse, Double>("amount"));
        amountClmn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        amountClmn.setOnEditCommit(event -> {
            TablePosition<GoodsWareHouse, Double> pos = event.getTablePosition();
            Double newAmount = event.getNewValue();
            int row = pos.getRow();
            GoodsWareHouse gw = event.getTableView().getItems().get(row);
            gw.setAmount(newAmount);
        });

        GoodsList.setItems(data);
    }
}
