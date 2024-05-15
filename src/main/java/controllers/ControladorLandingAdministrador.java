package controllers;

import common.SpinnerValoresExcluidos;
import domain.Equipo;
import domain.Jugador;
import domain.Portero;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ControladorLandingAdministrador {
    private ControladorPrincipal borderPane;
    public ListView listaJugadores;
    public Pane paneMoverJugador;
    public Pane paneModificarJugador;
    public Pane paneEstadisticasPortero;
    public Button botonMoverJugador;
    public Button botonGuardarCambios;
    public Button botonSalirAlogin;
    public Button botonModificarJugador;
    public Button botonMoverJugadorEquipo;
    public Button botonEliminarJugador;
    public ChoiceBox selectorEquipo;
    public ChoiceBox selectorEquipoMoverJugador;
    public TextField inputNombre;
    public TextField inputPosicion;
    public Label labelNombre;
    public Label labelDorsal;
    public Label labelPosicion;

    public Label labelPace;
    public Label labelShot;
    public Label labelPass;
    public Label labelDribling;
    public Label labelDefense;
    public Label labelPhysique;
    public Label labelDiving;
    public Label labelHandling;
    public Label labelKicking;
    public Label labelSpeed;
    public Label labelReflexes;
    public Label labelPositioning;
    public Spinner<Integer> spinnerDorsal;
    public Spinner<Integer> spinnerPace;
    public Spinner<Integer> spinnerShot;
    public Spinner<Integer> spinnerPass;
    public Spinner<Integer> spinnerDribling;
    public Spinner<Integer> spinnerDefense;
    public Spinner<Integer> spinnerPhysique;
    public Spinner<Integer> spinnerDiving;
    public Spinner<Integer> spinnerReflexes;
    public Spinner<Integer> spinnerHandling;
    public Spinner<Integer> spinnerKicking;
    public Spinner<Integer> spinnerSpeed;
    public Spinner<Integer> spinnerPositioning;


    // Clases de lógica
    private Jugador jugador;
    private Set<Integer> dorsalesRepetidos = new HashSet<>();

    public void setBorderPane(ControladorPrincipal controladorPrincipal) {
        borderPane = controladorPrincipal;
    }


    public void init() {
        cargarSelectorEquipos();
        cargarEventListeners();
        actualizarSpinners();
        ocultarPanes();

    }

    private void actualizarSpinners() {
        dorsalesRepetidos.clear();
        Equipo equipoSeleccionado = borderPane.serviceEquipos.devolverEquipo(selectorEquipo.getValue().toString());
        equipoSeleccionado.getPlantilla().forEach(j -> dorsalesRepetidos.add(j.getDorsal()));

        spinnerDorsal.setValueFactory(new SpinnerValoresExcluidos(0, 99, 0, dorsalesRepetidos));
        spinnerPace.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0));
        spinnerShot.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0));
        spinnerPass.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0));
        spinnerDribling.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0));
        spinnerDefense.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0));
        spinnerPhysique.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0));
        spinnerDiving.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0));
        spinnerReflexes.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0));
        spinnerHandling.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0));
        spinnerKicking.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0));
        spinnerSpeed.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0));
        spinnerPositioning.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0));

    }


    private void ocultarPanes() {
        paneMoverJugador.setVisible(false);
        paneEstadisticasPortero.setVisible(false);
        paneModificarJugador.setVisible(false);
    }

    private void cargarSelectorEquipos() {
        ObservableList<String> equipos = borderPane.devolverListaEquipos(); // Cojo los equipos
        selectorEquipo.getItems().setAll(equipos); // Cargo los equipos en el selector
        selectorEquipoMoverJugador.getItems().setAll(equipos); // Cargo los equipos en el selector de mover jugador
        selectorEquipo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> { // Hago un eventlistener para que cada vez que seleccione un elemento cargue un equipo diferente y cargue todos los equipos menos el seleccionado en el selector de mover de equipo
            selectorEquipoMoverJugador.getItems().clear();
            selectorEquipoMoverJugador.getItems().addAll(equipos);
            selectorEquipoMoverJugador.getSelectionModel().select(1); // Selecciono un elemento para que no se quede vacío, el primero coincide con el otro selector así que cojo el segundo
            selectorEquipoMoverJugador.getItems().remove(newValue);
            cargarJugadoresEquipoSeleccionado((String) newValue);
            actualizarSpinners();
            limpiarCacheJugador();
            ocultarPanes();
        });
        selectorEquipo.getSelectionModel().selectFirst(); // Selecciono el primer elemento para que no se quede vacío
    }

    private void limpiarCacheJugador() {
        jugador = null;
        cargarEstadisticas();
        ocultarPanes();
    }


    private void cargarJugadoresEquipoSeleccionado(String nombreEquipo) {
        TreeSet<Jugador> jugadores = borderPane.devolverJugadoresEquipo(nombreEquipo);
        ObservableList<String> jugadoresObservables = FXCollections.observableArrayList();
        jugadores.forEach(p -> jugadoresObservables.add(p.getDorsal() + " " + p.getNombre()));
        listaJugadores.getItems().setAll(jugadoresObservables);
    }

    private void cargarEventListeners() {
        listaJugadores.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                System.out.println("Seleccionado: " + newValue);
                String nombreJugador = (String) newValue;
                nombreJugador = nombreJugador.replaceAll("[0-9]", "");
                nombreJugador = nombreJugador.substring(1);
                jugador = borderPane.devolverJugador(nombreJugador, selectorEquipo.getValue().toString());
                System.out.println(jugador.toString());
                cargarEstadisticas();
                ocultarPanes();
            }
        });
    }

    private void cargarEstadisticas() {
        if (jugador != null) {
            inputNombre.setText(jugador.getNombre());
            inputPosicion.setText(jugador.getPosicion());
            spinnerDorsal.getValueFactory().setValue(jugador.getDorsal());
            spinnerPace.getValueFactory().setValue(jugador.getPac());
            spinnerShot.getValueFactory().setValue(jugador.getSho());
            spinnerPass.getValueFactory().setValue(jugador.getPas());
            spinnerDribling.getValueFactory().setValue(jugador.getDri());
            spinnerDefense.getValueFactory().setValue(jugador.getDef());
            spinnerPhysique.getValueFactory().setValue(jugador.getPhy());

            if (jugador.getClass().getSimpleName().equals("Portero")) {
                spinnerDiving.getValueFactory().setValue(((Portero) jugador).getDiv());
                spinnerHandling.getValueFactory().setValue(((Portero) jugador).getHan());
                spinnerKicking.getValueFactory().setValue(((Portero) jugador).getKic());
                spinnerReflexes.getValueFactory().setValue(((Portero) jugador).getRef());
                spinnerSpeed.getValueFactory().setValue(((Portero) jugador).getSpd());
                spinnerPositioning.getValueFactory().setValue(((Portero) jugador).getPos());
                paneEstadisticasPortero.setVisible(true);
            } else {
                paneEstadisticasPortero.setVisible(false);
            }
        }
    }


    public void moverJugador(ActionEvent actionEvent) {
        String equipoInicial = selectorEquipo.getValue().toString();
        String equipoFinal = selectorEquipoMoverJugador.getValue().toString();
        borderPane.cambiarJugadorDeEquipo(equipoInicial, equipoFinal, jugador);
        cargarJugadoresEquipoSeleccionado(selectorEquipo.getValue().toString());
        paneMoverJugador.setVisible(false);
        limpiarCacheJugador();
    }

    public void eliminarJugador() {
        String nombreEquipo = selectorEquipo.getValue().toString();
        borderPane.eliminarJugador(nombreEquipo, jugador);
        cargarJugadoresEquipoSeleccionado(selectorEquipo.getValue().toString());
        limpiarCacheJugador();
    }

    public void mostrarMoverJugador(ActionEvent actionEvent) {
        ocultarPanes();
        if (jugador != null) {
            paneMoverJugador.setVisible(true);
        }
    }

    public void mostrarEstadisticas(ActionEvent actionEvent) {
        ocultarPanes();
        if (jugador != null) {
            paneModificarJugador.setVisible(true);

            if (jugador.getClass().getSimpleName().equals("Portero")) {
                paneEstadisticasPortero.setVisible(true);
            } else {
                paneEstadisticasPortero.setVisible(false);
            }
        }

    }

    public void guardarEstadisticas(ActionEvent actionEvent) {
        jugador.setDorsal(spinnerDorsal.getValue());
        jugador.setNombre(inputNombre.getText());
        jugador.setPosicion(inputPosicion.getText());
        jugador.setPac(spinnerPace.getValue());
        jugador.setSho(spinnerShot.getValue());
        jugador.setPas(spinnerPass.getValue());
        jugador.setDri(spinnerDribling.getValue());
        jugador.setDef(spinnerDefense.getValue());
        jugador.setPhy(spinnerPhysique.getValue());

        if (jugador.getClass().getSimpleName().equals("Portero")) {
            ((Portero) jugador).setDiv(spinnerDiving.getValue());
            ((Portero) jugador).setHan(spinnerHandling.getValue());
            ((Portero) jugador).setKic(spinnerKicking.getValue());
            ((Portero) jugador).setRef(spinnerReflexes.getValue());
            ((Portero) jugador).setSpd(spinnerSpeed.getValue());
            ((Portero) jugador).setPos(spinnerPositioning.getValue());
        }
    }

    public void salirAlogin(ActionEvent actionEvent) {
        borderPane.cargarLogin();
    }
}
