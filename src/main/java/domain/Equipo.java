package domain;

import javafx.scene.paint.Color;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;



@Data

public class Equipo implements Cloneable, Serializable {
    private String nombre;
    private int puntos;
    private String alineacion;
    private Color colorPrincipal;
    private Color colorSecundario;
    private Color colorTerciario;

    private List<Jugador> plantilla = new ArrayList<>();
    private Jugador[] titulares = new Jugador[11];



    public Equipo() {
    }

    public Equipo(String nombre, int puntos, String alineacion, Color colorPrincipal, Color colorSecundario, Color colorTerciario, List<Jugador> plantilla, Jugador[] titulares) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.alineacion = alineacion;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
        this.colorTerciario = colorTerciario;
        this.plantilla = plantilla;
        this.titulares = titulares;
    }



    public Equipo clone(){

        try {
            return (Equipo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
