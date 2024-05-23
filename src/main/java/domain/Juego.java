package domain;

import common.Jugada;
import lombok.Data;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Data
public class Juego {
    private Jugador[][] campo = new Jugador[15][22];
    private Equipo equipoLocal = new Equipo(); //J1
    private Equipo equipoVisitante = new Equipo(); //J2
    private boolean turno; // True = local, false = visitante
    private int golesLocal;
    private int golesVisitante;
    private String goleadoresLocal = "";
    private String goleadoresVisitante = "";
    private int PA;
    private LocalDate fechaInicioPartido;


    public void comprobarTurno() {
        if (PA == 0) {
            PA = 5;
            turno = !turno;
        }
    }

    public boolean comprobarFinal() {
        boolean finalPartido = false;
        int expulsados = 0;
        if (golesLocal + golesVisitante > 3) {
            finalPartido = true;
        }
        for (int i = 0; i < 11; i++) {
            if (equipoLocal.getTitulares()[i] == null) {
                expulsados++;
            }
        }
        if (expulsados >= 3) {
            finalPartido = true;
        }
        expulsados = 0;
        for (int i = 0; i < 11; i++) {
            if (equipoVisitante.getTitulares()[i] == null) {
                expulsados++;
            }
        }
        if (expulsados >= 3) {
            finalPartido = true;
        }
        return finalPartido;
    }


    public void jugarAmigo(Equipo local, Equipo visitante) {
        turno = true;
        equipoLocal = local;
        equipoVisitante = visitante;
        golesLocal = 0;
        golesVisitante = 0;
        PA = 5;
        fechaInicioPartido = LocalDate.now();


        cargarJugadoresEnCampoRAM(Jugada.SAQUE_CENTRO);
        actualizarCampoConsola();


    }

    private void actualizarCampoConsola() {
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[0].length; j++) {
                if (campo[i][j] == null) {
                    System.out.print("|  |");
                } else {
                    if (campo[i][j].getDorsal() < 10) {
                        System.out.print("|" + campo[i][j].getDorsal() + " |");
                    } else {
                        System.out.print("|" + campo[i][j].getDorsal() + "|");
                    }
                }
            }
            System.out.println(" ");
        }
    }

    private void cargarJugadoresEnCampoRAM(Jugada tipoJugada) {
        //Primero elimino todos los jugadores que haya en el campo
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[0].length; j++) {
                if (campo[i][j] != null) {
                    campo[i][j] = null;
                }
            }
        }

        // Luego los meto en su sitio correspondiente
        switch (tipoJugada) {
            case SAQUE_CENTRO:
                if (turno) { // Si saca el equipo local
                    switch (equipoLocal.getAlineacion()) {
                        case "4-4-2":
                            //Portero
                            campo[7][0] = equipoLocal.getTitulares()[0];
                            //Defensas
                            campo[4][4] = equipoLocal.getTitulares()[1];
                            campo[6][4] = equipoLocal.getTitulares()[2];
                            campo[8][4] = equipoLocal.getTitulares()[3];
                            campo[10][4] = equipoLocal.getTitulares()[4];
                            //Centrocampistas
                            campo[4][6] = equipoLocal.getTitulares()[5];
                            campo[6][6] = equipoLocal.getTitulares()[6];
                            campo[8][6] = equipoLocal.getTitulares()[7];
                            campo[10][6] = equipoLocal.getTitulares()[8];
                            //Delanteros
                            if (equipoLocal.getTitulares()[10] == null) {
                                for (int i = 0; i < equipoLocal.getTitulares().length; i++) {
                                    if (equipoLocal.getTitulares()[10 - i] != null) {
                                        for (int j = 0; j < 15; j++) {
                                            for (int k = 0; k < 22; k++) {
                                                if (campo[j][k] == equipoLocal.getTitulares()[10 - i]) {
                                                    campo[j][k] = null;
                                                }
                                            }
                                        }
                                        campo[7][10] = equipoLocal.getTitulares()[10 - i];
                                        campo[7][10].setTieneBalon(true);
                                        break;
                                    }
                                }
                            } else {
                                campo[6][10] = equipoLocal.getTitulares()[9];
                                campo[7][10] = equipoLocal.getTitulares()[10];
                                campo[7][10].setTieneBalon(true);
                                //COMPROBAR
                            }


                            break;
                        case "4-3-3":
                            //Portero
                            campo[7][0] = equipoLocal.getTitulares()[0];
                            //Defensas
                            campo[4][4] = equipoLocal.getTitulares()[1];
                            campo[6][4] = equipoLocal.getTitulares()[2];
                            campo[8][4] = equipoLocal.getTitulares()[3];
                            campo[10][4] = equipoLocal.getTitulares()[4];
                            //Centrocampistas
                            campo[5][6] = equipoLocal.getTitulares()[5];
                            campo[7][6] = equipoLocal.getTitulares()[6];
                            campo[9][6] = equipoLocal.getTitulares()[7];
                            //Delanteros
                            campo[7][10] = equipoLocal.getTitulares()[8];
                            campo[7][8] = equipoLocal.getTitulares()[9];
                            campo[8][10] = equipoLocal.getTitulares()[10];
                            campo[7][10].setTieneBalon(true);
                            break;
                    }

                    // Coloco al equipo visitante
                    switch (equipoVisitante.getAlineacion()) {
                        case "4-4-2":
                            // Portero
                            campo[7][21] = equipoVisitante.getTitulares()[0];
                            // Defensas
                            campo[10][17] = equipoVisitante.getTitulares()[1];
                            campo[8][17] = equipoVisitante.getTitulares()[2];
                            campo[6][17] = equipoVisitante.getTitulares()[3];
                            campo[4][17] = equipoVisitante.getTitulares()[4];
                            // Centrocampistas
                            campo[10][15] = equipoVisitante.getTitulares()[5];
                            campo[8][15] = equipoVisitante.getTitulares()[6];
                            campo[6][15] = equipoVisitante.getTitulares()[7];
                            campo[4][15] = equipoVisitante.getTitulares()[8];
                            //Delanteros
                            campo[8][13] = equipoVisitante.getTitulares()[9];
                            campo[6][13] = equipoVisitante.getTitulares()[10];
                            break;
                        case "4-3-3":
                            // Portero
                            campo[7][21] = equipoVisitante.getTitulares()[0];
                            // Defensas
                            campo[10][17] = equipoVisitante.getTitulares()[1];
                            campo[8][17] = equipoVisitante.getTitulares()[2];
                            campo[6][17] = equipoVisitante.getTitulares()[3];
                            campo[4][17] = equipoVisitante.getTitulares()[4];
                            // Centrocampistas
                            campo[9][15] = equipoVisitante.getTitulares()[5];
                            campo[7][15] = equipoVisitante.getTitulares()[6];
                            campo[5][15] = equipoVisitante.getTitulares()[7];
                            //Delanteros
                            campo[9][13] = equipoVisitante.getTitulares()[8];
                            campo[7][13] = equipoVisitante.getTitulares()[9];
                            campo[5][13] = equipoVisitante.getTitulares()[10];
                            break;
                        default:

                    }
                } else { // Si saca el equipo visitante
                    switch (equipoLocal.getAlineacion()) { // Coloco al equipo local
                        case "4-4-2":
                            //Portero
                            campo[7][0] = equipoLocal.getTitulares()[0];
                            //Defensas
                            campo[4][4] = equipoLocal.getTitulares()[1];
                            campo[6][4] = equipoLocal.getTitulares()[2];
                            campo[8][4] = equipoLocal.getTitulares()[3];
                            campo[10][4] = equipoLocal.getTitulares()[4];
                            //Centrocampistas
                            campo[4][6] = equipoLocal.getTitulares()[5];
                            campo[6][6] = equipoLocal.getTitulares()[6];
                            campo[8][6] = equipoLocal.getTitulares()[7];
                            campo[10][6] = equipoLocal.getTitulares()[8];
                            //Delanteros
                            campo[6][8] = equipoLocal.getTitulares()[9];
                            campo[8][8] = equipoLocal.getTitulares()[10];
                            break;
                        case "4-3-3":
                            //Portero
                            campo[7][0] = equipoLocal.getTitulares()[0];
                            //Defensas
                            campo[4][4] = equipoLocal.getTitulares()[1];
                            campo[6][4] = equipoLocal.getTitulares()[2];
                            campo[8][4] = equipoLocal.getTitulares()[3];
                            campo[10][4] = equipoLocal.getTitulares()[4];
                            //Centrocampistas
                            campo[5][6] = equipoLocal.getTitulares()[5];
                            campo[7][6] = equipoLocal.getTitulares()[6];
                            campo[9][6] = equipoLocal.getTitulares()[7];
                            //Delanteros
                            campo[5][8] = equipoLocal.getTitulares()[8];
                            campo[7][8] = equipoLocal.getTitulares()[9];
                            campo[9][8] = equipoLocal.getTitulares()[10];
                            break;
                    }
                    switch (equipoVisitante.getAlineacion()) { // Coloco al equipo visitante

                        case "4-4-2":
                            // Portero
                            campo[7][21] = equipoVisitante.getTitulares()[0];
                            // Defensas
                            campo[10][17] = equipoVisitante.getTitulares()[1];
                            campo[8][17] = equipoVisitante.getTitulares()[2];
                            campo[6][17] = equipoVisitante.getTitulares()[3];
                            campo[4][17] = equipoVisitante.getTitulares()[4];
                            // Centrocampistas
                            campo[10][15] = equipoVisitante.getTitulares()[5];
                            campo[8][15] = equipoVisitante.getTitulares()[6];
                            campo[6][15] = equipoVisitante.getTitulares()[7];
                            campo[4][15] = equipoVisitante.getTitulares()[8];
                            //Delanteros
                            campo[8][11] = equipoVisitante.getTitulares()[9];
                            campo[7][11] = equipoVisitante.getTitulares()[10];
                            campo[7][11].setTieneBalon(true);
                            break;
                        case "4-3-3":
                            // Portero
                            campo[7][21] = equipoVisitante.getTitulares()[0];
                            // Defensas
                            campo[10][17] = equipoVisitante.getTitulares()[1];
                            campo[8][17] = equipoVisitante.getTitulares()[2];
                            campo[6][17] = equipoVisitante.getTitulares()[3];
                            campo[4][17] = equipoVisitante.getTitulares()[4];
                            // Centrocampistas
                            campo[9][15] = equipoVisitante.getTitulares()[5];
                            campo[7][15] = equipoVisitante.getTitulares()[6];
                            campo[5][15] = equipoVisitante.getTitulares()[7];
                            //Delanteros
                            campo[6][11] = equipoVisitante.getTitulares()[8];
                            campo[7][13] = equipoVisitante.getTitulares()[9];
                            campo[7][11] = equipoVisitante.getTitulares()[10];
                            campo[7][11].setTieneBalon(true);
                            break;
                        default:
                    }
                }
                break;
            case SAQUE_PUERTA:
                // Coloco al equipo local
                switch (equipoLocal.getAlineacion()) {
                    case "4-4-2":
                        //Portero
                        campo[7][0] = equipoLocal.getTitulares()[0];
                        //Defensas
                        campo[4][4] = equipoLocal.getTitulares()[1];
                        campo[6][4] = equipoLocal.getTitulares()[2];
                        campo[8][4] = equipoLocal.getTitulares()[3];
                        campo[10][4] = equipoLocal.getTitulares()[4];
                        //Centrocampistas
                        campo[1][8] = equipoLocal.getTitulares()[5];
                        campo[5][8] = equipoLocal.getTitulares()[6];
                        campo[9][8] = equipoLocal.getTitulares()[7];
                        campo[13][8] = equipoLocal.getTitulares()[8];
                        //Delanteros
                        campo[4][15] = equipoLocal.getTitulares()[9];
                        campo[10][15] = equipoLocal.getTitulares()[10];
                        break;
                    case "4-3-3":
                        //Portero
                        campo[7][0] = equipoLocal.getTitulares()[0];
                        //Defensas
                        campo[4][4] = equipoLocal.getTitulares()[1];
                        campo[6][4] = equipoLocal.getTitulares()[2];
                        campo[8][4] = equipoLocal.getTitulares()[3];
                        campo[10][4] = equipoLocal.getTitulares()[4];
                        //Centrocampistas
                        campo[2][8] = equipoLocal.getTitulares()[5];
                        campo[7][8] = equipoLocal.getTitulares()[6];
                        campo[12][8] = equipoLocal.getTitulares()[7];
                        //Delanteros
                        campo[2][15] = equipoLocal.getTitulares()[8];
                        campo[7][15] = equipoLocal.getTitulares()[9];
                        campo[12][15] = equipoLocal.getTitulares()[10];
                        break;
                }
                // Coloco al equipo visitante
                switch (equipoVisitante.getAlineacion()) {
                    case "4-4-2":
                        // Portero
                        campo[7][21] = equipoVisitante.getTitulares()[0];
                        // Defensas
                        campo[10][17] = equipoVisitante.getTitulares()[1];
                        campo[8][17] = equipoVisitante.getTitulares()[2];
                        campo[6][17] = equipoVisitante.getTitulares()[3];
                        campo[4][17] = equipoVisitante.getTitulares()[4];
                        // Centrocampistas
                        campo[13][13] = equipoVisitante.getTitulares()[5];
                        campo[9][13] = equipoVisitante.getTitulares()[6];
                        campo[5][13] = equipoVisitante.getTitulares()[7];
                        campo[1][13] = equipoVisitante.getTitulares()[8];
                        //Delanteros
                        campo[10][6] = equipoVisitante.getTitulares()[9];
                        campo[4][6] = equipoVisitante.getTitulares()[10];
                        break;
                    case "4-3-3":
                        // Portero
                        campo[7][21] = equipoVisitante.getTitulares()[0];
                        // Defensas
                        campo[10][17] = equipoVisitante.getTitulares()[1];
                        campo[8][17] = equipoVisitante.getTitulares()[2];
                        campo[6][17] = equipoVisitante.getTitulares()[3];
                        campo[4][17] = equipoVisitante.getTitulares()[4];
                        // Centrocampistas
                        campo[12][13] = equipoVisitante.getTitulares()[5];
                        campo[7][13] = equipoVisitante.getTitulares()[6];
                        campo[2][13] = equipoVisitante.getTitulares()[7];
                        //Delanteros
                        campo[12][6] = equipoVisitante.getTitulares()[8];
                        campo[7][6] = equipoVisitante.getTitulares()[9];
                        campo[2][6] = equipoVisitante.getTitulares()[10];
                        break;
                    default:
                }
                if (turno) {
                    campo[7][0].setTieneBalon(true);
                } else {
                    campo[7][21].setTieneBalon(true);
                }
                break;
            case CORNER:
                int lado = (int) (Math.random() * 2); // 0 = corner arriba, 1 = corner abajo
                if (turno) { // Si saca el equipo local
                    // COLOCO AL EQUIPO LOCAL
                    //Portero
                    campo[7][0] = equipoLocal.getTitulares()[0];
                    //Defensas
                    campo[2][10] = equipoLocal.getTitulares()[1];
                    campo[5][7] = equipoLocal.getTitulares()[2];
                    campo[9][7] = equipoLocal.getTitulares()[3];
                    campo[12][10] = equipoLocal.getTitulares()[4];
                    //Centrocampistas
                    if (lado == 0) {
                        campo[0][21] = equipoLocal.getTitulares()[5];
                        campo[0][21].setTieneBalon(true);
                        campo[2][17] = equipoLocal.getTitulares()[6];
                        campo[7][16] = equipoLocal.getTitulares()[7];
                        campo[12][17] = equipoLocal.getTitulares()[8];
                    } else {
                        campo[2][17] = equipoLocal.getTitulares()[5];
                        campo[7][16] = equipoLocal.getTitulares()[6];
                        campo[12][17] = equipoLocal.getTitulares()[7];
                        campo[14][21] = equipoLocal.getTitulares()[8];
                        campo[14][21].setTieneBalon(true);
                    }
                    //Delanteros
                    campo[6][19] = equipoLocal.getTitulares()[9];
                    campo[8][19] = equipoLocal.getTitulares()[10];

                    // COLOCO AL EQUIPO VISITANTE
                    // Portero
                    campo[7][21] = equipoVisitante.getTitulares()[0];
                    // Defensas
                    campo[9][21] = equipoVisitante.getTitulares()[1];
                    campo[8][20] = equipoVisitante.getTitulares()[2];
                    campo[6][20] = equipoVisitante.getTitulares()[3];
                    campo[5][21] = equipoVisitante.getTitulares()[4];
                    // Centrocampistas
                    campo[3][19] = equipoVisitante.getTitulares()[5];
                    campo[7][19] = equipoVisitante.getTitulares()[6];
                    campo[11][19] = equipoVisitante.getTitulares()[7];
                    //Delanteros
                    campo[7][17] = equipoVisitante.getTitulares()[8];
                    campo[8][14] = equipoVisitante.getTitulares()[9];
                    campo[6][14] = equipoVisitante.getTitulares()[10];
                } else { // Si saca el equipo visitante
                    // COLOCO AL EQUIPO LOCAL
                    //Portero
                    campo[7][0] = equipoLocal.getTitulares()[0];
                    //Defensas
                    campo[5][0] = equipoLocal.getTitulares()[1];
                    campo[6][1] = equipoLocal.getTitulares()[2];
                    campo[8][1] = equipoLocal.getTitulares()[3];
                    campo[9][0] = equipoLocal.getTitulares()[4];
                    //Centrocampistas
                    campo[3][2] = equipoLocal.getTitulares()[5];
                    campo[7][2] = equipoLocal.getTitulares()[6];
                    campo[11][2] = equipoLocal.getTitulares()[7];
                    campo[7][4] = equipoLocal.getTitulares()[8];
                    //Delanteros
                    campo[6][7] = equipoLocal.getTitulares()[9];
                    campo[8][7] = equipoLocal.getTitulares()[10];

                    // COLOCO AL EQUIPO VISITANTE
                    // Portero
                    campo[7][21] = equipoVisitante.getTitulares()[0];
                    // Defensas
                    campo[12][11] = equipoVisitante.getTitulares()[1];
                    campo[5][14] = equipoVisitante.getTitulares()[2];
                    campo[9][14] = equipoVisitante.getTitulares()[3];
                    campo[2][11] = equipoVisitante.getTitulares()[4];
                    // Centrocampistas
                    if (lado == 0) {
                        campo[12][4] = equipoVisitante.getTitulares()[5];
                        campo[7][5] = equipoVisitante.getTitulares()[6];
                        campo[2][4] = equipoVisitante.getTitulares()[7];
                        campo[0][0] = equipoVisitante.getTitulares()[8];
                        campo[0][0].setTieneBalon(true);
                    } else {
                        campo[14][0] = equipoVisitante.getTitulares()[5];
                        campo[14][0].setTieneBalon(true);
                        campo[12][4] = equipoVisitante.getTitulares()[7];
                        campo[7][5] = equipoVisitante.getTitulares()[6];
                        campo[2][4] = equipoVisitante.getTitulares()[8];
                    }
                    //Delanteros
                    campo[8][2] = equipoVisitante.getTitulares()[9];
                    campo[6][2] = equipoVisitante.getTitulares()[10];
                }
                break;
            case PENALTI:
                if (turno) { // Si tira el equipo local
                    // COLOCO AL EQUIPO LOCAL
                    campo[7][0] = equipoLocal.getTitulares()[0];
                    //Defensas
                    campo[2][9] = equipoLocal.getTitulares()[1];
                    campo[5][7] = equipoLocal.getTitulares()[2];
                    campo[9][7] = equipoLocal.getTitulares()[3];
                    campo[12][9] = equipoLocal.getTitulares()[4];
                    //Centrocampistas y delanteros
                    switch (equipoLocal.getAlineacion()) {
                        case "4-4-2":
                            //Centrocampistas
                            campo[4][13] = equipoLocal.getTitulares()[5];
                            campo[7][15] = equipoLocal.getTitulares()[6];
                            campo[9][16] = equipoLocal.getTitulares()[7];
                            campo[11][13] = equipoLocal.getTitulares()[8];

                            //Delanteros
                            campo[4][17] = equipoLocal.getTitulares()[9];
                            campo[7][19] = equipoLocal.getTitulares()[10];
                            break;
                        case "4-3-3":
                            //Centrocampistas
                            campo[4][13] = equipoLocal.getTitulares()[5];
                            campo[7][15] = equipoLocal.getTitulares()[6];
                            campo[11][13] = equipoLocal.getTitulares()[7];

                            //Delanteros
                            campo[4][17] = equipoLocal.getTitulares()[8];
                            campo[7][19] = equipoLocal.getTitulares()[9];
                            campo[9][16] = equipoLocal.getTitulares()[10];
                            break;
                    }
                    campo[7][19].setTieneBalon(true);

                    // COLOCO AL EQUIPO VISITANTE
                    // Portero
                    campo[7][21] = equipoVisitante.getTitulares()[0];
                    // Defensas
                    campo[12][20] = equipoVisitante.getTitulares()[1];
                    campo[10][17] = equipoVisitante.getTitulares()[2];
                    campo[5][16] = equipoVisitante.getTitulares()[3];
                    campo[2][20] = equipoVisitante.getTitulares()[4];
                    // Centrocampistas y delanteros
                    switch (equipoVisitante.getAlineacion()) {
                        case "4-4-2":
                            //Centrocampistas
                            campo[12][14] = equipoVisitante.getTitulares()[5];
                            campo[8][15] = equipoVisitante.getTitulares()[6];
                            campo[6][15] = equipoVisitante.getTitulares()[7];
                            campo[3][14] = equipoVisitante.getTitulares()[8];

                            //Delanteros
                            campo[8][9] = equipoVisitante.getTitulares()[9];
                            campo[6][9] = equipoVisitante.getTitulares()[10];
                            break;
                        case "4-3-3":
                            //Centrocampistas
                            campo[12][14] = equipoVisitante.getTitulares()[5];
                            campo[8][6] = equipoVisitante.getTitulares()[6];
                            campo[3][14] = equipoVisitante.getTitulares()[7];

                            //Delanteros
                            campo[8][9] = equipoVisitante.getTitulares()[8];
                            campo[6][6] = equipoVisitante.getTitulares()[9];
                            campo[6][9] = equipoVisitante.getTitulares()[10];
                            break;
                    }


                } else { // Si tira el equipo visitante
                    // COLOCO AL EQUIPO LOCAL
                    //Portero
                    campo[7][0] = equipoLocal.getTitulares()[0];
                    //Defensas
                    campo[2][1] = equipoLocal.getTitulares()[1];
                    campo[5][5] = equipoLocal.getTitulares()[2];
                    campo[10][4] = equipoLocal.getTitulares()[3];
                    campo[12][1] = equipoLocal.getTitulares()[4];
                    //Centrocampistas y delanteros
                    switch (equipoLocal.getAlineacion()) {
                        case "4-4-2":
                            //Centrocampistas
                            campo[3][7] = equipoLocal.getTitulares()[5];
                            campo[6][6] = equipoLocal.getTitulares()[6];
                            campo[8][6] = equipoLocal.getTitulares()[7];
                            campo[11][7] = equipoLocal.getTitulares()[8];

                            //Delanteros
                            campo[6][12] = equipoLocal.getTitulares()[9];
                            campo[8][12] = equipoLocal.getTitulares()[10];
                            break;
                        case "4-3-3":
                            //Centrocampistas
                            campo[3][7] = equipoLocal.getTitulares()[5];
                            campo[6][6] = equipoLocal.getTitulares()[6];
                            campo[11][7] = equipoLocal.getTitulares()[7];

                            //Delanteros
                            campo[6][12] = equipoLocal.getTitulares()[8];
                            campo[8][6] = equipoLocal.getTitulares()[9];
                            campo[8][12] = equipoLocal.getTitulares()[10];
                            break;
                    }

                    // COLOCO AL EQUIPO VISITANTE
                    // Portero
                    campo[7][21] = equipoVisitante.getTitulares()[0];
                    // Defensas
                    campo[12][12] = equipoVisitante.getTitulares()[1];
                    campo[9][14] = equipoVisitante.getTitulares()[2];
                    campo[5][14] = equipoVisitante.getTitulares()[3];
                    campo[2][12] = equipoVisitante.getTitulares()[4];
                    // Centrocampistas y delanteros
                    switch (equipoVisitante.getAlineacion()) {
                        case "4-4-2":
                            //Centrocampistas
                            campo[10][8] = equipoVisitante.getTitulares()[5];
                            campo[9][5] = equipoVisitante.getTitulares()[6];
                            campo[7][6] = equipoVisitante.getTitulares()[7];
                            campo[4][8] = equipoVisitante.getTitulares()[8];

                            //Delanteros
                            campo[7][2] = equipoVisitante.getTitulares()[9];
                            campo[4][4] = equipoVisitante.getTitulares()[10];
                            break;
                        case "4-3-3":
                            //Centrocampistas
                            campo[10][8] = equipoVisitante.getTitulares()[5];
                            campo[7][6] = equipoVisitante.getTitulares()[6];
                            campo[4][8] = equipoVisitante.getTitulares()[7];

                            //Delanteros
                            campo[9][5] = equipoVisitante.getTitulares()[8];
                            campo[7][2] = equipoVisitante.getTitulares()[9];
                            campo[4][4] = equipoVisitante.getTitulares()[10];
                            break;
                    }
                    campo[7][2].setTieneBalon(true);

                }
                break;
            default:

        }
    }


    public Jugador devolverJugador(int fila, int columna) {
        return campo[fila][columna];
    }


    public void moverJugador(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        campo[filaFinal][columnaFinal] = campo[filaInicial][columnaInicial];
        campo[filaInicial][columnaInicial] = null;
        actualizarCampoConsola();
    }

    public String tirarApuerta(int filaJugador, int columnaJugador) {
        int distancia;
        int jugadoresEnBarrera = 0;
        Jugador rematador = campo[filaJugador][columnaJugador]; // No deberia dar nullpointer (COMPROBAR)
        Portero portero = null;
        int remate;
        int parada;
        String resultado;

        //El jugador tira
        quitarBalon();

        if (turno) { // Calcula la distancia hasta la porteria derecha
            distancia = ComprobarAcciones.calcularDistanciaReal(filaJugador, columnaJugador, 7, 21);
            for (int i = 5; i < 10; i++) {
                if (campo[i][21] != null) { // Calcula cuantos defensas rivales hay en el area pequeña
                    if (ComprobarAcciones.hayRivalEn(this, i, 21)) {  // Comprueba si hay rival en el area pequeña
                        jugadoresEnBarrera += 1;
                        if (campo[i][21].getClass().getSimpleName().equals("Portero")) {// Si ademas es el portero cambia el booleano e inicializa el portero
                            portero = (Portero) campo[i][21];
                        }
                    }
                }
            }
        } else { // Calcula la distancia hasta la porteria izquierda
            distancia = ComprobarAcciones.calcularDistanciaReal(filaJugador, columnaJugador, 7, 0);
            for (int i = 5; i < 10; i++) {
                if (campo[i][0] != null) { // Calcula cuantos defensas rivales hay en el area pequeña
                    if (ComprobarAcciones.hayRivalEn(this, i, 0)) { // Comprueba si hay rival en el area pequeña
                        jugadoresEnBarrera += 1;
                        if (campo[i][0].getClass().getSimpleName().equals("Portero")) { // Si ademas es el portero cambia el booleano e inicializa el portero
                            portero = (Portero) campo[i][21];
                        }
                    }
                }
            }
        }

        // Calcula las estadisticas de tiro y de parada
        remate = (int) (Math.random() * (rematador.getSho() * (11 - distancia)));
        if (portero != null) {
            parada = (int) (Math.random() * (portero.getRef() * (distancia + jugadoresEnBarrera)));
        } else {
            parada = 0;
        }


        // Compara las estadisticas para ver si hay gol o no
        if (remate > parada) {
            System.out.println("Fue gol");
            if (turno) {
                goleadoresLocal = goleadoresLocal.concat(campo[filaJugador][columnaJugador].getNombre() + "\n");
                golesLocal++;
            } else {
                goleadoresVisitante = goleadoresVisitante.concat(campo[filaJugador][columnaJugador].getNombre() + "\n");
                golesVisitante++;
            }
        } else {
            System.out.println("No fue gol");
        }

        // Accion de los posibles resultados del tiro
        resultado = resultadoDelTiro(remate > parada, rematador);
        System.out.println(resultado);


        comprobarTurno();
        comprobarFinal();
        return resultado;
    }

    public String pasarBalon(int filaPasador, int columnaPasador, int filaReceptor, int columnaReceptor) {
        String resultado = "";
        int pase = (int) (Math.random() * campo[filaPasador][columnaPasador].getPas()) + 1;
        int probabilidad = (int) (Math.random() * 10) * ComprobarAcciones.calcularDistanciaReal(filaPasador, columnaPasador, filaReceptor, columnaReceptor);
        boolean interceptado = false;

        campo[filaPasador][columnaPasador].setTieneBalon(false);
        if (!ComprobarAcciones.esFueraDeJuego(this, filaReceptor, columnaReceptor, columnaPasador)) {
            if (pase >= probabilidad) { // Si el pase es bueno
                campo[filaReceptor][columnaReceptor].setTieneBalon(true);
            } else { // Si el pase es malo
                if (ComprobarAcciones.hayRivalAlrededor(this, filaReceptor, columnaReceptor, turno)) { // Si hay rival cerca del receptor
                    for (int i = 0; i < 4; i++) { // 1/4 de que el balon caiga en el rival
                        int fila = (int) (Math.random() * 3) + filaReceptor - 1;
                        int columna = (int) (Math.random() * 3) + columnaReceptor - 1;

                        if (ComprobarAcciones.hayRivalEn(this, fila, columna)) {
                            campo[fila][columna].setTieneBalon(true);
                            interceptado = true;
                            resultado = campo[fila][columna].getNombre() + "\ninterceptó el pase";
                            break;
                        }
                    }
                }
                if (!interceptado) { // Si el balon sale de banda
                    // Quito al receptor de la banda si lo hubiera
                    int filaBanda;
                    if (filaReceptor < 7) {
                        filaBanda = 0;
                    } else {
                        filaBanda = 14;
                    }
                    apartarJugador(filaBanda, columnaReceptor);

                    // Pongo al rival para sacar
                    if (turno) { // Si el equipo local falla el pase
                        int sacador;
                        if (filaBanda == 0) {
                            sacador = 7;
                        } else {
                            sacador = 5;
                        }
                        while (equipoVisitante.getTitulares()[sacador] == null) {
                            sacador++;
                        }
                        for (int i = 0; i < campo.length; i++) {
                            for (int j = 0; j < campo[0].length; j++) {
                                if (campo[i][j] == equipoVisitante.getTitulares()[sacador]) {
                                    campo[i][j].setTieneBalon(true);
                                    moverJugador(i, j, filaBanda, columnaReceptor);
                                    i = campo.length;
                                    j = campo[0].length;
                                    break;
                                }
                            }
                        }
                    } else { // Si el equipo visitante falla el pase
                        int sacador;
                        if (filaBanda == 0) {
                            sacador = 5;
                        } else {
                            sacador = 7;
                        }
                        while (equipoLocal.getTitulares()[sacador] == null) {
                            sacador++;
                        }
                        for (int i = 0; i < campo.length; i++) {
                            for (int j = 0; j < campo[0].length; j++) {
                                if (campo[i][j] == equipoLocal.getTitulares()[sacador]) {
                                    campo[i][j].setTieneBalon(true);
                                    moverJugador(i, j, filaBanda, columnaReceptor);
                                    i = campo.length;
                                    j = campo[0].length;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (interceptado) {
            } else {
                if (pase >= probabilidad) {
                    resultado = devolverJugador(filaPasador, columnaPasador).getNombre() + " para \n" + devolverJugador(filaReceptor, columnaReceptor).getNombre();
                } else {
                    resultado = devolverJugador(filaPasador, columnaPasador).getNombre() + " midió mal y el \nbalón salió de banda";
                }
            }
            if (pase < probabilidad) {
                PA = 0;
                comprobarTurno(); // Cambia el turno
            } else {
                PA--;
            }
        } else { // Si es fuera de juego
            resultado = "Fuera de juego";
            colocarSaqueFueraDeJuego(filaReceptor, columnaReceptor);
        }

        return resultado;

    }

    private void colocarSaqueFueraDeJuego(int fila, int columna) {
        boolean colocado = false;
        Jugador[] titulares;

        quitarBalon();
        apartarJugador(fila, columna);
        if (turno){
            titulares = equipoVisitante.getTitulares();
        } else {
            titulares = equipoLocal.getTitulares();
        }
        do {
            int pos = (int) (Math.random()*11);
            if (titulares[pos] != null){
                for (int i = 0; i < campo.length; i++) {
                    for (int j = 0; j < campo[0].length; j++) {
                        if (campo[i][j] == titulares[pos]){
                            moverJugador(i, j, fila, columna);
                            colocado = true;
                        }
                    }
                }
            }
        } while (!colocado);
        campo[fila][columna].setTieneBalon(true);
        PA = 0;
    }

    public String resultadoDelTiro(boolean esGol, Jugador rematador) {
        String resultado = null;
        int random;
        if (esGol) {
            random = (int) (Math.random() * 100);
            if (random == 0) {
                boolean salir = false;
                do {
                    random = (int) (Math.random() * 5 + 5);
                    if (turno) {
                        if (ComprobarAcciones.hayRivalEn(this, random, 21)) {
                            resultado = "gol en propia\n de " + campo[random][21].getNombre();
                            salir = true;
                        } else {
                            if (ComprobarAcciones.hayRivalEn(this, random, 0)) {
                                resultado = "gol en propia\n de " + campo[random][0].getNombre();
                                salir = true;
                            }
                        }
                    }
                } while (!salir);
            } else {
                resultado = "GOL DE " + rematador.getNombre().toUpperCase();
                PA = 0;
                comprobarTurno();
            }
            cargarJugadoresEnCampoRAM(Jugada.SAQUE_CENTRO);
        } else {
            random = (int) (Math.random() * 15 + 1);
            switch (random) {
                case 1, 2, 3:
                    resultado = rematador.getNombre() + " la mandó fuera";
                    PA = 0;
                    comprobarTurno();
                    cargarJugadoresEnCampoRAM(Jugada.SAQUE_PUERTA);
                    break;
                case 4:
                    resultado = "A " + rematador.getNombre() + " se le fue alta";
                    PA = 0;
                    comprobarTurno();
                    cargarJugadoresEnCampoRAM(Jugada.SAQUE_PUERTA);
                    break;
                case 5, 6, 7:
                    resultado = rematador.getNombre() + " tiró al muñeco";
                    PA = 0;
                    comprobarTurno();
                    if (turno) {
                        campo[7][0].setTieneBalon(true);
                    } else {
                        campo[7][21].setTieneBalon(true);
                    }
                    break;
                case 8, 9:
                    resultado = rematador.getNombre() + " le dio al\n palo y salió fuera";
                    PA = 0;
                    comprobarTurno();
                    cargarJugadoresEnCampoRAM(Jugada.SAQUE_PUERTA);
                    break;
                case 10, 11:
                    resultado = rematador.getNombre() + " le dio al\n palo y rebotó";
                    hacerRechace();
                    break;
                case 12:
                    resultado = rematador.getNombre() + " le dio al\n larguero y salió fuera";
                    PA = 0;
                    comprobarTurno();
                    cargarJugadoresEnCampoRAM(Jugada.SAQUE_PUERTA);
                    break;
                case 13:
                    resultado = rematador.getNombre() + " le dio al\n larguero y rebotó";
                    hacerRechace();
                    break;
                case 14:
                    resultado = rematador.getNombre() + " le dio a\n la cruceta y rebotó";
                    hacerRechace();
                    break;
                case 15:
                    resultado = rematador.getNombre() + " tiró pero\n salió de córner";
                    cargarJugadoresEnCampoRAM(Jugada.CORNER);
                    break;
            }
        }
        return resultado;
    }

    private void hacerRechace() {
        boolean salir = false;
        boolean hayJugadorEnElArea = false;
        for (int i = 3; i < 12; i++) {// Comprueba si hay jugadores en el area
            if (turno) {
                for (int j = 0; j < 4; j++) { // Comprueba el area visitante
                    if (ComprobarAcciones.hayJugadorEn(campo, i, j)) {
                        hayJugadorEnElArea = true;
                        break;
                    }
                }
            } else { // Comprueba el area local
                for (int j = 18; j < 22; j++) { // Comprueba el area visitante
                    if (ComprobarAcciones.hayJugadorEn(campo, i, j)) {
                        hayJugadorEnElArea = true;
                        break;
                    }
                }
            }
        }
        if (hayJugadorEnElArea) {
            System.out.println("Hay jugador en el area"); // BORRAR
            while (!salir) {
                int fila = (int) (Math.random() * 9 + 3);
                int columna = (int) (Math.random() * 4);
                if (turno) {
                    columna = columna + 18;
                }
                if (ComprobarAcciones.hayJugadorEn(campo, fila, columna)) {
                    campo[fila][columna].setTieneBalon(true);
                    salir = true;
                    if (!ComprobarAcciones.hayRivalEn(this, fila, columna)) { // Si le cae a un atacante le suma un PA
                        PA++;
                    } else {
                        PA = 0;
                    }
                }
            }
        } else {
            // El balon se queda botando y sale de fondo
            System.out.println("El balon reboto pero boto en el campo y salio por la linea de fondo");
            PA = 0;
            comprobarTurno();
            cargarJugadoresEnCampoRAM(Jugada.SAQUE_PUERTA);
        }

    }

    public String regatear(int filaRegateador, int columnaRegateador, int filaDefensor, int columnaDefensor) {
        String resultado = "";
        int regate = (int) (Math.random() * campo[filaRegateador][columnaRegateador].getDri() + 1);
        int defensa = (int) (Math.random() * campo[filaDefensor][columnaDefensor].getDef() + 1);

        if (regate > defensa) { // Si el regate es exitoso
            Jugador aux = campo[filaDefensor][columnaDefensor];
            resultado = campo[filaRegateador][columnaRegateador].getNombre() + " se fue de \n" + campo[filaDefensor][columnaDefensor].getNombre();
            campo[filaDefensor][columnaDefensor] = campo[filaRegateador][columnaRegateador];
            campo[filaRegateador][columnaRegateador] = aux;
        } else { // Si el regate no es exitoso
            resultado = campo[filaDefensor][columnaDefensor].getNombre() + " se la quitó a \n" + campo[filaRegateador][columnaRegateador].getNombre();
            Jugador aux = campo[filaRegateador][columnaRegateador];
            campo[filaRegateador][columnaRegateador].setTieneBalon(false);
            campo[filaDefensor][columnaDefensor].setTieneBalon(true);
            campo[filaRegateador][columnaRegateador] = campo[filaDefensor][columnaDefensor];
            campo[filaDefensor][columnaDefensor] = aux;
            PA = 0;
        }
        comprobarTurno();
        return resultado;
    }

    public String hacerEntrada(int filaDefensa, int columnaDefensa, int filaDelantero, int columnaDelantero) {
        //HACER LESION
        String resultado = "";
        boolean falta = false;
        boolean roja = false;
        int entrada = (int) (Math.random() * campo[filaDefensa][columnaDefensa].getDef() + 1);
        int reflejos = (int) (Math.random() * campo[filaDelantero][columnaDelantero].getPac() + 1);
        int fuerzaDefensa = (int) (Math.random() * campo[filaDefensa][columnaDefensa].getPhy() + 1);
        int fuerzaDelantero = (int) (Math.random() * campo[filaDelantero][columnaDelantero].getPhy() + 1);

        if (campo[filaDelantero][columnaDelantero].isTieneBalon()) { // Si el delantero tiene el balon
            if (entrada > reflejos) { // Si la entrada es exitosa
                resultado = campo[filaDefensa][columnaDefensa].getNombre() + " se la robó a \n" + campo[filaDelantero][columnaDelantero].getNombre();
                campo[filaDelantero][columnaDelantero].setTieneBalon(false);
                campo[filaDefensa][columnaDefensa].setTieneBalon(true);
            } else { // Si la entrada no es exitosa
                if (entrada <= 10) { // Si es menor o igual que 10 se saca roja
                    resultado = campo[filaDefensa][columnaDefensa].getNombre() + " le clavó los\n tacos a " + campo[filaDelantero][columnaDelantero].getNombre() + ", ROJA";
                    System.out.println(campo[filaDefensa][columnaDefensa].getNombre() + " clavo los tacos, roja");
                    roja = true;
                } else if (entrada <= 30) { // Si es menor o igual que 30 se saca amarilla
                    if (!campo[filaDefensa][columnaDefensa].isTieneAmarilla()) { // Si no tiene amarilla
                        resultado = campo[filaDefensa][columnaDefensa].getNombre() + " pisó a \n" + campo[filaDelantero][columnaDelantero].getNombre() + ", AMARILLA";
                        System.out.println(campo[filaDefensa][columnaDefensa].getNombre() + " pisó a" + campo[filaDelantero][columnaDelantero].getNombre() + ", amarilla");
                        campo[filaDefensa][columnaDefensa].setTieneAmarilla(true);
                    } else { // Si tiene amarilla (doble amarilla)
                        resultado = campo[filaDefensa][columnaDefensa].getNombre() + " recibió doble amarilla\n y va a ser expulsado";
                        System.out.println(campo[filaDefensa][columnaDefensa].getNombre() + " cometió dos faltas de amarilla, roja");
                        roja = true;
                    }
                } else {
                    resultado = campo[filaDefensa][columnaDefensa].getNombre() + " hizo falta a \n" + campo[filaDelantero][columnaDelantero].getNombre();
                }
                falta = true;
            }
        } else { // Si el delantero no tiene el balon
            resultado = campo[filaDefensa][columnaDefensa].getNombre() + " agredió a \n" + campo[filaDelantero][columnaDelantero].getNombre() + ", ROJA";
            System.out.println(campo[filaDefensa][columnaDefensa].getNombre() + " hizo entrada a un jugador sin balon, roja");
            roja = true;
            falta = true;
        }
        if (roja) {
            if (turno) {
                equipoLocal.getPlantilla().add(campo[filaDefensa][columnaDefensa]);
                for (int i = 0; i < equipoLocal.getTitulares().length; i++) {
                    if (equipoLocal.getTitulares()[i] == campo[filaDefensa][columnaDefensa]) {
                        equipoLocal.getTitulares()[i] = null;
                    }
                }
            } else {
                equipoVisitante.getPlantilla().add(campo[filaDefensa][columnaDefensa]);
                for (int i = 0; i < equipoVisitante.getTitulares().length; i++) {
                    if (equipoVisitante.getTitulares()[i] == campo[filaDefensa][columnaDefensa]) {
                        equipoVisitante.getTitulares()[i] = null;
                    }
                }
            }
            campo[filaDefensa][columnaDefensa] = null;
        }
        if (falta) {

            quitarBalon();
            PA = 0;
            comprobarTurno();
            if (ComprobarAcciones.esPenalti(turno, filaDelantero, columnaDelantero)) {
                resultado = resultado.concat(", PENALTI");
                System.out.println("PENALTI");
                cargarJugadoresEnCampoRAM(Jugada.PENALTI);
            } else {
                campo[filaDelantero][columnaDelantero].setTieneBalon(true);
            }

        } else {
            comprobarTurno();
        }
        comprobarFinal();
        return resultado;


    }

    private void quitarBalon() {
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[0].length; j++) {
                if (campo[i][j] != null) {
                    campo[i][j].setTieneBalon(false);
                }
            }
        }
    }

    private void apartarJugador(int fila, int columna) {
        if (campo[fila][columna] != null) {
            boolean movido = false;
            while (!movido) {
                int filaRandom = (int) (Math.random() * 14);
                int columnaRandom = (int) (Math.random() * 21);


                if (campo[filaRandom][columnaRandom] == null) {
                    moverJugador(fila, columna, filaRandom, columnaRandom);
                    movido = true;
                }
            }
        }
    }

    public void rendirse() {
        if (turno) {
            golesVisitante = 4;
        } else {
            golesLocal = 4;
        }
    }

    public void finalizarPartido() {
        guardarPartido();
        resetearEquipos();
    }


    private void resetearEquipos() {
        equipoLocal.getPlantilla().forEach(j -> {
            j.setTieneAmarilla(false);
            j.setTieneBalon(false);
        });
        equipoVisitante.getPlantilla().forEach(j -> {
            j.setTieneAmarilla(false);
            j.setTieneBalon(false);
        });
    }


    private void guardarPartido() {
        try {
            FileWriter fileWriter = new FileWriter("partidosGuardados.txt", true);
            String resultado = "| " + equipoLocal.getNombre() + " " + golesLocal + " - " + golesVisitante + " " + equipoVisitante.getNombre() + " |";
            String fecha = "|";
            int divisorFecha = equipoLocal.getNombre().length();
            int divisorFechaIzquierda = equipoLocal.getNombre().length() + equipoVisitante.getNombre().length() - divisorFecha - 1;

            for (int i = 0; i < divisorFecha; i++) {
                fecha = fecha.concat(" ");
            }
            fecha = fecha.concat(fechaInicioPartido.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            for (int i = 0; i < divisorFechaIzquierda; i++) {
                fecha = fecha.concat(" ");
            }
            fecha = fecha.concat("|");
            for (int i = 0; i < resultado.length(); i++) {
                fileWriter.write("-");
            }
            fileWriter.write('\n' + fecha);
            fileWriter.write('\n' + resultado + '\n');
            for (int i = 0; i < resultado.length(); i++) {
                fileWriter.write("-");
            }
            fileWriter.write("\n");
            fileWriter.close();
            System.out.println("Partido guardado en el fichero correctamente");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
