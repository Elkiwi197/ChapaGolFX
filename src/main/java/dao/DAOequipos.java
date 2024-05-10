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
        Equipo realMadrid = new Equipo("Real Madrid", 0, null, "4-4-2", Color.WHITE, Color.DARKBLUE, Color.GREENYELLOW, null, null, false);
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
        //SUPLENTES
        plantillaRealMadrid.add(new Portero("Andriy Lunin", 13, "PO", 73, 70, 72, 75, 37, 73, 73, 70, 72, 75, 37, 73));
        plantillaRealMadrid.add(new Portero("Kepa Arrizabalaga", 25, "PO", 80, 78, 85, 84, 34, 78, 80, 78, 82, 84, 34, 78));
        plantillaRealMadrid.add(new Jugador("Nacho", 6, "CB", 75, 37, 69, 71, 82, 80));
        plantillaRealMadrid.add(new Jugador("Rüdiger", 22, "CB", 82, 54, 71, 66, 84, 86));
        plantillaRealMadrid.add(new Jugador("Fran García", 20, "LI", 89, 49, 69, 77, 71, 68));
        plantillaRealMadrid.add(new Jugador("Lucas Vázquez", 17, "LD", 81, 73, 80, 80, 73, 69));
        plantillaRealMadrid.add(new Jugador("Ceballos", 19, "MC", 63, 71, 78, 82, 70, 67));
        plantillaRealMadrid.add(new Jugador("Tchouaméni", 18, "MC", 73, 69, 79, 78, 81, 81));
        plantillaRealMadrid.add(new Jugador("Arda Güler", 0, "MC", 72, 70, 80, 81, 52, 50));
        plantillaRealMadrid.add(new Jugador("Brahim Díaz", 21, "DC", 81, 71, 77, 83, 30, 49));
        plantillaRealMadrid.add(new Jugador("Joselu", 14, "DC", 63, 84, 69, 74, 33, 77));
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
        //SUPLENTES
        plantillaBarcelona.add(new Portero("Iñaki Peña", 13, "PO", 72, 68, 77, 73, 35, 72, 72, 68, 77, 73, 35, 72));
        plantillaBarcelona.add(new Portero("Marc Vidal", 26, "PO", 62, 63, 66, 60, 30, 54, 62, 63, 66, 60, 30, 54)); // Su dorsal es el 13 pero el 13 es de Iñaki Peña
        plantillaBarcelona.add(new Jugador("Christiensen", 15, "CB", 67, 32, 68, 71, 85, 76));
        plantillaBarcelona.add(new Jugador("Íñigo Martínez", 5, "CB", 71, 56, 67, 61, 82, 80));
        plantillaBarcelona.add(new Jugador("Lenglet", 55, "CB", 66, 45, 69, 64, 77, 75)); // Su dorsal es el 15 pero el 15 es Christiensen
        plantillaBarcelona.add(new Jugador("Eric García", 24, "CB", 62, 44, 69, 67, 76, 71));
        plantillaBarcelona.add(new Jugador("Marcos Alonso", 17, "LI", 51, 74, 81, 77, 78, 76));
        plantillaBarcelona.add(new Jugador("Sergi Roberto", 20, "LD", 74, 63, 79, 77, 75, 73));
        plantillaBarcelona.add(new Jugador("Oriol Romeu", 18, "MC", 43, 54, 69, 67, 79, 82));
        plantillaBarcelona.add(new Jugador("Raphinha", 11 , "DC", 91, 79, 78, 86, 53, 73));
        plantillaBarcelona.add(new Jugador("Ferrán Torres", 7, "DC", 83, 79, 78, 83, 35, 68));
        plantillaBarcelona.add(new Jugador("Ansu Fati", 31, "DC", 89, 76, 72, 81, 30, 53));

        barcelona.setPlantilla(plantillaBarcelona);
        for (int i = 0; i < 11; i++) {
            titularesBarcelona[i] = barcelona.getPlantilla().get(i);
        }
        barcelona.setTitulares(titularesBarcelona);
        liga.add(barcelona);

        Equipo girona = new Equipo("Girona FC", 0, null, "4-3-3", Color.RED, Color.WHITE, Color.GREENYELLOW, null, null, false);
        List<Jugador> plantillaGirona = new ArrayList<>();
        Jugador[] titularesGirona = new Jugador[11];

        // METER DORSALES
        plantillaGirona.add(new Portero("Gazzaniga", 13, "PO", 77, 79, 78, 76, 57, 77, 77, 79, 78, 76, 57, 77));
        plantillaGirona.add(new Jugador("Miguel Gutiérrez", 3, "LI", 77, 53, 70, 74, 69, 65));
        plantillaGirona.add(new Jugador("Daley Blind", 17, "CB", 35, 62, 80, 78, 81, 66));
        plantillaGirona.add(new Jugador("David López", 5, "CB", 45, 57, 70, 65, 80, 74));
        plantillaGirona.add(new Jugador("Yan Couto", 20, "LD", 81, 56, 66, 75, 53, 69));
        plantillaGirona.add(new Jugador("Aleix García", 14, "MC", 64, 74, 81, 80, 71, 66));
        plantillaGirona.add(new Jugador("Iván Martín", 23, "MC", 74, 71, 74, 77, 59, 52));
        plantillaGirona.add(new Jugador("Yangel Herrera", 21, "MC", 60, 72, 72, 74, 76, 76));
        plantillaGirona.add(new Jugador("Tsygankov", 8, "MC", 85, 78, 79, 81, 46, 61));
        plantillaGirona.add(new Jugador("Dovbyk", 9, "DC", 74, 67, 55, 64, 28, 73));
        plantillaGirona.add(new Jugador("Sávio", 16, "MC", 81, 62, 66, 71, 30, 47));
        //SUPLENTES
        plantillaGirona.add(new Portero("Toni Fuidias", 26, "PO", 65, 64, 62, 62, 30, 61, 65, 64, 62, 62, 30, 61));
        plantillaGirona.add(new Portero("Juan Carlos", 1, "PO", 72, 73, 72, 73, 59, 71, 72, 73, 72, 73, 59, 71));
        plantillaGirona.add(new Jugador("Valery", 11, "CB", 87, 63, 66, 74, 66, 67));
        plantillaGirona.add(new Jugador("Juanpe", 15, "CB", 51, 37, 55, 48, 70, 77));
        plantillaGirona.add(new Jugador("Arnau Martínez", 4, "LD", 79, 50, 72, 76, 76, 70));
        plantillaGirona.add(new Jugador("Borja García", 10, "MC", 72, 70, 74, 75, 60, 65));
        plantillaGirona.add(new Jugador("Toni Villa", 19, "MC", 74, 65, 73, 77, 53, 48));
        plantillaGirona.add(new Jugador("Portu", 24, "MC", 81, 74, 72, 75, 56,  76));
        plantillaGirona.add(new Jugador("Stuani", 7, "DC", 66, 80, 69, 70, 48, 84));


        girona.setPlantilla(plantillaGirona);
        for (int i = 0; i < 11; i++) {
            titularesGirona[i] = girona.getPlantilla().get(i);
        }
        girona.setTitulares(titularesGirona);
        liga.add(girona);


        Equipo racing = new Equipo("Racing de Santander", 0, null, "4-3-3", Color.WHITE, Color.LIME, Color.BLACK, null, null, false);
        List<Jugador> plantillaRacing = new ArrayList<>();
        Jugador[] titularesRacing = new Jugador[11];

        plantillaRacing.add(new Portero("Jokin Ezkieta", 13, "PO", 67, 66, 68, 68, 44, 67, 67, 66, 68, 68, 44, 67));
        plantillaRacing.add(new Jugador("Álvaro Mantilla", 2, "LI", 52, 26, 56, 53, 62, 66));
        plantillaRacing.add(new Jugador("Germán", 5, "CB", 45, 40, 57, 54, 76, 78));
        plantillaRacing.add(new Jugador("Manu Hernando", 18, "CB", 60, 42, 49, 58, 66, 70));
        plantillaRacing.add(new Jugador("Dani Fernández",   23, "LD", 64, 34, 54, 62, 64, 60));
        plantillaRacing.add(new Jugador("Íñigo Sainz-Maza", 6, "MC", 72, 36, 58, 65, 64, 69));
        plantillaRacing.add(new Jugador("Peque", 17, "MC", 67, 56, 59, 66, 35, 46));
        plantillaRacing.add(new Jugador("Iván Morante", 16, "MC", 64, 62, 62, 64, 57, 59));
        plantillaRacing.add(new Jugador("Íñigo Vicente", 10, "DC", 75, 68, 73, 74, 47, 56));
        plantillaRacing.add(new Jugador("Juan Carlos Arana", 9, "DC", 66, 67, 54, 62, 33, 57));
        plantillaRacing.add(new Jugador("Jordi Mboula", 8, "DC", 87, 69, 63, 75, 32, 66));
        //SUPLENTES
        plantillaRacing.add(new Portero("Miquel Parera", 1, "PO", 72, 66, 64, 72, 38, 63, 72, 66, 64, 72, 38, 63));
        plantillaRacing.add(new Portero("Germán Fernández", 22, "PO", 56, 60, 54, 61, 30, 58, 56, 60, 54, 61, 30, 58)); // Su dorsal en el segundo equipo es el 1
        plantillaRacing.add(new Jugador("Rubén Alves", 15, "CB", 69, 44, 50, 60, 68, 71));
        plantillaRacing.add(new Jugador("Pol Moreno", 4, "CB", 57, 28, 50, 40, 67, 70));
        plantillaRacing.add(new Jugador("Saúl", 3, "CB", 66, 45, 64, 66, 68, 63));
        plantillaRacing.add(new Jugador("Marco Sangalli", 7, "MC", 68, 69, 66, 66, 53, 61));
        plantillaRacing.add(new Jugador("Lago Junior", 20, "MC", 87, 69, 61, 71, 33, 72));
        plantillaRacing.add(new Jugador("Aritz Aldasoro", 21, "MC", 68, 63, 64, 68, 62, 63));
        plantillaRacing.add(new Jugador("Grenier", 19, "MC", 36, 73, 79, 74, 62, 68));
        plantillaRacing.add(new Jugador("Andrés Martín", 11 , "DC", 78, 67, 64, 68, 27, 65));
        plantillaRacing.add(new Jugador("Ekain", 14, "DC", 69, 67, 59, 68, 29, 61));

        racing.setPlantilla(plantillaRacing);
        for (int i = 0; i < 11; i++) {
            titularesRacing[i] = racing.getPlantilla().get(i);
        }
        racing.setTitulares(titularesRacing);
        liga.add(racing);

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
