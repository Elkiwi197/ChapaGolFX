package controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;

public class ControladorLandingUsuario {
    public Button botonJugarLiga;
    public Button botonVerMercado;
    public Button botonModificarEquipo;
    public Label labelClasificacion;
    public TableView tablaClasificacion;
    public Button botonJugarAmigo;
    private ControladorPrincipal borderPane;
    public void setBorderPane(ControladorPrincipal controladorPrincipal) {
        borderPane = controladorPrincipal;
    }


    public void cargarSeleccionarEquipoAmigo(ActionEvent actionEvent) {
        borderPane.cargarSeleccionarEquipoAmigo();
    }
}
