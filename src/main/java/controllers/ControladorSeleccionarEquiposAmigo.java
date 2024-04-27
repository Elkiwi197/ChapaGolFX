package controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import service.ServiceEquipos;

import java.util.List;

public class ControladorSeleccionarEquiposAmigo {
    public Button botonJugarAmigo;
    public Label labelEligeJ1;
    public Label labelEligeJ2;
    private ControladorPrincipal borderPane;
    public ChoiceBox selectorEquipoJ1 = new ChoiceBox<>();
    public ChoiceBox selectorEquipoJ2 = new ChoiceBox<>();

    public void init(){
        cargarValoresChoiceBox();
    }

    private void cargarValoresChoiceBox() {
        ObservableList<String> equipos = borderPane.devolverListaEquipos();
        selectorEquipoJ1.getItems().setAll(equipos);
        selectorEquipoJ2.getItems().setAll(equipos);
    }

    public void cargarJugarAmigo(ActionEvent actionEvent) {
        borderPane.cargarJugarAmigo((String) selectorEquipoJ1.getValue(), (String) selectorEquipoJ2.getValue());
    }

    public void setBorderPane(ControladorPrincipal controladorPrincipal) {
        borderPane = controladorPrincipal;
    }
}
