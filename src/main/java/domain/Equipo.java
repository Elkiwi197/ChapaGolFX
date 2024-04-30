package domain;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Equipo implements Cloneable {
    private String nombre;
    private int puntos;
    private String historialDePartidos;
    private String alineacion;
    private Color colorPrincipal;
    private Color colorSecundario;
    private Color colorTerciario;

    private List<Jugador> plantilla = new ArrayList<>();
    private Jugador[] titulares = new Jugador[11];

    private boolean saca;


    public Equipo() {
    }

    public Equipo(String nombre, int puntos, String historialDePartidos, String alineacion, Color colorPrincipal, Color colorSecundario, Color colorTerciario, List<Jugador> plantilla, Jugador[] titulares, boolean saca) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.historialDePartidos = historialDePartidos;
        this.alineacion = alineacion;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
        this.colorTerciario = colorTerciario;
        this.plantilla = plantilla;
        this.titulares = titulares;
        this.saca = saca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getHistorialDePartidos() {
        return historialDePartidos;
    }

    public void setHistorialDePartidos(String historialDePartidos) {
        this.historialDePartidos = historialDePartidos;
    }

    public String getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(String alineacion) {
        this.alineacion = alineacion;
    }

    public Color getColorPrincipal() {
        return colorPrincipal;
    }

    public void setColorPrincipal(Color colorPrincipal) {
        this.colorPrincipal = colorPrincipal;
    }

    public Color getColorSecundario() {
        return colorSecundario;
    }

    public void setColorSecundario(Color colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    public Color getColorTerciario() {
        return colorTerciario;
    }

    public void setColorTerciario(Color colorTerciario) {
        this.colorTerciario = colorTerciario;
    }

    public List<Jugador> getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(List<Jugador> plantilla) {
        this.plantilla = plantilla;
    }

    public Jugador[] getTitulares() {
        return titulares;
    }

    public void setTitulares(Jugador[] titulares) {
        this.titulares = titulares;
    }

    public boolean isSaca() {
        return saca;
    }

    public void setSaca(boolean saca) {
        this.saca = saca;
    }
    public Equipo clone(){

        try {
            return (Equipo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
