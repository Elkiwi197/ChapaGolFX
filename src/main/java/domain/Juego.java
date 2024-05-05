package domain;

import common.Jugada;

public class Juego {
    private Jugador[][] campo = new Jugador[15][22];
    private Equipo equipoLocal = new Equipo(); //J1
    private Equipo equipoVisitante = new Equipo(); //J2
    private boolean turno; // True = local, false = visitante
    private int golesLocal;
    private int golesVisitante;
    private int PA;

    public Juego() {
    }

    public Jugador[][] getCampo() {
        return campo;
    }

    public void setCampo(Jugador[][] campo) {
        this.campo = campo;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public int getPA() {
        return PA;
    }

    public void setPA(int PA) {
        this.PA = PA;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public void comprobarTurno() {
        if (PA == 0) {
            PA = 5;
            turno = !turno;
        }
    }

    public void jugarAmigo(Equipo local, Equipo visitante) {
        turno = true;
        equipoLocal = local;
        equipoVisitante = visitante;

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
                            campo[6][10] = equipoLocal.getTitulares()[9];
                            campo[7][10] = equipoLocal.getTitulares()[10];
                            campo[7][10].setTieneBalon(true);
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
                        campo[7][0].setTieneBalon(true);
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
                        campo[7][0].setTieneBalon(true);
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

    public void tirarApuerta(int filaJugador, int columnaJugador) {
        int distancia;
        int jugadoresEnBarrera = 0;
        boolean hayPortero = false;
        Jugador rematador = campo[filaJugador][columnaJugador]; // No deberia dar nullpointer (COMPROBAR)
        Portero portero = null;
        int remate;
        int parada;
        String resultado;

        if (turno) { // Calcula la distancia hasta la porteria derecha
            distancia = ComprobarAcciones.calcularDistanciaReal(filaJugador, columnaJugador, 7, 21);
            for (int i = 5; i < 10; i++) {
                if (campo[i][21] != null) { // Calcula cuantos defensas rivales hay en el area pequeña
                    if (ComprobarAcciones.hayRivalEn(this, i, 21)) {  // Comprueba si hay rival en el area pequeña
                        jugadoresEnBarrera += 1;
                        if (campo[i][21].getClass().getSimpleName().equals("Portero")) {// Si ademas es el portero cambia el booleano e inicializa el portero
                            hayPortero = true;
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
                            hayPortero = true;
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

        //El jugador tira
        campo[filaJugador][columnaJugador].setTieneBalon(false);
        // Compara las estadisticas para ver si hay gol o no
        if (remate > parada) {
            System.out.println("Fue gol");
            if (turno) {
                golesLocal++;
            } else {
                golesVisitante++;
            }
        } else {
            System.out.println("No fue gol");
        }

        // Accion de los posibles resultados del tiro
        resultado = resultadoDelTiro(remate > parada);
        System.out.println(resultado);
        if (resultado.contains("rebote")) {
            hacerRechace();
        } else if (resultado.contains("fuera")) {
            PA = 0;
            comprobarTurno();
            cargarJugadoresEnCampoRAM(Jugada.SAQUE_PUERTA);
        } else if (resultado.contains("gol")) {
            PA = 0;
            comprobarTurno();
            cargarJugadoresEnCampoRAM(Jugada.SAQUE_CENTRO);
        } else if (resultado.contains("corner")) {
            cargarJugadoresEnCampoRAM(Jugada.CORNER);
        } else if (resultado.contains("portero")) {
            PA = 0;
            comprobarTurno();
            if (turno) {
                campo[7][0].setTieneBalon(true);
            } else {
                campo[7][21].setTieneBalon(true);
            }
        }

        comprobarTurno();
    }

    public void pasarBalon(int filaPasador, int columnaPasador, int filaReceptor, int columnaReceptor) {
        int pase = (int) (Math.random() * campo[filaPasador][columnaPasador].getPas()) + 1;
        int probabilidad = (int) (Math.random() * 10) * ComprobarAcciones.calcularDistanciaReal(filaPasador, columnaPasador, filaReceptor, columnaReceptor);
        boolean interceptado = false;

        campo[filaPasador][columnaPasador].setTieneBalon(false);
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
                if (campo[filaBanda][columnaReceptor] != null) {
                    boolean movido = false;
                    while (!movido) {
                        int filaRandom = (int) (Math.random() * 14);
                        int columnaRandom = (int) (Math.random() * 21);


                        if (campo[filaRandom][columnaRandom] == null) {
                            moverJugador(filaBanda, columnaReceptor, filaRandom, columnaRandom);
                            movido = true;
                        }
                    }
                }

                // Pongo al rival para sacar
                if (turno) { // Si el equipo local falla el pase
                    for (int i = 0; i < campo.length; i++) {
                        for (int j = 0; j < campo[0].length; j++) {
                            if (filaReceptor < 7) { // Si es la banda de arriba
                                if (campo[i][j] == equipoVisitante.getTitulares()[5]) {
                                    campo[i][j].setTieneBalon(true);
                                    moverJugador(i, j, 0, columnaReceptor);
                                    i = campo.length;
                                    j = campo[0].length;
                                    break;
                                }
                            } else { // Si es la banda de abajo
                                if (campo[i][j] == equipoVisitante.getTitulares()[7]) {
                                    campo[i][j].setTieneBalon(true);
                                    moverJugador(i, j, 14, columnaReceptor);
                                    i = campo.length;
                                    j = campo[0].length;
                                    break;
                                }
                            }
                        }
                    }
                } else { // Si el equipo visitante falla el pase
                    for (int i = 0; i < campo.length; i++) {
                        for (int j = 0; j < campo[0].length; j++) {
                            if (filaReceptor < 7) { // Si es la banda de arriba
                                if (campo[i][j] == equipoLocal.getTitulares()[7]) {
                                    campo[i][j].setTieneBalon(true);
                                    moverJugador(i, j, 0, columnaReceptor);
                                    i = campo.length;
                                    j = campo[0].length;
                                    break;
                                }
                            } else { // Si es la banda de abajo
                                if (campo[i][j] == equipoLocal.getTitulares()[5]) {
                                    campo[i][j].setTieneBalon(true);
                                    moverJugador(i, j, 14, columnaReceptor);
                                    i = campo.length;
                                    j = campo[0].length;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (interceptado) {
            System.out.println("Pase interceptado");
        } else {
            if (pase >= probabilidad) {
                System.out.println("Pase correcto");
            } else {
                System.out.println("Salio de banda");
            }
        }
        if (pase < probabilidad) {
            PA = 0;
            comprobarTurno(); // Cambia el turno
        } else {
            PA--;
        }

    }

    public String resultadoDelTiro(boolean esGol) {
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
                            resultado = "gol en propia de " + campo[random][21].getNombre();
                            salir = true;
                        } else {
                            if (ComprobarAcciones.hayRivalEn(this, random, 0)) {
                                resultado = "gol en propia de " + campo[random][0].getNombre();
                                salir = true;
                            }
                        }
                    }
                } while (!salir);
            } else {
                resultado = "gol";
            }
        } else {
            random = (int) (Math.random() * 15 + 1);
            switch (random) {
                case 1, 2, 3:
                    resultado = "fuera";
                    break;
                case 4:
                    resultado = "alta y fuera";
                    break;
                case 5, 6, 7:
                    resultado = "parada del portero";
                    break;
                case 8:
                    resultado = "palo y fuera";
                    break;
                case 9, 10:
                    resultado = "palo y rebote";
                    break;
                case 11:
                    resultado = "larguero y fuera";
                    break;
                case 12:
                    resultado = "larguero y rebote";
                    break;
                case 13:
                    resultado = "cruceta y rebote";
                    break;
                case 14, 15:
                    resultado = "corner";
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
            System.out.println("NO HAY JUGADOR EN EL AREA"); // BORRAR
            System.out.println("El balon reboto pero boto en el campo y salio por la linea de fondo");
            PA = 0;
            comprobarTurno();
            cargarJugadoresEnCampoRAM(Jugada.SAQUE_PUERTA);
        }

    }

    public void regatear(int filaRegateador, int columnaRegateador, int filaDefensor, int columnaDefensor) {
        int regate = (int) (Math.random() * campo[filaRegateador][columnaRegateador].getDri() + 1);
        int defensa = (int) (Math.random() * campo[filaDefensor][columnaDefensor].getDef() + 1);

        if (regate > defensa) { // Si el regate es exitoso
            Jugador aux = campo[filaDefensor][columnaDefensor];
            campo[filaDefensor][columnaDefensor] = campo[filaRegateador][columnaRegateador];
            campo[filaRegateador][columnaRegateador] = aux;
        } else { // Si el regate no es exitoso
            Jugador aux = campo[filaRegateador][columnaRegateador];
            campo[filaRegateador][columnaRegateador].setTieneBalon(false);
            campo[filaDefensor][columnaDefensor].setTieneBalon(true);
            campo[filaRegateador][columnaRegateador] = campo[filaDefensor][columnaDefensor];
            campo[filaDefensor][columnaDefensor] = aux;
            PA = 0;
        }
        comprobarTurno();

    }

    public void hacerEntrada(int filaDefensa, int columnaDefensa, int filaDelantero, int columnaDelantero) {
        boolean falta = false;
        int entrada = (int) (Math.random() * campo[filaDefensa][columnaDefensa].getDef() + 1);
        int reflejos = (int) (Math.random() * campo[filaDelantero][columnaDelantero].getPac() + 1);
        int fuerzaDefensa = (int) (Math.random() * campo[filaDefensa][columnaDefensa].getPhy() + 1);
        int fuerzaDelantero = (int) (Math.random() * campo[filaDelantero][columnaDelantero].getPhy() + 1);

        if (campo[filaDelantero][columnaDelantero].isTieneBalon()) { // Si el delantero tiene el balon
            if (entrada > reflejos) { // Si la entrada es exitosa
                campo[filaDelantero][columnaDelantero].setTieneBalon(false);
                campo[filaDefensa][columnaDefensa].setTieneBalon(true);
            } else { // Si la entrada no es exitosa
                if (entrada <= 10) { // Si es menor o igual que 10 se saca roja
                    System.out.println(campo[filaDefensa][columnaDefensa].getNombre() + " clavo los tacos, roja");
                    campo[filaDefensa][columnaDefensa] = null;
                } else if (entrada <= 30) { // Si es menor o igual que 30 se saca amarilla
                    if (!campo[filaDefensa][columnaDefensa].isTieneAmarilla()) { // Si no tiene amarilla
                        System.out.println(campo[filaDefensa][columnaDefensa].getNombre() + " pisó a" + campo[filaDelantero][columnaDelantero].getNombre() + ", amarilla");
                        campo[filaDefensa][columnaDefensa].setTieneAmarilla(true);
                    } else { // Si tiene amarilla (doble amarilla)
                        System.out.println(campo[filaDefensa][columnaDefensa].getNombre() + " cometió dos faltas de amarilla, roja");
                        campo[filaDefensa][columnaDefensa].setTieneAmarilla(false);
                        campo[filaDefensa][columnaDefensa] = null;
                    }
                }
                falta = true;
            }
        } else { // Si el delantero no tiene el balon
            System.out.println(campo[filaDefensa][columnaDefensa].getNombre() + " hizo entrada a un jugador sin balon, roja");
            campo[filaDefensa][columnaDefensa] = null;
            falta = true;
        }
        if (falta) {
            quitarBalon();
            PA = 0;
            comprobarTurno();
            if (ComprobarAcciones.esPenalti(turno, filaDelantero, columnaDelantero)) {
                System.out.println("PENALTI");
                cargarJugadoresEnCampoRAM(Jugada.PENALTI);
            } else {
                campo[filaDelantero][columnaDelantero].setTieneBalon(true);
            }

        } else {
            comprobarTurno();
        }


    }

    private void quitarBalon() {
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[0].length; j++) {
                if (campo[i][j] != null) {
                    if (campo[i][j].isTieneBalon()) {
                        campo[i][j].setTieneBalon(false);
                    }
                }
            }
        }
    }
}
