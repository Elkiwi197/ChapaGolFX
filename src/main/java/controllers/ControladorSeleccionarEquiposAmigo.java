package controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lombok.Setter;
import service.ServiceEquipos;

import java.util.Collections;
import java.util.List;

public class ControladorSeleccionarEquiposAmigo {
    public Button botonJugarAmigo;
    public Label labelEligeJ1;
    public Label labelEligeJ2;
    @Setter
    private ControladorPrincipal borderPane;
    public ChoiceBox selectorEquipoJ1 = new ChoiceBox<>();
    public ChoiceBox selectorEquipoJ2 = new ChoiceBox<>();

    public void init(){
        cargarValoresChoiceBox();
    }

    private void cargarValoresChoiceBox() {
        ObservableList<String> equipos = borderPane.devolverListaEquiposJugables();
        selectorEquipoJ1.getItems().setAll(equipos);
        selectorEquipoJ2.getItems().setAll(equipos);


    }

    public void cargarJugarAmigo(ActionEvent actionEvent) {
        borderPane.cargarJugarAmigo(selectorEquipoJ1.getValue().toString(), selectorEquipoJ2.getValue().toString());
    }

}
