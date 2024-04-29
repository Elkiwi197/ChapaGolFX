package controllers;

import domain.Equipo;
import domain.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Objects;

public class ControladorJugarAmigo {

    private ControladorPrincipal borderPane;

    public GridPane gridPane;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;

    public void setBorderPane(ControladorPrincipal controladorPrincipal) {
        borderPane = controladorPrincipal;
    }

    public void init() {

        cargarCampo();
        cargarJugadores();
        // cargarFotos();
    }


    private void cargarFotos() {
    }

    private void cargarCampo() {
        Pane pane;
        String ruta = "";


        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 15; j++) {

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
                pane.setBackground(fondo);
                gridPane.add(stackPane, i, j);

            }
        }
    }

    private void cargarJugadores() {
        for (int i = 0; i < borderPane.getJuego().getCampo()[0].length; i++) { //22
            for (int j = 0; j < borderPane.getJuego().getCampo().length; j++) { //15
                if (borderPane.getJuego().hayJugadorEn(j, i)) {
                    Pane pane = (Pane) gridPane.getChildren().get(i * 15 + j);
                    StackPane stackPane = new StackPane();
                    Jugador jugador = borderPane.getJuego().devolverJugador(j, i);

                    // Cargar camisetas
                    equipoLocal = borderPane.getJuego().getEquipoLocal();
                    equipoVisitante = borderPane.getJuego().getEquipoVisitante();

                    Circle camiseta = new Circle(10);
                    Text dorsal = new Text(String.valueOf(jugador.getDorsal()));

                    // Pinta las camisetas
                    if (equipoLocal.getColorPrincipal() != equipoVisitante.getColorPrincipal()) { // Si los colores de las camisetas son diferentes
                        if (i <= 10) { // Si es jugador local
                            if (jugador.getClass().getSimpleName().equals("Portero")) {
                                // Si es un portero
                                camiseta.setFill(equipoLocal.getColorTerciario());
                            } else {
                                camiseta.setFill(equipoLocal.getColorPrincipal());
                                // Si es un jugador de campo
                            }
                            // Cargar dorsales
                            dorsal.setFill(equipoLocal.getColorSecundario());
                        } else {
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
                        if (i <= 10) { // Si es jugador local
                            if (jugador.getClass().getSimpleName().equals("Portero")) {
                                // Si es un portero
                                camiseta.setFill(equipoLocal.getColorTerciario());
                            } else {
                                camiseta.setFill(equipoLocal.getColorPrincipal());
                                // Si es un jugador de campo
                            }
                            // Cargar dorsales
                            dorsal.setFill(equipoLocal.getColorSecundario());
                        } else {
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
                    double centroX = (pane.getWidth() / 2);
                    double centroY = pane.getHeight() / 2;
                    double posDorsalX = centroX;
                    double posDorsalY = centroY;

                    // Pone el circulo en el lado correspondiente del pane


                    if (dorsal.getFill() == equipoLocal.getColorSecundario()) { // Si es un jugador local
                        StackPane.setAlignment(camiseta, Pos.CENTER_LEFT);
                        StackPane.setAlignment(dorsal, Pos.CENTER);
                        posDorsalX = posDorsalX - 10;
                        StackPane.setMargin(dorsal, new Insets(posDorsalY, 0, 0, posDorsalX));                        posDorsalX = posDorsalX + 10;
                    } else { // Si es un jugador visitante
                        StackPane.setAlignment(camiseta, Pos.CENTER_RIGHT);
                        StackPane.setAlignment(dorsal, Pos.CENTER);
                        posDorsalX = posDorsalX + 10;
                        StackPane.setMargin(dorsal, new Insets(posDorsalY, 0, 0, posDorsalX)); // Ajusta los márgenes para la posición del dorsal
                    }
                    stackPane.getChildren().addAll(camiseta, dorsal);

                    camiseta.setCenterX(centroX);
                    camiseta.setCenterY(centroY);
                    pane.getChildren().add(stackPane);

                    // Mete la camiseta y el dorsal en el pane
                    pane.getChildren().addAll(camiseta, dorsal);
                    // pane.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(2),new Insets(2))));

                }
            }
        }
    }

}