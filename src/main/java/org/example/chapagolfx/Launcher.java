package org.example.chapagolfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {

    //CAMBIO TONTO 3
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("/fxml/principal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600 );
        stage.setTitle("CHAPAGOL");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
