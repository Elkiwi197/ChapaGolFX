package controllers;

import domain.Equipo;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class ControladorLandingUsuario {
    public Button botonModificarEquipo;
    public Label labelClasificacion;
    public TableView tablaClasificacion;
    public Button botonJugarAmigo;
    public TableColumn columnaNombreEquipo;
    public TableColumn columnaPuntosEquipo;
    private ControladorPrincipal borderPane;

    // Clases de lógica
    private Map<String, Integer> equiposOrdenados = new TreeMap<>();

    public void setBorderPane(ControladorPrincipal controladorPrincipal) {
        borderPane = controladorPrincipal;
    }


    public void cargarSeleccionarEquipoAmigo(ActionEvent actionEvent) {
        borderPane.cargarSeleccionarEquipoAmigo();
    }

    public void init() {
        columnaNombreEquipo.setCellValueFactory(new PropertyValueFactory<>("nombreEquipo"));
        columnaPuntosEquipo.setCellValueFactory(new PropertyValueFactory<>("puntosEquipo"));

        actualizarTabla();
    }

    private void actualizarTabla() {
        equiposOrdenados.clear();
        borderPane.devolverListaEquipos().forEach(e ->
                equiposOrdenados.put(e, borderPane.devolverEquipo(e).getPuntos())
        );

    }

    public void cargarModificarEquipo(ActionEvent actionEvent) {
        borderPane.cargarModificarEquipo();
    }
}

class EquipoPuntos {
    private final SimpleStringProperty nombreEquipo;
    private final SimpleIntegerProperty puntosEquipo;

    public EquipoPuntos(String nombreEquipo, int puntosEquipo) {
        this.nombreEquipo = new SimpleStringProperty(nombreEquipo);
        this.puntosEquipo = new SimpleIntegerProperty(puntosEquipo);
    }

    public String getNombreEquipo() {
        return nombreEquipo.get();
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo.set(nombreEquipo);
    }

    public int getPuntosEquipo() {
        return puntosEquipo.get();
    }

    public void setPuntosEquipo(int puntosEquipo) {
        this.puntosEquipo.set(puntosEquipo);
    }
}
