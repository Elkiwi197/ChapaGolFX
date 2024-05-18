module controllers {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires com.google.gson;


    opens controllers to javafx.fxml;
    exports org.example.chapagolfx;
}