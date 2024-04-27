package controllers;

import domain.Equipo;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ControladorJugarAmigo {
    private ControladorPrincipal borderPane;
    private Equipo equipoLocal; //J1
    private Equipo equipoVisitante; //J2
    public GridPane gridPane;

    public void setBorderPane(ControladorPrincipal controladorPrincipal) {
        borderPane = controladorPrincipal;
    }

    public void init(){
        cargarCampo();
    }

    private void cargarCampo() {
        Pane pane;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 22; j++) {
                pane = new Pane();
                if (j % 2 == 0 && i % 2 == 0 || j % 2 != 0 && i % 2 != 0) {
                       pane.setStyle("-fx-background-color: #684714 ");
                    //pane.setStyle("-fx-background-color: " + codigoColorA + ";");
                } else {
                   // pane.setStyle("-fx-background-color: " + codigoColorB + ";");
                      pane.setStyle("-fx-background-color: #ffe68e");
                }
                gridPane.add(pane, i, j);

            }
        }
    }


}

