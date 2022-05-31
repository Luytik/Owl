module com.owl.owl {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.owl.owl to javafx.fxml;
    exports com.owl.owl;
}