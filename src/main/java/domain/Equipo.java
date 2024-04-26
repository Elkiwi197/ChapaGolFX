package domain;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    String nombre;
    int puntos;
    String historialDePartidos;
    String alineacion;

    List<Jugador> plantilla = new ArrayList<>();
    Jugador[] titulares = new Jugador[11];


    public Equipo() {
    }

    public Equipo(String nombre, int puntos, String historialDePartidos, String alineacion, List<Jugador> plantilla, Jugador[] titulares) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.historialDePartidos = historialDePartidos;
        this.alineacion = alineacion;
        this.plantilla = plantilla;
        this.titulares = titulares;
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
}
