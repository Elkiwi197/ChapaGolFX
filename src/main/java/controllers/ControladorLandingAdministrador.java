package controllers;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class ControladorLandingAdministrador {
    private ControladorPrincipal borderPane;
    public ChoiceBox selectorEquipo;
    public Button botonModificarJugador;
    public Button botonMoverJugadorEquipo;
    public Button botonEliminarJugador;

    public void setBorderPane(ControladorPrincipal controladorPrincipal) {
        borderPane = controladorPrincipal;
    }
}
