package com.owl.owl;

import goods.Goods;
import goods.GoodsWareHouse;
import goods.Status;
import goods.UnitsMeasurement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import warehouse.Warehouse;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;




public class AddNewGoodsController implements Initializable {

    @FXML
    private ChoiceBox<Status> statusChBox;

    @FXML
    private Button addGodsBtn;

    @FXML
    private TextField amountTField;

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField goodsNameTFiled;

    @FXML
    private ChoiceBox<UnitsMeasurement> unitsChBox;

    @FXML
    void addGoods(ActionEvent event) {
        Warehouse warehouse = new Warehouse();
        Goods goods = new Goods(goodsNameTFiled.getText(), unitsChBox.getValue(), statusChBox.getValue());
        try {
            warehouse.putIntoWarehouse(goods, Double.parseDouble(amountTField.getText()));
        } catch (SQLException e) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);

            VBox vbox = new VBox(new Text("Невірно введені дані"), new Button("Ok."));
            vbox.setAlignment(Pos.CENTER);
            vbox.setPadding(new Insets(15));

            dialogStage.setScene(new Scene(vbox));
            dialogStage.show();
            e.printStackTrace();
        }
        System.out.println(goods.toString());
    }

    @FXML
    void canel(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<UnitsMeasurement> units = FXCollections.observableArrayList(UnitsMeasurement.values());
        ObservableList<Status> status = FXCollections.observableArrayList(Status.values());
        unitsChBox.setItems(units);
        statusChBox.setItems(status);
    }
}
