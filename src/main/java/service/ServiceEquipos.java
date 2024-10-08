package service;

import dao.DAOequipos;
import domain.Equipo;
import domain.Jugador;
import javafx.collections.ObservableList;

import java.util.TreeSet;

public class ServiceEquipos {
    private DAOequipos daoEquipos = new DAOequipos();

    public void init() {
        daoEquipos.init();
    }


    public ObservableList<String> devolverListaEquipos() {
        return daoEquipos.devolverListaEquipos();
    }

    public Equipo devolverEquipo(String nombreEquipo) {
        return daoEquipos.devolverEquipo(nombreEquipo);
    }

    public TreeSet<Jugador> devolverJugadoresEquipo(String nombreEquipo) {
        return daoEquipos.devolverJugadoresEquipo(nombreEquipo);
    }

    public Jugador devolverJugador(String nombreJugador, String nombreEquipo) {
        return daoEquipos.devolverJugador(nombreJugador, nombreEquipo);
    }

    public void cambiarJugadorDeEquipo(String equipoInicial, String equipoFinal, Jugador jugador) {
        daoEquipos.cambiarJugadorDeEquipo(equipoInicial, equipoFinal, jugador);
    }

    public void eliminarJugador(String nombreEquipo, Jugador jugador) {
        daoEquipos.eliminarJugador(nombreEquipo, jugador);
    }
    public void anadirJugador(Jugador jugador, String nombreEquipo){
        daoEquipos.anadirJugador(jugador, nombreEquipo);
    }

    public ObservableList<String> devolverListaEquiposJugables() {
        return daoEquipos.devolverListaEquiposJugables();
    }

    public void actualizarClasificacion() {
        daoEquipos.actualizarClasificacion();
    }

    public void sumarPuntos(int golesLocal, int golesVisitante, Equipo equipoLocal, Equipo equipoVisitante) {
        daoEquipos.sumarPuntos(golesLocal, golesVisitante, equipoLocal, equipoVisitante);
    }
}
