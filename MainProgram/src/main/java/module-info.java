module com.owl.owl {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.owl.owl to javafx.fxml;
    opens goods to javafx.fxml;
    exports com.owl.owl;
    exports goods;
}