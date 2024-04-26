module org.example.chapagolfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.chapagolfx to javafx.fxml;
    exports org.example.chapagolfx;
}