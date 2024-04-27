package controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;

public class ControladorLoginPage {
    public ControladorPrincipal borderPane;
    public Button botonJugar;
    public Button botonAdministrar;
    public PasswordField textoContrasena;
    public PasswordField contrasenaAdmin;

    public void setBorderPane(ControladorPrincipal controladorPrincipal) {
        this.borderPane = controladorPrincipal;
    }

    public void cargarLandingUsuario(ActionEvent actionEvent) {
        borderPane.cargarLandingUsuario();
    }

    public void cargarLandingAdministrador(ActionEvent actionEvent) {
        borderPane.cargarLandingAdministrador();
    }
}
