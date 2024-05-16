package controllers;

import domain.Equipo;
import domain.Jugador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Objects;
import java.util.TreeSet;

public class ControladorModificarEquipo {
    public Pane paneCampo;
    public ListView listaPlantilla;
    public Button botonAtras;
    public ChoiceBox selectorAlineacion;
    public ChoiceBox selectorEquipo;
    public StackPane stackPaneJugador0 = new StackPane();
    public StackPane stackPaneJugador1 = new StackPane();
    public StackPane stackPaneJugador2 = new StackPane();
    public StackPane stackPaneJugador3 = new StackPane();
    public StackPane stackPaneJugador4 = new StackPane();
    public StackPane stackPaneJugador5 = new StackPane();
    public StackPane stackPaneJugador6 = new StackPane();
    public StackPane stackPaneJugador7 = new StackPane();
    public StackPane stackPaneJugador8 = new StackPane();
    public StackPane stackPaneJugador9 = new StackPane();
    public StackPane stackPaneJugador10 = new StackPane();
    private ControladorPrincipal borderPane;

    // Clases de lógica
    StackPane[] arrayTitulares = {stackPaneJugador0, stackPaneJugador1, stackPaneJugador2, stackPaneJugador3, stackPaneJugador4, stackPaneJugador5, stackPaneJugador6, stackPaneJugador7, stackPaneJugador8, stackPaneJugador9, stackPaneJugador10};


    public void setBorderPane(ControladorPrincipal controladorPrincipal) {
        borderPane = controladorPrincipal;
    }

    public void init() {
        cargarPaneCampo();
        cargarSelectores();
        cargarListaJugadores();
        cargarPanesTitulares();
        cargarTitulares();
        cargarEventListeners();
    }

    private void cargarPaneCampo() {
        Image imagen = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/campo.jpg")));
        BackgroundImage imagenFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
        paneCampo.setBackground(new Background(imagenFondo));
        paneCampo.layout();

    }

    private void cargarSelectores() {
        ObservableList<String> equipos = borderPane.devolverListaEquipos();
        ObservableList<String> alineaciones = FXCollections.observableArrayList();

        selectorEquipo.getItems().setAll(equipos);
        selectorEquipo.getSelectionModel().selectFirst();
        alineaciones.add("4-4-2");
        alineaciones.add("4-3-3");
        selectorAlineacion.getItems().setAll(alineaciones);

        if (borderPane.devolverEquipo(selectorEquipo.getValue().toString()).getAlineacion().equals("4-4-2")) {
            selectorAlineacion.getSelectionModel().select("4-4-2");
        } else if (borderPane.devolverEquipo(selectorEquipo.getValue().toString()).getAlineacion().equals("4-3-3")) {
            selectorAlineacion.getSelectionModel().select("4-3-3");
        }

    }

    private void cargarListaJugadores() {
        listaPlantilla.getItems().clear();
        TreeSet<Jugador> jugadores = borderPane.devolverJugadoresEquipo(selectorEquipo.getValue().toString());
        ObservableList<String> jugadoresObservables = FXCollections.observableArrayList();
        jugadores.forEach(p -> jugadoresObservables.add(p.getDorsal() + " " + p.getNombre()));
        listaPlantilla.getItems().setAll(jugadoresObservables);
    }

    private void cargarPanesTitulares() {
        Equipo equipo = borderPane.devolverEquipo(selectorEquipo.getValue().toString());
        for (int i = 0; i < arrayTitulares.length; i++) {
            arrayTitulares[i] = crearTitularVacio(equipo);
            paneCampo.getChildren().add(arrayTitulares[i]);
        }
        colocarChapasTitulares();
    }

    private StackPane crearTitularVacio(Equipo equipo) {
        StackPane jugador = new StackPane();
        Circle chapa = new Circle(30, Color.BLACK);
        Text dorsal = new Text("0");
        Text nombre = new Text("Espacio libre");
        double centroX = jugador.getWidth() / 2;
        double centroY = jugador.getHeight() / 2;

        dorsal.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        nombre.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        dorsal.setFill(Color.WHITE);
        nombre.setFill(Color.WHITE);

        chapa.setCenterX(centroX);
        chapa.setCenterY(centroY);

        jugador.getChildren().addAll(chapa, dorsal, nombre);
        return jugador;
    }

    private void colocarChapasTitulares() {
        Equipo equipo = borderPane.devolverEquipo(selectorEquipo.getValue().toString());
        if (equipo.getAlineacion().equals("4-4-2")) { // Si la alineacion es 4-4-2
            arrayTitulares[0].setLayoutX(172);
            arrayTitulares[0].setLayoutY(486);

            arrayTitulares[1].setLayoutX(25);
            arrayTitulares[1].setLayoutY(377);

            arrayTitulares[2].setLayoutX(125);
            arrayTitulares[2].setLayoutY(377);

            arrayTitulares[3].setLayoutX(224);
            arrayTitulares[3].setLayoutY(377);

            arrayTitulares[4].setLayoutX(322);
            arrayTitulares[4].setLayoutY(377);

            arrayTitulares[5].setLayoutX(25);
            arrayTitulares[5].setLayoutY(218);

            arrayTitulares[6].setLayoutX(125);
            arrayTitulares[6].setLayoutY(218);

            arrayTitulares[7].setLayoutX(224);
            arrayTitulares[7].setLayoutY(218);

            arrayTitulares[8].setLayoutX(322);
            arrayTitulares[8].setLayoutY(218);

            arrayTitulares[9].setLayoutX(99);
            arrayTitulares[9].setLayoutY(52);

            arrayTitulares[10].setLayoutX(245);
            arrayTitulares[10].setLayoutY(52);
        } else if (equipo.getAlineacion().equals("4-3-3")) { // Si la alineacion es 4-3-3

        }

    }

    private void cargarTitulares() {

    }

    private void cargarEventListeners() {
    }

    public void cargarLandingUsuario(ActionEvent actionEvent) {
        borderPane.cargarLandingUsuario();
    }
}
