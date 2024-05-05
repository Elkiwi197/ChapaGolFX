package dao;

import domain.Equipo;
import domain.Jugador;
import domain.Portero;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class DAOequipos {
    private List<Equipo> liga = new ArrayList<>();

    public void init() {
        Equipo realMadrid = new Equipo("Real Madrid", 0, null, "4-4-2", Color.WHITE, Color.DARKBLUE, Color.YELLOWGREEN, null, null, false);
        List<Jugador> plantillaRealMadrid = new ArrayList<>();
        Jugador[] titularesRealMadrid = new Jugador[11];
        plantillaRealMadrid.add(new Portero("Thibaut Courtois", 1, "PO", 86, 90, 76, 89, 54, 91, 85, 89, 76, 93, 46, 90));
        plantillaRealMadrid.add(new Jugador("Ferland Mendy", 23, "LI", 92, 64, 76, 79, 78, 84));
        plantillaRealMadrid.add(new Jugador("Eder Militao", 3, "CB", 86, 53, 72, 74, 88, 84));
        plantillaRealMadrid.add(new Jugador("David Alaba", 4, "CB", 82, 79, 86, 84, 85, 82));
        plantillaRealMadrid.add(new Jugador("Dani Carvajal", 2, "LD", 82, 54, 76, 79, 77, 79));
        plantillaRealMadrid.add(new Jugador("Jude Bellingham", 5, "MC", 76, 75, 79, 85, 78, 82));
        plantillaRealMadrid.add(new Jugador("Toni Kroos", 8, "MC", 51, 80, 90, 81, 70, 71));
        plantillaRealMadrid.add(new Jugador("Luka Modric", 10, "MC", 81, 80, 91, 90, 75, 70));
        plantillaRealMadrid.add(new Jugador("Eduardo Camavinga", 12, "MC", 79, 66, 80, 82, 76, 80));
            plantillaRealMadrid.add(new Jugador("Vinicius Junior", 7, "DC", 97, 85, 81, 92, 31, 72));
        plantillaRealMadrid.add(new Jugador("Rodrygo Goes", 11, "DC", 91, 86, 83, 90, 35, 66));
        realMadrid.setPlantilla(plantillaRealMadrid);
        for (int i = 0; i < 11; i++) {
            titularesRealMadrid[i] = realMadrid.getPlantilla().get(i);
        }
        realMadrid.setTitulares(titularesRealMadrid);
        liga.add(realMadrid);

        Equipo barcelona = new Equipo("FC Barcelona", 0, null, "4-3-3", Color.RED, Color.BLUE, Color.ORANGE, null, null, false);
        List<Jugador> plantillaBarcelona = new ArrayList<>();
        Jugador[] titularesBarcelona = new Jugador[11];

        plantillaBarcelona.add(new Portero("Ter Stegen", 1, "PO", 86, 85, 87, 90, 47, 85, 86, 85, 87, 90, 47, 85));
        plantillaBarcelona.add(new Jugador("Joao Cancelo", 2, "LI", 81, 73, 85, 84, 80, 72));
        plantillaBarcelona.add(new Jugador("Joules Koundé", 23, "CB", 84, 60, 80, 76, 87, 82));
        plantillaBarcelona.add(new Jugador("Ronald Araújo", 4, "CB", 79, 51, 65, 62, 86, 84));
        plantillaBarcelona.add(new Jugador("Alejandro Balde", 3, "LD", 91, 48, 73, 78, 75, 64));
        plantillaBarcelona.add(new Jugador("Pedri", 8, "MC", 78, 69, 82, 88, 70, 74));
        plantillaBarcelona.add(new Jugador("Ilkay Gundogan", 22, "MC", 75, 85, 87, 89, 77, 78));
        plantillaBarcelona.add(new Jugador("Frenkie de Jong", 21, "MC", 82, 69, 86, 87, 77, 78));
        plantillaBarcelona.add(new Jugador("Joao Felix", 14, "DC", 88, 88, 84, 89, 45, 74));
        plantillaBarcelona.add(new Jugador("Robert Lewandowski", 9, "DC", 75, 91, 80, 87, 44, 84));
        plantillaBarcelona.add(new Jugador("Lamine Yamal", 27, "DC", 90, 70, 72, 81, 38, 60));
        barcelona.setPlantilla(plantillaBarcelona);
        for (int i = 0; i < 11; i++) {
            titularesBarcelona[i] = barcelona.getPlantilla().get(i);
        }
        barcelona.setTitulares(titularesBarcelona);
        liga.add(barcelona);

    }

    public ObservableList<String> devolverListaEquipos() {
        ObservableList<String> lista = FXCollections.observableArrayList();
        ;
        for (Equipo equipo : liga) {
            lista.add(equipo.getNombre());
        }
        return lista;
    }

    public Equipo devolverEquipo(String nombreEquipo) {
        Equipo equipo = new Equipo();
        for (Equipo equipoDevolver : liga) {
            if (equipoDevolver.getNombre().equals(nombreEquipo)) {
                equipo = (Equipo) equipoDevolver.clone();
            }
        }
        return equipo;
    }

    public Equipo devolverEquipoRepetido(String nombreEquipo) {
return new Equipo();
    }
}
