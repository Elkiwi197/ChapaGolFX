package domain;

import common.Jugada;

public class Juego {
    private Jugador[][] campo = new Jugador[15][22];
    private Equipo equipoLocal = new Equipo(); //J1
    private Equipo equipoVisitante = new Equipo(); //J2
    private boolean turno; // True = local, false = visitante
    private int PA;

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

    public void jugarAmigo(Equipo local, Equipo visitante) {
        turno = true;
        equipoLocal = local;
        equipoVisitante = visitante;

        cargarJugadoresEnCampoRAM(local, visitante, Jugada.SAQUE_CENTRO, turno);
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

    private void cargarJugadoresEnCampoRAM(Equipo local, Equipo visitante, Jugada tipoJugada, boolean turno) {

        switch (tipoJugada) {
            case SAQUE_CENTRO:
                if (turno) { // Si saca el equipo local
                    switch (local.getAlineacion()) {
                        case "4-4-2":
                            //Portero
                            campo[7][0] = local.getTitulares()[0];
                            //Defensas
                            campo[4][4] = local.getTitulares()[1];
                            campo[6][4] = local.getTitulares()[2];
                            campo[8][4] = local.getTitulares()[3];
                            campo[10][4] = local.getTitulares()[4];
                            //Centrocampistas
                            campo[4][6] = local.getTitulares()[5];
                            campo[6][6] = local.getTitulares()[6];
                            campo[8][6] = local.getTitulares()[7];
                            campo[10][6] = local.getTitulares()[8];
                            //Delanteros
                            campo[6][10] = local.getTitulares()[9];
                            campo[7][10] = local.getTitulares()[10];
                            campo[7][10].setTieneBalon(true);
                            break;
                        case "4-3-3":
                            //Portero
                            campo[7][0] = local.getTitulares()[0];
                            //Defensas
                            campo[4][4] = local.getTitulares()[1];
                            campo[6][4] = local.getTitulares()[2];
                            campo[8][4] = local.getTitulares()[3];
                            campo[10][4] = local.getTitulares()[4];
                            //Centrocampistas
                            campo[5][6] = local.getTitulares()[5];
                            campo[7][6] = local.getTitulares()[6];
                            campo[9][6] = local.getTitulares()[7];
                            //Delanteros
                            campo[7][10] = local.getTitulares()[8];
                            campo[7][8] = local.getTitulares()[9];
                            campo[8][10] = local.getTitulares()[10];
                            campo[7][10].setTieneBalon(true);
                            break;
                    }

                    // Coloco al equipo visitante
                    switch (visitante.getAlineacion()) {
                        case "4-4-2":
                            // Portero
                            campo[7][21] = visitante.getTitulares()[0];
                            // Defensas
                            campo[10][17] = visitante.getTitulares()[1];
                            campo[8][17] = visitante.getTitulares()[2];
                            campo[6][17] = visitante.getTitulares()[3];
                            campo[4][17] = visitante.getTitulares()[4];
                            // Centrocampistas
                            campo[10][15] = visitante.getTitulares()[5];
                            campo[8][15] = visitante.getTitulares()[6];
                            campo[6][15] = visitante.getTitulares()[7];
                            campo[4][15] = visitante.getTitulares()[8];
                            //Delanteros
                            campo[8][13] = visitante.getTitulares()[9];
                            campo[6][13] = visitante.getTitulares()[10];
                            break;
                        case "4-3-3":
                            // Portero
                            campo[7][21] = visitante.getTitulares()[0];
                            // Defensas
                            campo[10][17] = visitante.getTitulares()[1];
                            campo[8][17] = visitante.getTitulares()[2];
                            campo[6][17] = visitante.getTitulares()[3];
                            campo[4][17] = visitante.getTitulares()[4];
                            // Centrocampistas
                            campo[9][15] = visitante.getTitulares()[5];
                            campo[7][15] = visitante.getTitulares()[6];
                            campo[5][15] = visitante.getTitulares()[7];
                            //Delanteros
                            campo[9][13] = visitante.getTitulares()[8];
                            campo[7][13] = visitante.getTitulares()[9];
                            campo[5][13] = visitante.getTitulares()[10];
                            break;
                        default:

                    }
                } else { // Si saca el equipo visitante
                    switch (local.getAlineacion()) { // Coloco al equipo local
                        case "4-4-2":
                            //Portero
                            campo[7][0] = local.getTitulares()[0];
                            //Defensas
                            campo[4][4] = local.getTitulares()[1];
                            campo[6][4] = local.getTitulares()[2];
                            campo[8][4] = local.getTitulares()[3];
                            campo[10][4] = local.getTitulares()[4];
                            //Centrocampistas
                            campo[4][6] = local.getTitulares()[5];
                            campo[6][6] = local.getTitulares()[6];
                            campo[8][6] = local.getTitulares()[7];
                            campo[10][6] = local.getTitulares()[8];
                            //Delanteros
                            campo[6][8] = local.getTitulares()[9];
                            campo[8][8] = local.getTitulares()[10];
                            break;
                        case "4-3-3":
                            //Portero
                            campo[7][0] = local.getTitulares()[0];
                            //Defensas
                            campo[4][4] = local.getTitulares()[1];
                            campo[6][4] = local.getTitulares()[2];
                            campo[8][4] = local.getTitulares()[3];
                            campo[10][4] = local.getTitulares()[4];
                            //Centrocampistas
                            campo[5][6] = local.getTitulares()[5];
                            campo[7][6] = local.getTitulares()[6];
                            campo[9][6] = local.getTitulares()[7];
                            //Delanteros
                            campo[5][8] = local.getTitulares()[8];
                            campo[7][8] = local.getTitulares()[9];
                            campo[9][8] = local.getTitulares()[10];
                            break;
                    }
                    switch (visitante.getAlineacion()) { // Coloco al equipo visitante

                        case "4-4-2":
                            // Portero
                            campo[7][21] = visitante.getTitulares()[0];
                            // Defensas
                            campo[10][17] = visitante.getTitulares()[1];
                            campo[8][17] = visitante.getTitulares()[2];
                            campo[6][17] = visitante.getTitulares()[3];
                            campo[4][17] = visitante.getTitulares()[4];
                            // Centrocampistas
                            campo[10][15] = visitante.getTitulares()[5];
                            campo[8][15] = visitante.getTitulares()[6];
                            campo[6][15] = visitante.getTitulares()[7];
                            campo[4][15] = visitante.getTitulares()[8];
                            //Delanteros
                            campo[8][11] = visitante.getTitulares()[9];
                            campo[7][11] = visitante.getTitulares()[10];
                            campo[7][11].setTieneBalon(true);
                            break;
                        case "4-3-3":
                            // Portero
                            campo[7][21] = visitante.getTitulares()[0];
                            // Defensas
                            campo[10][17] = visitante.getTitulares()[1];
                            campo[8][17] = visitante.getTitulares()[2];
                            campo[6][17] = visitante.getTitulares()[3];
                            campo[4][17] = visitante.getTitulares()[4];
                            // Centrocampistas
                            campo[9][15] = visitante.getTitulares()[5];
                            campo[7][15] = visitante.getTitulares()[6];
                            campo[5][15] = visitante.getTitulares()[7];
                            //Delanteros
                            campo[6][11] = visitante.getTitulares()[8];
                            campo[7][13] = visitante.getTitulares()[9];
                            campo[7][11] = visitante.getTitulares()[10];
                            campo[7][11].setTieneBalon(true);
                            break;
                        default:
                    }
                }
                break;
            case SAQUE_PUERTA:

                break;
            case CORNER:

                break;
            case PENALTI:
                break;
            default:

        }

    }


    public boolean hayJugadorEn(int fila, int columna) {
        return campo[fila][columna] != null;
    }

    public Jugador devolverJugador(int fila, int columna) {
        return campo[fila][columna];
    }

    /*
    Metodo que recibe coordenadas de un jugador y devuelve si es su turno o no
     */
    public boolean esTurnoDeJugador(int fila, int columna) {
        boolean esSuTurno = false;
        Jugador jugadorSeleccionado = campo[fila][columna];
        if (turno) {
            for (Jugador jugador : equipoLocal.getPlantilla()) {
                if (jugador == jugadorSeleccionado) {
                    esSuTurno = true;
                }
            }
        } else {
            for (Jugador jugador : equipoVisitante.getPlantilla()) {
                if (jugador == jugadorSeleccionado) {
                    esSuTurno = true;
                }
            }
        }
        return esSuTurno;
    }

    public boolean hayRivalAlrededor(int fila, int columna, boolean turno) {
        boolean hayRival = false;
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (i >= 0 && i <= 14 && j >= 0 && j <= 21) { // Evito el OutOfBoundsException
                    if (hayJugadorEn(fila, columna)) {
                        if (turno) { // Si es el turno de locales recorro plantilla de visitantes
                            for (Jugador rival : equipoVisitante.getPlantilla()) {
                                if (rival == devolverJugador(i, j)) {
                                    hayRival = true;
                                }
                            }
                        } else { // Si es el turno de visitantes recorro plantilla de locales
                            for (Jugador rival : equipoLocal.getPlantilla()) {
                                if (rival == devolverJugador(i, j)) {
                                    hayRival = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return hayRival;
    }

    public boolean hayPosibleMovimiento(int fila, int columna) {
        boolean hayMovimiento = false;

        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (i >= 0 && i <= 14 && j >= 0 && j <= 21) { // Evito el OutOfBoundsException
                    if (!hayJugadorEn(i, j)) {
                        hayMovimiento = true;
                    }
                }
            }
        }
        return hayMovimiento;
    }

    public boolean movimientoValido(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        boolean valido = false;
        if (campo[filaFinal][columnaFinal] == null) {
            if (esMovimientoVertical(filaInicial, columnaInicial, filaFinal, columnaFinal)){
                if (saltoVertical(filaInicial, filaFinal) == 1){
                    valido = true;
                }
            } else if (esMovimientoHorizontal(filaInicial, columnaInicial, filaFinal, columnaFinal)){
                if (saltoHorizontal(columnaInicial, columnaFinal) == 1){
                    valido = true;
                }
            } else if (esMovimientoDiagonal(filaInicial, columnaInicial, filaFinal, columnaFinal)) {
                if (saltoVertical(filaInicial, filaFinal)==1){
                    valido = true;
                }
            }
        }
        return valido;
    }

    public boolean esMovimientoVertical(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        return Math.abs(saltoHorizontal(columnaInicial, columnaFinal)) == 0 && Math.abs(saltoVertical(filaInicial, filaFinal)) != 0;
    }

    /**
     * @return Booleano que indica si el movimiento es horizontal
     */
    public boolean esMovimientoHorizontal(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        return Math.abs(saltoHorizontal(columnaInicial, columnaFinal)) != 0 && Math.abs(saltoVertical(filaInicial, filaFinal)) == 0;
    }

    /**
     * @return Booleano que indica si el movimiento es diagonal
     */
    public boolean esMovimientoDiagonal(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        return Math.abs(saltoHorizontal(columnaInicial, columnaFinal)) == Math.abs(saltoVertical(filaInicial, filaFinal));
    }

    /**
     * @return número de casillas avanzadas o retrocedidas en horizontal
     */
    public int saltoHorizontal(int columnaInicial, int columnaFinal) {
        return columnaFinal - columnaInicial;
    }

    /**
     * @return número de casillas avanzadas o retrocedidas en vertical
     */
    public int saltoVertical(int filaInicial, int filaFinal) {
        return filaFinal - filaInicial;
    }

    /**
     * @return número de casillas avanzadas o retrocedidas en diagonal
     */
    public int saltoDiagonal(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        if (esMovimientoDiagonal(filaInicial, columnaInicial, filaFinal, columnaFinal)) {
            return saltoVertical(filaInicial, filaFinal);
        } else {
            return 0;
        }
    }
}
