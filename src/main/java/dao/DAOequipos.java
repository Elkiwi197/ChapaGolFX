package dao;

import domain.Equipo;
import domain.Jugador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class DAOequipos {
    private List<Equipo> liga = new ArrayList<Equipo>();

    public void init(){
        Equipo realMadrid = new Equipo("Real Madrid", 0, null, "4-4-2", null, null);
        List<Jugador> plantillaRealMadrid = new ArrayList<>();
        Jugador[] titularesRealMadrid = new Jugador[11];
        plantillaRealMadrid.add(new Jugador("Thibaut Courtois", 1, "PO"));
        plantillaRealMadrid.add(new Jugador("Dani Carvajal", 2, "LD"));
        plantillaRealMadrid.add(new Jugador("Eder Militao", 3, "CB"));
        plantillaRealMadrid.add(new Jugador("David Alaba", 4, "CB"));
        plantillaRealMadrid.add(new Jugador("Ferland Mendy", 23, "LI"));
        plantillaRealMadrid.add(new Jugador("Jude Bellingham", 5, "MC"));
        plantillaRealMadrid.add(new Jugador("Toni Kroos", 8, "MC"));
        plantillaRealMadrid.add(new Jugador("Luka Modric", 10, "MC"));
        plantillaRealMadrid.add(new Jugador("Eduardo Camavinga", 12, "MC"));
        plantillaRealMadrid.add(new Jugador("Vinicius Junior", 7, "DC"));
        plantillaRealMadrid.add(new Jugador("Rodrygo Goes", 11, "DC"));
        realMadrid.setPlantilla(plantillaRealMadrid);
        for (int i = 0; i < 11; i++) {
            titularesRealMadrid[i] = realMadrid.getPlantilla().get(i);
        }
        realMadrid.setTitulares(titularesRealMadrid);
        liga.add(realMadrid);

        Equipo barcelona = new Equipo("FC Barcelona", 0, null, "4-3-3", null, null);
        List<Jugador> plantillaBarcelona = new ArrayList<>();
        Jugador[] titularesBarcelona = new Jugador[11];

        plantillaBarcelona.add(new Jugador("Ter Stegen", 1, "PO"));
        plantillaBarcelona.add(new Jugador("Joao Cancelo", 2, "LD"));
        plantillaBarcelona.add(new Jugador("Alejandro Balde", 3, "LI"));
        plantillaBarcelona.add(new Jugador("Joules Koundé", 23, "CB"));
        plantillaBarcelona.add(new Jugador("Ronald Araújo", 4, "CB"));
        plantillaBarcelona.add(new Jugador("Pedri", 8, "MC"));
        plantillaBarcelona.add(new Jugador("Ilkay Gundogan", 22, "MC"));
        plantillaBarcelona.add(new Jugador("Frenkie de Jong", 21, "MC"));
        plantillaBarcelona.add(new Jugador("Joao Felix", 14, "DC"));
        plantillaBarcelona.add(new Jugador("Robert Lewandowski", 9, "DC"));
        plantillaBarcelona.add(new Jugador("Lamine Yamal", 27, "DC"));
        barcelona.setPlantilla(plantillaBarcelona);
        for (int i = 0; i < 11; i++) {
           titularesBarcelona[i] = barcelona.getPlantilla().get(i);
        }
        barcelona.setTitulares(titularesBarcelona);
        liga.add(barcelona);

    }

    public ObservableList<String> devolverListaEquipos() {
        ObservableList<String> lista = FXCollections.observableArrayList();;
        for (Equipo equipo: liga) {
            lista.add(equipo.getNombre());
        }
        return lista;
    }
}
