package dao;

import domain.Equipo;
import domain.Jugador;

import java.util.ArrayList;
import java.util.List;

public class DAOequipos {
    private List<Equipo> liga = new ArrayList<Equipo>();

    public void init(){
        Equipo realMadrid = new Equipo("Real Madrid", 0, null, "4-4-2", null, null);
        realMadrid.getPlantilla().add(new Jugador("Thibaut Courtois", 1, "PO"));
        realMadrid.getPlantilla().add(new Jugador("Dani Carvajal", 2, "LD"));
        realMadrid.getPlantilla().add(new Jugador("Eder Militao", 3, "CB"));
        realMadrid.getPlantilla().add(new Jugador("David Alaba", 4, "CB"));
        realMadrid.getPlantilla().add(new Jugador("Ferland Mendy", 23, "LI"));
        realMadrid.getPlantilla().add(new Jugador("Jude Bellingham", 5, "MC"));
        realMadrid.getPlantilla().add(new Jugador("Toni Kroos", 8, "MC"));
        realMadrid.getPlantilla().add(new Jugador("Luka Modric", 10, "MC"));
        realMadrid.getPlantilla().add(new Jugador("Eduardo Camavinga", 12, "MC"));
        realMadrid.getPlantilla().add(new Jugador("Vinicius Junior", 7, "DC"));
        realMadrid.getPlantilla().add(new Jugador("Rodrygo Goes", 11, "DC"));
        for (int i = 0; i < 11; i++) {
            realMadrid.getTitulares()[i] = realMadrid.getPlantilla().get(i);
        }
        liga.add(realMadrid);

        Equipo barcelona = new Equipo("FC Barcelona", 0, null, "4-3-3", null, null);
        barcelona.getPlantilla().add(new Jugador("Ter Stegen", 1, "PO"));
        barcelona.getPlantilla().add(new Jugador("Joao Cancelo", 2, "LD"));
        barcelona.getPlantilla().add(new Jugador("Alejandro Balde", 3, "LI"));
        barcelona.getPlantilla().add(new Jugador("Joules Koundé", 23, "CB"));
        barcelona.getPlantilla().add(new Jugador("Ronald Araújo", 4, "CB"));
        barcelona.getPlantilla().add(new Jugador("Pedri", 8, "MC"));
        barcelona.getPlantilla().add(new Jugador("Ilkay Gundogan", 22, "MC"));
        barcelona.getPlantilla().add(new Jugador("Frenkie de Jong", 21, "MC"));
        barcelona.getPlantilla().add(new Jugador("Joao Felix", 14, "DC"));
        barcelona.getPlantilla().add(new Jugador("Robert Lewandowski", 9, "DC"));
        barcelona.getPlantilla().add(new Jugador("Lamine Yamal", 27, "DC"));
        for (int i = 0; i < 11; i++) {
            barcelona.getTitulares()[i] = barcelona.getPlantilla().get(i);
        }

    }
}
