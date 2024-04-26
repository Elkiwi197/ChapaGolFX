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

    public void cargarPantallaUsuario(ActionEvent actionEvent) {
    }

    public void cargarPantallaAdministrador(ActionEvent actionEvent) {
    }

    public void setBorderPane(ControladorPrincipal controladorPrincipal) {
        this.borderPane = controladorPrincipal;
    }
}
