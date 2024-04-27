package controllers;

import domain.Equipo;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.Objects;

public class ControladorJugarAmigo {

    private ControladorPrincipal borderPane;
    private Equipo equipoLocal; //J1
    private Equipo equipoVisitante; //J2
    public GridPane gridPane;

    public void setBorderPane(ControladorPrincipal controladorPrincipal) {
        borderPane = controladorPrincipal;
    }

    public void init() {
        cargarCampo();
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
                            ruta = "/images/verdeClaroCuadrado.jpg";
                        } else if (j == 6) {
                            ruta = "/images/verdeClaroBordesIzquierdaDerecha.jpg";
                        } else if (j == 8) {
                            ruta = "/images/verdeClaroBordesIzquierdaDerecha.jpg";
                        } else {
                            ruta = "/images/verdeClaroBordeIzquierda.jpg";
                        }
                    } else if (i == 21) {// Ultima columna (solo verdes claros)
                        if (j == 3) {
                            ruta = "/images/verdeClaroEsquinaSuperiorDerecha.jpg";
                        } else if (j == 5) {
                            ruta = "/images/verdeClaroBordesIzquierdaDerechaArriba.jpg";
                        } else if (j == 7) {
                            ruta = "/images/verdeClaroBordesIzquierdaDerecha.jpg";
                        } else if (j == 9) {
                            ruta = "/images/verdeClaroBordesIzquierdaDerechaAbajo.jpg";
                        } else if (j == 11) {
                            ruta = "/images/verdeClaroEsquinaInferiorDerecha.jpg";
                        } else {
                            ruta = "/images/verdeClaroBordeDerecha.jpg";
                        }
                    } else if ((i == 1 || i == 19) && (j == 3 || j == 11)) {// Segunda y decimoctava columna
                        if (j == 3) {
                            ruta = "/images/verdeClaroBordeArriba.jpg";
                        } else {
                            ruta = "/images/verdeClaroBordeAbajo.jpg";
                        }
                    } else if ((i == 3 || i == 18) && (j > 2 && j < 12)) {//Cuarta y decimosexta columna
                        if (j == 3) {
                            ruta = "/images/verdeClaroEsquinaSuperiorDerecha.jpg";
                        } else if (j == 11) {
                            ruta = "/images/verdeClaroEsquinaInferiorDerecha.jpg";
                        } else if (i == 3) {
                            ruta = "/images/verdeClaroBordeDerecha.jpg";
                        } else {
                            ruta = "/images/verdeClaroBordeIzquierda.jpg";
                        }
                    } else if (i == 10 || i == 11) { // Centro del campo
                        if (i == 10) {
                            ruta = "/images/verdeClaroBordeDerecha.jpg";
                        } else {
                            ruta = "/images/verdeClaroBordeIzquierda.jpg";
                        }
                    } else if (i == 19 && j == 7) { // Punto de penalti
                        ruta = "/images/verdeClaroCuadrado.jpg";
                    } else {
                        ruta = "/images/verdeClaroSinBordes.jpg";
                    }
                } else { // COLORES OSCUROS
                    if (i == 0) {//Primera columna (solo verdes oscuros)
                        if (j == 3) {
                            ruta = "/images/verdeOscuroEsquinaSuperiorIzquierda.jpg";
                        } else if (j == 11) {
                            ruta = "/images/verdeOscuroEsquinaInferiorIzquierda.jpg";
                        } else if (j == 5) {
                            ruta = "/images/verdeOscuroBordesIzquierdaDerechaArriba.jpg";
                        } else if (j == 7) {
                            ruta = "/images/verdeOscuroBordesIzquierdaDerecha.jpg";
                        } else if (j == 9) {
                            ruta = "/images/verdeOscuroBordesIzquierdaDerechaAbajo.jpg";
                        } else {
                            ruta = "/images/verdeOscuroBordeIzquierda.jpg";
                        }
                    } else if (i == 21) {// Ultima columna (solo verdes claros)
                        if (j == 0 || j == 14) {
                            ruta = "/images/verdeOscuroCuadrado.jpg";
                        } else if (j == 6 || j == 8) {
                            ruta = "/images/verdeOscuroBordesIzquierdaDerecha.jpg";
                        } else {
                            ruta = "/images/verdeOscuroBordeDerecha.jpg";
                        }
                    } else if ((i == 3 || i == 18) && (j > 2 && j < 12)) {//Cuarta y decimosexta columna
                        if (j == 3) {
                            ruta = "/images/verdeOscuroEsquinaSuperiorIzquierda.jpg";
                        } else if (j == 11) {
                            ruta = "/images/verdeOscuroEsquinaInferiorIzquierda.jpg";
                        } else if (i == 3) {
                            ruta = "/images/verdeOscuroBordeDerecha.jpg";
                        } else {
                            ruta = "/images/verdeOscuroBordeIzquierda.jpg";
                        }
                    } else if ((i == 2 || i == 20) && (j == 3 || j == 11)) { // Segunda y decimoctava columna
                        if (j == 3) {
                            ruta = "/images/verdeOscuroBordeArriba.jpg";
                        } else {
                            ruta = "/images/verdeOscuroBordeAbajo.jpg";
                        }
                    }else if (i == 10 || i == 11) { // Centro del campo
                        if (i == 10) {
                            ruta = "/images/verdeOscuroBordeDerecha.jpg";
                        } else {
                            ruta = "/images/verdeOscuroBordeIzquierda.jpg";
                        }
                    }  else if (i == 2 && j == 7) { // Punto de penalti
                        ruta = "/images/verdeOscuroCuadrado.jpg";
                    } else {
                        ruta = "/images/verdeOscuroSinBordes.jpg";
                    }
                }
                if ((j == 0 || j == 14) && (i != 0 && i != 21)) {// Bordes de arriba y abajo
                    if (j == 0) { // Fila de arriba
                        if (i % 2 == 0) {
                            if (i == 10) {
                                ruta = "/images/verdeClaroEsquinaSuperiorDerecha.jpg";
                            } else {
                                ruta = "/images/verdeClaroBordeArriba.jpg";
                            }
                        } else if (i == 11) {
                            ruta = "/images/verdeOscuroEsquinaSuperiorIzquierda.jpg";
                        } else {
                            ruta = "/images/verdeOscuroBordeArriba.jpg";
                        }
                    } else { // Fila de abajo
                        if (i % 2 == 0) {
                            if (i == 10) {
                                ruta = "/images/verdeClaroEsquinaInferiorDerecha.jpg";
                            } else {
                                ruta = "/images/verdeClaroBordeAbajo.jpg";
                            }
                        } else if (i == 11) {
                            ruta = "/images/verdeOscuroEsquinaInferiorIzquierda.jpg";
                        } else {
                            ruta = "/images/verdeOscuroBordeAbajo.jpg";
                        }
                    }
                }
                if (i>=9 && i <= 12){ // Galleta
                    if (i==9){
                        if (j==6){
                            ruta = "/images/verdeOscuroEsquinaSuperiorIzquierda.jpg";
                        } else if (j==7) {
                            ruta = "/images/verdeClaroBordeIzquierda.jpg";
                        } else if (j==8) {
                            ruta = "/images/verdeOscuroEsquinaInferiorIzquierda.jpg";
                        }
                    } else if (i == 10) {
                        if (j == 5){
                            ruta = "/images/verdeOscuroBordesIzquierdaDerechaArriba.jpg";
                        } else if (j == 9) {
                            ruta = "/images/verdeOscuroBordesIzquierdaDerechaAbajo.jpg";
                        }
                    } else if (i==11) {
                        if (j == 5){
                            ruta = "/images/verdeClaroBordesIzquierdaDerechaArriba.jpg";
                        } else if (j == 9) {
                            ruta = "/images/verdeClaroBordesIzquierdaDerechaAbajo.jpg";
                        }
                    } else {
                        if (j==6){
                            ruta = "/images/verdeClaroEsquinaSuperiorDerecha.jpg";
                        } else if (j==7) {
                            ruta = "/images/verdeOscuroBordeDerecha.jpg";
                        } else if (j==8) {
                            ruta = "/images/verdeClaroEsquinaInferiorDerecha.jpg";
                        }
                    }
                }

                Image imagen = new Image(Objects.requireNonNull(getClass().getResourceAsStream(ruta)));
                BackgroundImage imagenFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

                Background fondo = new Background(imagenFondo);
                pane.setBackground(fondo);
                gridPane.add(pane, i, j);

            }
        }
    }


}

