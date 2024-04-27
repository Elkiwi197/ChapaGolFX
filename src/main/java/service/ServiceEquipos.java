package service;

import dao.DAOequipos;

public class ServiceEquipos {
    DAOequipos daoEquipos = new DAOequipos();

    public void init(){
        daoEquipos.init();
    }


}
