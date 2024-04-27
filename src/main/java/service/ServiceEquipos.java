package service;

import dao.DAOequipos;
import javafx.collections.ObservableList;

public class ServiceEquipos {
    DAOequipos daoEquipos = new DAOequipos();

    public void init(){
        daoEquipos.init();
    }


    public ObservableList<String> devolverListaEquipos() {
        return daoEquipos.devolverListaEquipos();
    }
}
