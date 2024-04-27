package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import service.ServiceEquipos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorPrincipal implements Initializable {
    @FXML
    private BorderPane pantallaPrincipal;
    //LOADERS
    private FXMLLoader loaderLogin = new FXMLLoader();
    private FXMLLoader loaderLandingUsuario = new FXMLLoader();
    private FXMLLoader loaderLandingAdministrador = new FXMLLoader();
    //CONTROLADORES
    public ControladorLoginPage controladorLoginPage;
    public ControladorLandingUsuario controladorLandingUsuario;
    public ControladorLandingAdministrador controladorLandingAdministrador;
    //PANES
    @FXML
    private AnchorPane loginAnchorPane;
    @FXML
    private AnchorPane landingUsuarioAnchorPane;
    @FXML
    private AnchorPane landingAdministradorAnchorPane;
    //CLASES DE LOGICA
    ServiceEquipos serviceEquipos = new ServiceEquipos();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        serviceEquipos.init();
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

    public void cargarLandingUsuario() {
        try{
            if (landingUsuarioAnchorPane == null){
             landingUsuarioAnchorPane = loaderLandingUsuario.load(getClass().getResourceAsStream("/fxml/landing_usuario.fxml"));
             controladorLandingUsuario = loaderLandingUsuario.getController();
             controladorLandingUsuario.setBorderPane(this);
            }
            pantallaPrincipal.setCenter(landingUsuarioAnchorPane);
        } catch (IOException e){
            System.out.println("Error al cargar landing usuario");
        }
    }

    public void cargarLandingAdministrador() {
        try{
            if (landingAdministradorAnchorPane == null){
                landingAdministradorAnchorPane = loaderLandingAdministrador.load(getClass().getResourceAsStream("/fxml/landing_administrador.fxml"));
                controladorLandingAdministrador = loaderLandingAdministrador.getController();
                controladorLandingAdministrador.setBorderPane(this);
            }
            pantallaPrincipal.setCenter(landingAdministradorAnchorPane);
        } catch (IOException e){
            System.out.println("Error al cargar landing administrador");
        }
    }
}
