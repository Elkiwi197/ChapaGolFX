package controllers;

import domain.ComprobarAcciones;
import domain.Equipo;
import domain.Jugador;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.*;


public class ControladorJugarAmigo {

    public Button botonMover;
    public Button botonPasar;
    public Button botonRegatear;
    public Button botonTirar;
    public Button botonMeterPierna;
    public Label labelPA;
    public Label labelMarcador;
    public Label labelTurno;
    public ImageView porteriaLocal;
    public ImageView porteriaVisitante;
    public AnchorPane pantalla;
    public ImageView comentarista;
    public Label labelComentarista;
    public Label labelGoleadoresLocal;
    public Label labelGoleadoresVisitante;
    private ControladorPrincipal borderPane;

    public GridPane gridPane;
    private Equipo equipoLocal = new Equipo();
    private Equipo equipoVisitante = new Equipo();
    private ImageView balon = new ImageView();

    private int ultimaFilaSeleccionada;
    private int ultimaColumnaSeleccionada;

    private Set<String> casillasIluminadas = new HashSet<>();

    public void setBorderPane(ControladorPrincipal controladorPrincipal) {
        borderPane = controladorPrincipal;
    }

    public void init() {
        pantalla.setStyle("-fx-background-color: #ADADAD");
        labelMarcador.setStyle("-fx-background-color: #4A21C2");
        labelComentarista.setStyle("-fx-background-color: #FFFFFF");
        labelComentarista.setOpacity(0.75);
        labelComentarista.setText("Bienvenidos a este \n" + borderPane.getJuego().getEquipoLocal().getNombre() + " - " + borderPane.getJuego().getEquipoVisitante().getNombre());
        ocultarOpciones();
        cargarEquipos();
        cargarCampo();
        cargarJugadores();
        actualizarAvisos();
        borderPane.getJuego().setPA(5);


        cargarFotos();
    }

    private void cargarFotos() {
        Image imageBalon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/balon.png")));
        Image fotoPorteriaLocal = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/porteriaLocal.jpg")));
        Image fotoPorteriaVisitante = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/porteriaVisitante.jpg")));
        Image fotoComentarista = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/comentaristas/Maldini.jpg")));

        balon.setImage(imageBalon);
        balon.setFitHeight(10);
        balon.setFitWidth(10);
        porteriaLocal.setImage(fotoPorteriaLocal);
        porteriaVisitante.setImage(fotoPorteriaVisitante);
        comentarista.setImage(fotoComentarista);


    }

    private void cargarEquipos() {
        //Preguntar a Gema si se puede hacer de otra forma mejor
        //Preguntar a Gema si esto crea objetos nuevos con nuevas direcciones de RAM

        equipoLocal.setNombre(borderPane.getJuego().getEquipoLocal().getNombre());
        equipoLocal.setTitulares(borderPane.getJuego().getEquipoLocal().getTitulares());
        equipoLocal.setPlantilla(borderPane.getJuego().getEquipoLocal().getPlantilla());
        equipoLocal.setAlineacion(borderPane.getJuego().getEquipoLocal().getAlineacion());
        equipoLocal.setColorPrincipal(borderPane.getJuego().getEquipoLocal().getColorPrincipal());
        equipoLocal.setColorSecundario(borderPane.getJuego().getEquipoLocal().getColorSecundario());
        equipoLocal.setColorTerciario(borderPane.getJuego().getEquipoLocal().getColorTerciario());

        equipoVisitante.setNombre(borderPane.getJuego().getEquipoVisitante().getNombre());
        equipoVisitante.setTitulares(borderPane.getJuego().getEquipoVisitante().getTitulares());
        equipoVisitante.setPlantilla(borderPane.getJuego().getEquipoVisitante().getPlantilla());
        equipoVisitante.setAlineacion(borderPane.getJuego().getEquipoVisitante().getAlineacion());
        equipoVisitante.setColorPrincipal(borderPane.getJuego().getEquipoVisitante().getColorPrincipal());
        equipoVisitante.setColorSecundario(borderPane.getJuego().getEquipoVisitante().getColorSecundario());
        equipoVisitante.setColorTerciario(borderPane.getJuego().getEquipoVisitante().getColorTerciario());


    }

    private void cargarCampo() {
        Pane pane;
        String ruta = "";


        for (int i = 0; i < borderPane.getJuego().getCampo()[0].length; i++) {
            for (int j = 0; j < borderPane.getJuego().getCampo().length; j++) {

                pane = new Pane();

                if (j % 2 == 0 && i % 2 == 0 || j % 2 != 0 && i % 2 != 0) {// COLORES CLAROS

                    if (i == 0) {// Primera columna (solo verdes claros)
                        if (j == 0 || j == 14) {
                            ruta = "/images/campo/verdeClaroCuadrado.jpg";
                        } else if (j == 6) {
                            ruta = "/images/campo/verdeClaroBordesIzquierdaDerecha.jpg";
                        } else if (j == 8) {
                            ruta = "/images/campo/verdeClaroBordesIzquierdaDerecha.jpg";
                        } else {
                            ruta = "/images/campo/verdeClaroBordeIzquierda.jpg";
                        }
                    } else if (i == 21) {// Ultima columna (solo verdes claros)
                        if (j == 3) {
                            ruta = "/images/campo/verdeClaroEsquinaSuperiorDerecha.jpg";
                        } else if (j == 5) {
                            ruta = "/images/campo/verdeClaroBordesIzquierdaDerechaArriba.jpg";
                        } else if (j == 7) {
                            ruta = "/images/campo/verdeClaroBordesIzquierdaDerecha.jpg";
                        } else if (j == 9) {
                            ruta = "/images/campo/verdeClaroBordesIzquierdaDerechaAbajo.jpg";
                        } else if (j == 11) {
                            ruta = "/images/campo/verdeClaroEsquinaInferiorDerecha.jpg";
                        } else {
                            ruta = "/images/campo/verdeClaroBordeDerecha.jpg";
                        }
                    } else if ((i == 1 || i == 19) && (j == 3 || j == 11)) {// Segunda y decimoctava columna
                        if (j == 3) {
                            ruta = "/images/campo/verdeClaroBordeArriba.jpg";
                        } else {
                            ruta = "/images/campo/verdeClaroBordeAbajo.jpg";
                        }
                    } else if ((i == 3 || i == 18) && (j > 2 && j < 12)) {//Cuarta y decimosexta columna
                        if (j == 3) {
                            ruta = "/images/campo/verdeClaroEsquinaSuperiorDerecha.jpg";
                        } else if (j == 11) {
                            ruta = "/images/campo/verdeClaroEsquinaInferiorDerecha.jpg";
                        } else if (i == 3) {
                            ruta = "/images/campo/verdeClaroBordeDerecha.jpg";
                        } else {
                            ruta = "/images/campo/verdeClaroBordeIzquierda.jpg";
                        }
                    } else if (i == 5 || i == 16 || i == 17) { // Medias lunas
                        if (i == 5) {
                            if (j == 5) {
                                ruta = "/images/campo/verdeClaroEsquinaInferiorIzquierda.jpg";
                            } else if (j == 7) {
                                ruta = "/images/campo/verdeClaroBordeDerecha.jpg";
                            } else if (j == 9) {
                                ruta = "/images/campo/verdeClaroEsquinaSuperiorIzquierda.jpg";
                            } else {
                                ruta = "/images/campo/verdeClaroSinBordes.jpg";
                            }
                        } else if (i == 16) {
                            if (j == 6 || j == 8) {
                                ruta = "/images/campo/verdeClaroBordeIzquierda.jpg";
                            } else {
                                ruta = "/images/campo/verdeClaroSinBordes.jpg";
                            }
                        } else if (i == 17) {
                            if (j == 5) {
                                ruta = "/images/campo/verdeClaroBordeArriba.jpg";
                            } else if (j == 9) {
                                ruta = "/images/campo/verdeClaroBordeAbajo.jpg";
                            } else {
                                ruta = "/images/campo/verdeClaroSinBordes.jpg";
                            }
                        }
                    } else if (i == 10 || i == 11) { // Centro del campo
                        if (i == 10) {
                            ruta = "/images/campo/verdeClaroBordeDerecha.jpg";
                        } else {
                            ruta = "/images/campo/verdeClaroBordeIzquierda.jpg";
                        }
                    } else if (i == 19 && j == 7) { // Punto de penalti
                        ruta = "/images/campo/verdeClaroCuadrado.jpg";
                    } else {
                        ruta = "/images/campo/verdeClaroSinBordes.jpg";
                    }
                } else { // COLORES OSCUROS
                    if (i == 0) {//Primera columna (solo verdes oscuros)
                        if (j == 3) {
                            ruta = "/images/campo/verdeOscuroEsquinaSuperiorIzquierda.jpg";
                        } else if (j == 11) {
                            ruta = "/images/campo/verdeOscuroEsquinaInferiorIzquierda.jpg";
                        } else if (j == 5) {
                            ruta = "/images/campo/verdeOscuroBordesIzquierdaDerechaArriba.jpg";
                        } else if (j == 7) {
                            ruta = "/images/campo/verdeOscuroBordesIzquierdaDerecha.jpg";
                        } else if (j == 9) {
                            ruta = "/images/campo/verdeOscuroBordesIzquierdaDerechaAbajo.jpg";
                        } else {
                            ruta = "/images/campo/verdeOscuroBordeIzquierda.jpg";
                        }
                    } else if (i == 21) {// Ultima columna (solo verdes claros)
                        if (j == 0 || j == 14) {
                            ruta = "/images/campo/verdeOscuroCuadrado.jpg";
                        } else if (j == 6 || j == 8) {
                            ruta = "/images/campo/verdeOscuroBordesIzquierdaDerecha.jpg";
                        } else {
                            ruta = "/images/campo/verdeOscuroBordeDerecha.jpg";
                        }
                    } else if ((i == 3 || i == 18) && (j > 2 && j < 12)) {//Cuarta y decimosexta columna
                        if (j == 3) {
                            ruta = "/images/campo/verdeOscuroEsquinaSuperiorIzquierda.jpg";
                        } else if (j == 11) {
                            ruta = "/images/campo/verdeOscuroEsquinaInferiorIzquierda.jpg";
                        } else if (i == 3) {
                            ruta = "/images/campo/verdeOscuroBordeDerecha.jpg";
                        } else {
                            ruta = "/images/campo/verdeOscuroBordeIzquierda.jpg";
                        }
                    } else if ((i == 2 || i == 20) && (j == 3 || j == 11)) { // Segunda y decimoctava columna
                        if (j == 3) {
                            ruta = "/images/campo/verdeOscuroBordeArriba.jpg";
                        } else {
                            ruta = "/images/campo/verdeOscuroBordeAbajo.jpg";
                        }
                    } else if (i == 4 || i == 5 || i == 16) { // Medias lunas
                        if (i == 4) {
                            if (j == 5) {
                                ruta = "/images/campo/verdeOscuroBordeArriba.jpg";
                            } else if (j == 9) {
                                ruta = "/images/campo/verdeOscuroBordeAbajo.jpg";
                            } else {
                                ruta = "/images/campo/verdeOscuroSinBordes.jpg";
                            }
                        } else if (i == 5) {
                            if (j == 6 || j == 8) {
                                ruta = "/images/campo/verdeOscuroBordeDerecha.jpg";
                            } else {
                                ruta = "/images/campo/verdeOscuroSinBordes.jpg";
                            }
                        } else if (i == 16) {
                            if (j == 5) {
                                ruta = "/images/campo/verdeOscuroEsquinaInferiorDerecha.jpg";
                            } else if (j == 7) {
                                ruta = "/images/campo/verdeOscuroBordeIzquierda.jpg";
                            } else if (j == 9) {
                                ruta = "/images/campo/verdeOscuroEsquinaSuperiorDerecha.jpg";
                            } else {
                                ruta = "/images/campo/verdeOscuroSinBordes.jpg";
                            }
                        }
                    } else if (i == 10 || i == 11) { // Centro del campo
                        if (i == 10) {
                            ruta = "/images/campo/verdeOscuroBordeDerecha.jpg";
                        } else {
                            ruta = "/images/campo/verdeOscuroBordeIzquierda.jpg";
                        }
                    } else if (i == 2 && j == 7) { // Punto de penalti
                        ruta = "/images/campo/verdeOscuroCuadrado.jpg";
                    } else {
                        ruta = "/images/campo/verdeOscuroSinBordes.jpg";
                    }
                }
                if ((j == 0 || j == 14) && (i != 0 && i != 21)) {// Bordes de arriba y abajo
                    if (j == 0) { // Fila de arriba
                        if (i % 2 == 0) {
                            if (i == 10) {
                                ruta = "/images/campo/verdeClaroEsquinaSuperiorDerecha.jpg";
                            } else {
                                ruta = "/images/campo/verdeClaroBordeArriba.jpg";
                            }
                        } else if (i == 11) {
                            ruta = "/images/campo/verdeOscuroEsquinaSuperiorIzquierda.jpg";
                        } else {
                            ruta = "/images/campo/verdeOscuroBordeArriba.jpg";
                        }
                    } else { // Fila de abajo
                        if (i % 2 == 0) {
                            if (i == 10) {
                                ruta = "/images/campo/verdeClaroEsquinaInferiorDerecha.jpg";
                            } else {
                                ruta = "/images/campo/verdeClaroBordeAbajo.jpg";
                            }
                        } else if (i == 11) {
                            ruta = "/images/campo/verdeOscuroEsquinaInferiorIzquierda.jpg";
                        } else {
                            ruta = "/images/campo/verdeOscuroBordeAbajo.jpg";
                        }
                    }
                }
                if (i >= 9 && i <= 12) { // Galleta
                    if (i == 9) {
                        if (j == 5) {
                            ruta = "/images/campo/verdeClaroEsquinaInferiorDerecha.jpg";
                        } else if (j == 6) {
                            ruta = "/images/campo/verdeOscuroBordeIzquierda.jpg";
                        } else if (j == 7) {
                            ruta = "/images/campo/verdeClaroBordeIzquierda.jpg";
                        } else if (j == 8) {
                            ruta = "/images/campo/verdeOscuroBordeIzquierda.jpg";
                        } else if (j == 9) {
                            ruta = "/images/campo/verdeClaroEsquinaSuperiorDerecha.jpg";
                        }
                    } else if (i == 10) {
                        if (j == 5) {
                            ruta = "/images/campo/verdeOscuroEsquinaSuperiorDerecha.jpg";
                        } else if (j == 9) {
                            ruta = "/images/campo/verdeOscuroEsquinaInferiorDerecha.jpg";
                        }
                    } else if (i == 11) {
                        if (j == 5) {
                            ruta = "/images/campo/verdeClaroEsquinaSuperiorIzquierda.jpg";
                        } else if (j == 9) {
                            ruta = "/images/campo/verdeClaroEsquinaInferiorIzquierda.jpg";
                        }
                    } else {
                        if (j == 5) {
                            ruta = "/images/campo/verdeOscuroEsquinaInferiorIzquierda.jpg";
                        } else if (j == 6) {
                            ruta = "/images/campo/verdeClaroBordeDerecha.jpg";
                        } else if (j == 7) {
                            ruta = "/images/campo/verdeOscuroBordeDerecha.jpg";
                        } else if (j == 8) {
                            ruta = "/images/campo/verdeClaroBordeDerecha.jpg";
                        } else if (j == 9) {
                            ruta = "/images/campo/verdeOscuroEsquinaSuperiorIzquierda.jpg";
                        }
                    }
                }

                StackPane stackPane = new StackPane(); // Crear un StackPane para combinar el fondo y el círculo del jugador

                Image imagen = new Image(Objects.requireNonNull(getClass().getResourceAsStream(ruta)));
                BackgroundImage imagenFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

                Background fondo = new Background(imagenFondo);
                stackPane.setBackground(fondo);
                stackPane.setId(String.valueOf(i).concat("-").concat(String.valueOf(j)));
                gridPane.add(stackPane, i, j);


                // Añado el event listener para poder seleccionar jugadores
                int fila = j;
                int columna = i;

                stackPane.setOnMouseClicked(e -> {
                    System.out.println("PULSADO: FILA " + fila + "   COLUMNA " + columna);
                    ultimaFilaSeleccionada = fila;
                    ultimaColumnaSeleccionada = columna;
                    mostrarOpciones(fila, columna);
                    ocultarCasillasIluminadas();
                });
            }
        }
    }

    private void cargarJugadores() {
        // Primero vacio el campo
        for (int i = 0; i < borderPane.getJuego().getCampo()[0].length; i++) { //22
            for (int j = 0; j < borderPane.getJuego().getCampo().length; j++) { //15
                if (gridPane.lookup("#" + i + "-" + j) instanceof StackPane) {
                    ((StackPane) gridPane.lookup("#" + i + "-" + j)).getChildren().clear();
                }
            }
        }

        //Luego meto los jugadores
        for (int i = 0; i < borderPane.getJuego().getCampo()[0].length; i++) { //22
            for (int j = 0; j < borderPane.getJuego().getCampo().length; j++) { //15
                if (ComprobarAcciones.hayJugadorEn(borderPane.getJuego().getCampo(), j, i)) {
                    Pane pane = (Pane) gridPane.getChildren().get(i * 15 + j);
                    StackPane stackPane = new StackPane();
                    Jugador jugador = borderPane.getJuego().devolverJugador(j, i);

                    // Cargar camisetas


                    Circle camiseta = new Circle(10);
                    Text dorsal = new Text(String.valueOf(jugador.getDorsal()));

                    // Pinta las camisetas
                    if (equipoLocal.getColorPrincipal() != equipoVisitante.getColorPrincipal()) { // Si los colores de las camisetas son diferentes
                        if (ComprobarAcciones.esJugadorLocal(borderPane.getJuego(), j, i)) { // Si es jugador local
                            if (jugador.getClass().getSimpleName().equals("Portero")) {
                                // Si es un portero
                                camiseta.setFill(equipoLocal.getColorTerciario());
                            } else {
                                // Si es un jugador de campo
                                camiseta.setFill(equipoLocal.getColorPrincipal());
                            }
                            // Cargar dorsales
                            dorsal.setFill(equipoLocal.getColorSecundario());
                        } else { // Si es visitante
                            if (jugador.getClass().getSimpleName().equals("Portero")) {
                                // Si es un portero
                                camiseta.setFill(equipoVisitante.getColorTerciario());
                            } else {
                                camiseta.setFill(equipoVisitante.getColorPrincipal());
                                // Si es un jugador de campo
                            }
                            // Cargar dorsales
                            dorsal.setFill(equipoVisitante.getColorSecundario());
                        }
                    } else { // Si los colores de las camisetas son iguales
                        if (ComprobarAcciones.esJugadorLocal(borderPane.getJuego(), j, i)) { // Si es jugador local
                            if (jugador.getClass().getSimpleName().equals("Portero")) {
                                // Si es un portero
                                camiseta.setFill(equipoLocal.getColorTerciario());
                            } else {
                                camiseta.setFill(equipoLocal.getColorPrincipal());
                                // Si es un jugador de campo
                            }
                            // Cargar dorsales
                            dorsal.setFill(equipoLocal.getColorSecundario());
                        } else { // Si es jugador visitante
                            if (jugador.getClass().getSimpleName().equals("Portero")) {
                                // Si es un portero
                                camiseta.setFill(equipoVisitante.getColorTerciario());
                            } else {
                                camiseta.setFill(equipoVisitante.getColorSecundario());
                                // Si es un jugador de campo
                            }
                            // Cargar dorsales
                            dorsal.setFill(equipoVisitante.getColorPrincipal());
                        }
                    }

                    dorsal.setFont(Font.font("Arial", FontWeight.BOLD, 12));

                    // Calcula el centro de la camiseta
                    double centroX = pane.getWidth() / 2;
                    double centroY = pane.getHeight() / 2;
                    double posDorsalX = centroX;


                    // Si el jugador tiene el balon mueve la chapa al lado correspondiente
                    // del pane y le mete el balon en el lado contrario
                    if (jugador.isTieneBalon()) {
                        stackPane.getChildren().addAll(camiseta, dorsal, balon);
                        if (dorsal.getFill() == equipoLocal.getColorSecundario()) { // Si es un jugador local
                            StackPane.setAlignment(camiseta, Pos.CENTER_LEFT);
                            StackPane.setAlignment(dorsal, Pos.CENTER_RIGHT);
                            StackPane.setAlignment(balon, Pos.CENTER_RIGHT);
                            posDorsalX = 20 - dorsal.getLayoutBounds().getWidth() / 2;
                            StackPane.setMargin(dorsal, new Insets(0, posDorsalX, 0, 0));
                        } else { // Si es un jugador visitante
                            StackPane.setAlignment(camiseta, Pos.CENTER_RIGHT);
                            StackPane.setAlignment(dorsal, Pos.CENTER_LEFT);
                            StackPane.setAlignment(balon, Pos.CENTER_LEFT);
                            posDorsalX = 20 - dorsal.getLayoutBounds().getWidth() / 2;
                            StackPane.setMargin(dorsal, new Insets(0, 0, 0, posDorsalX));
                        }
                    } else { // Si el jugador no tiene el balon carga la chapa y ya
                        stackPane.getChildren().addAll(camiseta, dorsal);
                    }


                    camiseta.setCenterX(centroX);
                    camiseta.setCenterY(centroY);


                    pane.getChildren().add(stackPane);
                }
            }
        }
    }


    /**
     * Muestra los botones en funcion de las acciones que puede hacer el jugador seleccionado
     *
     * @param fila    Fila donde se encuentra el jugador seleccionado
     * @param columna Columna donde se encuentra el jugador seleccionado
     */
    public void mostrarOpciones(int fila, int columna) {
        ocultarOpciones();
        //ocultarCasillasIluminadas();
        actualizarAvisos();
        if (borderPane.getJuego().getCampo()[fila][columna] != null) {
            if (ComprobarAcciones.esTurnoDeJugador(borderPane.getJuego(), fila, columna)) {
                if (ComprobarAcciones.hayPosibleMovimiento(borderPane.getJuego().getCampo(), fila, columna)) {
                    botonMover.setVisible(true);
                }
                if (borderPane.getJuego().devolverJugador(fila, columna).isTieneBalon()) { // Si tiene el balon muestra pasar, tirar y regatear
                    botonPasar.setVisible(true);
                    botonTirar.setVisible(true);
                }
                if (ComprobarAcciones.hayRivalAlrededor(borderPane.getJuego(), fila, columna, borderPane.getJuego().isTurno())) {
                    if (borderPane.getJuego().devolverJugador(fila, columna).isTieneBalon()) { // Si tiene el balon muestra pasar, tirar y regatear
                        botonRegatear.setVisible(true);
                    } else {
                        botonMeterPierna.setVisible(true);
                    }
                }
            }
        }

    }


    /**
     * Oculta todos los botones
     */
    private void ocultarOpciones() {
        botonMover.setVisible(false);
        botonPasar.setVisible(false);
        botonTirar.setVisible(false);
        botonRegatear.setVisible(false);
        botonMeterPierna.setVisible(false);
    }

    public void moverJugador(ActionEvent actionEvent) {
        iluminarPosiblesMovimientos();
    }

    public void iluminarPosiblesMovimientos() {
        ocultarCasillasIluminadas();
        int fila = ultimaFilaSeleccionada;
        int columna = ultimaColumnaSeleccionada;
        for (int i = ultimaFilaSeleccionada - 1; i <= ultimaFilaSeleccionada + 1; i++) {
            for (int j = ultimaColumnaSeleccionada - 1; j <= ultimaColumnaSeleccionada + 1; j++) {
                if (i >= 0 && i <= 14 && j >= 0 && j <= 21) { // Evito el OutOfBoundsException


                    // Creacion del cuadrado que recibe el evento

                    Rectangle cuadradoGuia = crearCasillaIluminada();
                    int columnaIluminada = j;
                    int filaIluminada = i;

                    // Creacion del evento
                    cuadradoGuia.setOnMouseClicked(e -> {
                        System.out.println("PULSADO CASILLA ILUMINADA: FILA " + filaIluminada + "   COLUMNA " + columnaIluminada);
                        borderPane.getJuego().moverJugador(ultimaFilaSeleccionada, ultimaColumnaSeleccionada, filaIluminada, columnaIluminada);
                        //cargarJugadores();
                        moverJugadorConsola(ultimaFilaSeleccionada, ultimaColumnaSeleccionada, filaIluminada, columnaIluminada);
                        consumirPA();

                    });

                    // Meto el cuadrado en el StackPane correspondiente
                    if (!ComprobarAcciones.hayJugadorEn(borderPane.getJuego().getCampo(), i, j)) {
                        devolverStackPane(i, j).getChildren().add(cuadradoGuia);
                        casillasIluminadas.add(i + "-" + j);

                    }
                }
            }
        }
    }

    private void moverJugadorConsola(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        StackPane casillaInicial = devolverStackPane(filaInicial, columnaInicial);
        StackPane casillaFinal = devolverStackPane(filaFinal, columnaFinal);

        casillaFinal.getChildren().addAll(casillaInicial.getChildren());
        casillaInicial.getChildren().clear();

        ocultarCasillasIluminadas();
    }

    public void pasarBalon(ActionEvent actionEvent) {
        iluminarCompaneros();
    }

    private void iluminarCompaneros() {
        ocultarCasillasIluminadas();
        for (int i = 0; i < borderPane.getJuego().getCampo().length; i++) {
            for (int j = 0; j < borderPane.getJuego().getCampo()[0].length; j++) {
                if (ComprobarAcciones.hayJugadorEn(borderPane.juego.getCampo(), i, j)) {
                    if (!ComprobarAcciones.hayRivalEn(borderPane.getJuego(), i, j)) {

                        // Creacion del cuadrado que recibe el evento
                        Rectangle casillaIluminada = crearCasillaIluminada();

                        int filaIluminada = i;
                        int columnaIluminada = j;

                        // Creacion del evento
                        casillaIluminada.setOnMouseClicked(e -> {
                            System.out.println("PULSADO PASE: FILA " + filaIluminada + "   COLUMNA " + columnaIluminada);

                            labelComentarista.setText(borderPane.getJuego().pasarBalon(ultimaFilaSeleccionada, ultimaColumnaSeleccionada, filaIluminada, columnaIluminada));

                            ocultarCasillasIluminadas();
                            cargarJugadores();
                            borderPane.getJuego().comprobarTurno();
                        });


                        devolverStackPane(i, j).getChildren().add(casillaIluminada);
                        casillasIluminadas.add(i + "-" + j);

                    }
                }
            }
        }
    }

    public void regatear(ActionEvent actionEvent) {
        iluminarRivalesRegateables();
    }

    private void iluminarRivalesRegateables() {
        for (int i = ultimaFilaSeleccionada - 1; i <= ultimaFilaSeleccionada + 1; i++) {
            for (int j = ultimaColumnaSeleccionada - 1; j <= ultimaColumnaSeleccionada + 1; j++) {
                if (i >= 0 && i <= 14 && j >= 0 && j <= 21) { // Evito el OutOfBoundsException
                    if (borderPane.getJuego().getCampo()[i][j] != null) {
                        if (ComprobarAcciones.hayRivalEn(borderPane.getJuego(), i, j)) {
                            //Creo la casilla iluminada y la añado
                            Rectangle casillaIluminada = crearCasillaIluminada();
                            casillaIluminada.setId(i + "-" + j);
                            StackPane casillaRival = (StackPane) gridPane.lookup("#" + j + "-" + i);

                            int filaIluminada = i;
                            int columnaIluminada = j;

                            // Creacion del evento
                            casillaIluminada.setOnMouseClicked(e -> {
                                System.out.println("PULSADO REGATE: FILA " + filaIluminada + "   COLUMNA " + columnaIluminada);

                                labelComentarista.setText(borderPane.getJuego().regatear(ultimaFilaSeleccionada, ultimaColumnaSeleccionada, filaIluminada, columnaIluminada));

                                ocultarCasillasIluminadas();
                                cargarJugadores();
                                //consumirPA();
                                borderPane.getJuego().comprobarTurno();
                            });

                            devolverStackPane(i, j).getChildren().add(casillaIluminada);
                            casillasIluminadas.add(i + "-" + j);
                        }
                    }
                }
            }
        }
    }

    public void tirarApuerta(ActionEvent actionEvent) {
        int goles = borderPane.getJuego().getGolesLocal() + borderPane.getJuego().getGolesVisitante();
        labelComentarista.setText(borderPane.getJuego().tirarApuerta(ultimaFilaSeleccionada, ultimaColumnaSeleccionada));

        ocultarOpciones();
        actualizarAvisos();
        cargarJugadores();
    }

    public void hacerEntrada(ActionEvent actionEvent) {
        iluminarRivalesEntrables();
    }

    private void iluminarRivalesEntrables() {
        for (int i = ultimaFilaSeleccionada - 1; i <= ultimaFilaSeleccionada + 1; i++) {
            for (int j = ultimaColumnaSeleccionada - 1; j <= ultimaColumnaSeleccionada + 1; j++) {
                if (i >= 0 && i <= 14 && j >= 0 && j <= 21) { // Evito el OutOfBoundsException
                    if (borderPane.getJuego().getCampo()[i][j] != null) {
                        if (ComprobarAcciones.hayRivalEn(borderPane.getJuego(), i, j)) {
                            //Creo la casilla iluminada y la añado
                            Rectangle casillaIluminada = crearCasillaIluminada();
                            casillaIluminada.setId(i + "-" + j);
                            StackPane casillaRival = (StackPane) gridPane.lookup("#" + j + "-" + i);

                            int filaIluminada = i;
                            int columnaIluminada = j;

                            // Creacion del evento
                            casillaIluminada.setOnMouseClicked(e -> {
                                System.out.println("PULSADO ENTRADA: FILA " + filaIluminada + "   COLUMNA " + columnaIluminada);

                                labelComentarista.setText(borderPane.getJuego().hacerEntrada(ultimaFilaSeleccionada, ultimaColumnaSeleccionada, filaIluminada, columnaIluminada));

                                ocultarCasillasIluminadas();
                                cargarJugadores();
                                //consumirPA();
                                borderPane.getJuego().comprobarTurno();
                            });

                            devolverStackPane(i, j).getChildren().add(casillaIluminada);
                            casillasIluminadas.add(i + "-" + j);
                        }
                    }
                }
            }
        }
    }

    /**
     * Quita la iluminacion de las casillas iluminadas
     */
    private void ocultarCasillasIluminadas() {
        casillasIluminadas.forEach(coordenadas -> {
            int fila = Integer.parseInt(coordenadas.split("-")[0]);
            int columna = Integer.parseInt(coordenadas.split("-")[1]);
            StackPane stackPane = (StackPane) devolverStackPane(fila, columna);
            if (stackPane != null) {
                // Elimina los cuadrados rosas de esta celda
                stackPane.getChildren().removeIf(node -> node instanceof Rectangle);
            }
        });

        casillasIluminadas.clear();
    }

    public void actualizarAvisos() {
        labelPA.setText("PA restantes: " + borderPane.getJuego().getPA());
        if (borderPane.getJuego().isTurno()) {
            labelTurno.setText("Turno de " + borderPane.getJuego().getEquipoLocal().getNombre());
        } else {
            labelTurno.setText("Turno de " + borderPane.getJuego().getEquipoVisitante().getNombre());
        }
        labelMarcador.setText(borderPane.getJuego().getEquipoLocal().getNombre() + " " + borderPane.getJuego().getGolesLocal() + " - " + borderPane.getJuego().getGolesVisitante() + " " + borderPane.getJuego().getEquipoVisitante().getNombre());
        labelGoleadoresLocal.setText(borderPane.getJuego().getGoleadoresLocal());
        labelGoleadoresVisitante.setText(borderPane.getJuego().getGoleadoresVisitante());
    }


    public StackPane devolverStackPane(int fila, int columna) {
        return (StackPane) gridPane.lookup("#" + columna + "-" + fila);
    }

    public Rectangle crearCasillaIluminada() {
        Rectangle cuadradoGuia = new Rectangle(30, 30);
        cuadradoGuia.setFill(Color.WHITE);
        cuadradoGuia.setOpacity(0.5);
        return cuadradoGuia;
    }

    private void consumirPA() {
        borderPane.getJuego().setPA(borderPane.getJuego().getPA() - 1);
        borderPane.getJuego().comprobarTurno();
        actualizarAvisos();
    }
}