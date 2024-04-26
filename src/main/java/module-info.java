module controllers {
    requires javafx.controls;
    requires javafx.fxml;


    opens controllers to javafx.fxml;
    exports org.example.chapagolfx;
}