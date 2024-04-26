package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorPrincipal implements Initializable {
    //LOADERS

    private FXMLLoader loaderLogin = new FXMLLoader();
    @FXML
    private BorderPane pantallaPrincipal;
    //CONTROLADORES
    public ControladorLoginPage controladorLoginPage;
    //PANES
    @FXML
    private AnchorPane loginAnchorPane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarLogin ();
    }

    private void cargarLogin() {
        try {
            if (loginAnchorPane == null) {
                loginAnchorPane = loaderLogin.load(getClass().getResourceAsStream("/fxml/login_page.fxml"));
                controladorLoginPage = loaderLogin.getController();
                controladorLoginPage.setBorderPane(this);
            }
            pantallaPrincipal.setCenter(loginAnchorPane);
        } catch (IOException e) {
            System.out.println("fallo al cargar login");
        }
    }
}
