package service;

import dao.DAOequipos;
import domain.Equipo;
import javafx.collections.ObservableList;

public class ServiceEquipos {
    DAOequipos daoEquipos = new DAOequipos();

    public void init(){
        daoEquipos.init();
    }


    public ObservableList<String> devolverListaEquipos() {
        return daoEquipos.devolverListaEquipos();
    }

    public Equipo devolverEquipo(String nombreEquipo) {
       return daoEquipos.devolverEquipo(nombreEquipo);
    }

    public Equipo devolverEquipoRepetido(String nombreEquipo) {
        return daoEquipos.devolverEquipoRepetido(nombreEquipo);
    }
}
