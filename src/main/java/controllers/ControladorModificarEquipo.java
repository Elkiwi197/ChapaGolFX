package controllers;

import common.Configuration;
import domain.Equipo;
import domain.Jugador;
import domain.Portero;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
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
    public Button botonCambiarAlineacion;
    public Label labelNombre;
    public Label labelDorsal;
    public Label labelPosicion;
    public TextField inputNombre;
    public TextField inputPosicion;
    public Label labelPace;
    public Label labelShot;
    public Label labelPass;
    public Label labelDribling;
    public Label labelDefense;
    public Label labelPhysique;
    public Pane paneEstadisticasPortero;
    public Label labelDiving;
    public Label labelHandling;
    public Label labelKicking;
    public Label labelSpeed;
    public Label labelReflexes;
    public Label labelPositioning;
    public TextField inputDiving;
    public TextField inputHandling;
    public TextField inputKicking;
    public TextField inputReflexes;
    public TextField inputSpeed;
    public TextField inputPositioning;
    public TextField inputDorsal;
    public TextField inputPace;
    public TextField inputShot;
    public TextField inputPass;
    public TextField inputPhysique;
    public TextField inputDefense;
    public TextField inputDribling;
    public Pane paneEstadisticasJugador;
    private ControladorPrincipal borderPane;

    // Clases de lógica
    StackPane[] arrayTitulares = {stackPaneJugador0, stackPaneJugador1, stackPaneJugador2, stackPaneJugador3, stackPaneJugador4, stackPaneJugador5, stackPaneJugador6, stackPaneJugador7, stackPaneJugador8, stackPaneJugador9, stackPaneJugador10};

    Jugador jugadorSeleccionado;

    public void setBorderPane(ControladorPrincipal controladorPrincipal) {
        borderPane = controladorPrincipal;
    }

    public void init() {
        cargarPaneCampo();
        cargarSelectores();
        cargarListaJugadores();
        cargarTitulares();
        cargarEventListeners();
        paneEstadisticasJugador.setVisible(false);
    }

    private void cargarPaneCampo() {
        Configuration configuration = new Configuration();
        Image imagen = new Image(Objects.requireNonNull(getClass().getResourceAsStream(configuration.devolverRuta("rutaCampoModificarEquipo"))));
        BackgroundImage imagenFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
        paneCampo.setBackground(new Background(imagenFondo));
        paneCampo.layout();

    }

    private void cargarSelectores() {
        cargarSelectorEquipo();
        cargarSelectorAlineacion();
    }

    private void cargarSelectorAlineacion() {
        ObservableList<String> alineaciones = FXCollections.observableArrayList();

        alineaciones.add("4-4-2");
        alineaciones.add("4-3-3");
        selectorAlineacion.getItems().setAll(alineaciones);

        if (selectorEquipo.getValue() != null && borderPane.devolverEquipo(selectorEquipo.getValue().toString()).getAlineacion().equals("4-4-2")) {
            selectorAlineacion.getSelectionModel().selectFirst();
        } else if (selectorEquipo.getValue() != null && borderPane.devolverEquipo(selectorEquipo.getValue().toString()).getAlineacion().equals("4-3-3")) {
            selectorAlineacion.getSelectionModel().selectLast();
        }
    }

    private void cargarSelectorEquipo() {
        ObservableList<String> equipos = borderPane.devolverListaEquipos();
        selectorEquipo.getItems().setAll(equipos);
        selectorEquipo.getSelectionModel().selectFirst();
    }

    private void cargarListaJugadores() {
        listaPlantilla.getItems().clear();
        TreeSet<Jugador> jugadores = borderPane.devolverJugadoresEquipo(selectorEquipo.getValue().toString());
        ObservableList<String> jugadoresObservables = FXCollections.observableArrayList();
        jugadores.forEach(p -> jugadoresObservables.add(p.getPosicion() + " " + p.getNombre()));
        listaPlantilla.getItems().setAll(jugadoresObservables);
    }

    private StackPane crearTitularVacio(Equipo equipo) {
        StackPane jugador = new StackPane();
        Circle camiseta = new Circle(30, Color.BLACK);
        Text dorsal = new Text("0");
        Text nombre = new Text("Espacio libre");

        dorsal.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        nombre.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        dorsal.setFill(Color.WHITE);
        nombre.setFill(Color.BLACK);


        StackPane.setMargin(nombre, new Insets(100, 0, 0, 0)); // margen superior, derecha, inferior, izquierda
        StackPane.setAlignment(camiseta, Pos.CENTER);
        StackPane.setAlignment(dorsal, Pos.CENTER);
        StackPane.setAlignment(nombre, Pos.CENTER);
        jugador.setAlignment(Pos.CENTER);

        jugador.getChildren().addAll(camiseta, dorsal, nombre);


        return jugador;
    }

    private void colocarChapasTitulares() {
        Equipo equipo = borderPane.devolverEquipo(selectorEquipo.getValue().toString());
        equipo.setAlineacion(selectorAlineacion.getSelectionModel().getSelectedItem().toString());

        if (equipo.getAlineacion().equals("4-4-2")) { // Si la alineacion es 4-4-2
            arrayTitulares[0].setLayoutX(172);
            arrayTitulares[0].setLayoutY(477);

            arrayTitulares[1].setLayoutX(25);
            arrayTitulares[1].setLayoutY(358);

            arrayTitulares[2].setLayoutX(125);
            arrayTitulares[2].setLayoutY(358);

            arrayTitulares[3].setLayoutX(224);
            arrayTitulares[3].setLayoutY(358);

            arrayTitulares[4].setLayoutX(322);
            arrayTitulares[4].setLayoutY(358);

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
            arrayTitulares[0].setLayoutX(172);
            arrayTitulares[0].setLayoutY(477);

            arrayTitulares[1].setLayoutX(25);
            arrayTitulares[1].setLayoutY(358);

            arrayTitulares[2].setLayoutX(125);
            arrayTitulares[2].setLayoutY(358);

            arrayTitulares[3].setLayoutX(224);
            arrayTitulares[3].setLayoutY(358);

            arrayTitulares[4].setLayoutX(322);
            arrayTitulares[4].setLayoutY(358);

            arrayTitulares[5].setLayoutX(47);
            arrayTitulares[5].setLayoutY(218);

            arrayTitulares[6].setLayoutX(172);
            arrayTitulares[6].setLayoutY(218);

            arrayTitulares[7].setLayoutX(294);
            arrayTitulares[7].setLayoutY(218);

            arrayTitulares[8].setLayoutX(47);
            arrayTitulares[8].setLayoutY(52);

            arrayTitulares[9].setLayoutX(172);
            arrayTitulares[9].setLayoutY(52);

            arrayTitulares[10].setLayoutX(294);
            arrayTitulares[10].setLayoutY(52);
        }
    }

    private void cargarTitulares() {
        Equipo equipo = borderPane.devolverEquipo(selectorEquipo.getValue().toString());
        for (int i = 0; i < equipo.getTitulares().length; i++) {
            if (equipo.getTitulares()[i] != null) {
                paneCampo.getChildren().remove(arrayTitulares[i]);
                arrayTitulares[i] = crearStackPaneTitular(equipo.getTitulares()[i]);
                paneCampo.getChildren().add(arrayTitulares[i]);
            } else {
                paneCampo.getChildren().remove(arrayTitulares[i]);
                arrayTitulares[i] = crearTitularVacio(equipo);
                paneCampo.getChildren().add(arrayTitulares[i]);
            }
        }
        colocarChapasTitulares();
        cargarEventListeners();
    }

    private StackPane crearStackPaneTitular(Jugador jugador) {
        Equipo equipo = borderPane.devolverEquipo(selectorEquipo.getValue().toString());
        StackPane chapa = new StackPane();
        Circle camiseta = new Circle(30);
        Text dorsal = new Text(String.valueOf(jugador.getDorsal()));
        Text nombre = new Text(jugador.getNombre().replace(' ', '\n'));

        if (jugador.getClass().getSimpleName().equals("Portero")) {
            camiseta.setFill(equipo.getColorTerciario());
        } else {
            camiseta.setFill(equipo.getColorPrincipal());
        }
        dorsal.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        nombre.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        dorsal.setFill(equipo.getColorSecundario());
        nombre.setTextAlignment(TextAlignment.CENTER);
        nombre.setFill(Color.BLACK);


        StackPane.setMargin(nombre, new Insets(100, 0, 0, 0)); // margen superior, derecha, inferior, izquierda
        StackPane.setAlignment(camiseta, Pos.CENTER);
        StackPane.setAlignment(dorsal, Pos.CENTER);
        StackPane.setAlignment(nombre, Pos.CENTER);
        chapa.setAlignment(Pos.CENTER);

        chapa.getChildren().addAll(camiseta, dorsal, nombre);

        return chapa;
    }

    private void cargarEventListeners() {
        listaPlantilla.setOnMouseClicked(evento -> {
            String jugador = listaPlantilla.getSelectionModel().getSelectedItem().toString().substring(3);
            System.out.println(jugador);
            jugadorSeleccionado = borderPane.serviceEquipos.devolverJugador(jugador, selectorEquipo.getValue().toString());
            cargarEstadisticasJugador(jugadorSeleccionado);
            paneEstadisticasJugador.setVisible(true);
        });
        selectorEquipo.setOnAction(evento -> {
            Equipo equipo = borderPane.devolverEquipo(selectorEquipo.getValue().toString());
            jugadorSeleccionado = null;
            cargarListaJugadores();
            actualizarSelectorAlineacion(equipo);
            cargarTitulares();
        });
        selectorAlineacion.setOnAction(evento -> {
            Equipo equipo = borderPane.devolverEquipo(selectorEquipo.getValue().toString());
            equipo.setAlineacion(selectorAlineacion.getSelectionModel().getSelectedItem().toString());
            System.out.println(selectorAlineacion.getSelectionModel().getSelectedItem().toString());
            cargarTitulares();
        });
        for (int i = 0; i < arrayTitulares.length; i++) {
            int pos = i;
            arrayTitulares[i].setOnMouseClicked(evento -> {
                boolean repetido = false;
                System.out.println("Titular clicado: " + pos);

                if (jugadorSeleccionado != null) {
                    for (int j = 0; j < borderPane.serviceEquipos.devolverEquipo(selectorEquipo.getValue().toString()).getTitulares().length; j++) {
                        if (borderPane.serviceEquipos.devolverEquipo(selectorEquipo.getValue().toString()).getTitulares()[j] != null) {
                            if (borderPane.serviceEquipos.devolverEquipo(selectorEquipo.getValue().toString()).getTitulares()[j].equals(jugadorSeleccionado)) {
                                repetido = true;
                            }
                        }
                    }
                    if (!repetido) {
                        borderPane.serviceEquipos.devolverEquipo(selectorEquipo.getValue().toString()).getTitulares()[pos] = jugadorSeleccionado;
                    }
                }
                cargarTitulares();
                jugadorSeleccionado = null;
            });
        }
    }

    private void cargarEstadisticasJugador(Jugador jugadorSeleccionado) {
        inputNombre.setText(jugadorSeleccionado.getNombre());
        inputDorsal.setText(String.valueOf(jugadorSeleccionado.getDorsal()));
        inputPosicion.setText(jugadorSeleccionado.getPosicion());

        inputPace.setText(String.valueOf(jugadorSeleccionado.getPac()));
        inputShot.setText(String.valueOf(jugadorSeleccionado.getSho()));
        inputPass.setText(String.valueOf(jugadorSeleccionado.getPas()));
        inputDribling.setText(String.valueOf(jugadorSeleccionado.getDri()));
        inputDefense.setText(String.valueOf(jugadorSeleccionado.getDef()));
        inputPhysique.setText(String.valueOf(jugadorSeleccionado.getPhy()));
        if (jugadorSeleccionado.getClass().getSimpleName().equals("Portero")) {
            inputDiving.setText(String.valueOf(((Portero) jugadorSeleccionado).getDiv()));
            inputHandling.setText(String.valueOf(((Portero) jugadorSeleccionado).getHan()));
            inputKicking.setText(String.valueOf(((Portero) jugadorSeleccionado).getKic()));
            inputReflexes.setText(String.valueOf(((Portero) jugadorSeleccionado).getRef()));
            inputSpeed.setText(String.valueOf(((Portero) jugadorSeleccionado).getSpd()));
            inputPositioning.setText(String.valueOf(((Portero) jugadorSeleccionado).getPos()));
            paneEstadisticasPortero.setVisible(true);
        } else {
            paneEstadisticasPortero.setVisible(false);
        }

    }


    private void actualizarSelectorAlineacion(Equipo equipo) {
        if (equipo.getAlineacion().equals("4-4-2")) {
            selectorAlineacion.setValue("4-4-2");
        } else if (equipo.getAlineacion().equals("4-3-3")) {
            selectorAlineacion.setValue("4-3-3");
        }
    }

    public void cargarLandingUsuario(ActionEvent actionEvent) {
        borderPane.cargarLandingUsuario();
    }
}
