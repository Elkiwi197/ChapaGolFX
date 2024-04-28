package domain;

public class Juego {
    private Jugador[][] campo = new Jugador[15][22];
    private Equipo equipoLocal; //J1
    private Equipo equipoVisitante; //J2
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
        equipoLocal = local;
        equipoVisitante = visitante;

        cargarJugadoresRAM(local, visitante);
        actualizarCampoConsola();

    }

    private void actualizarCampoConsola() {
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[0].length; j++) {
                if (campo[i][j]==null){
                    System.out.print("|  |");
                } else {
                    if (campo[i][j].getDorsal()<10){
                        System.out.print("|" + campo[i][j].getDorsal() + " |");
                    } else{
                        System.out.print("|" + campo[i][j].getDorsal() + "|");
                    }
                }
            }
            System.out.println(" ");
        }
    }

    private void cargarJugadoresRAM(Equipo local, Equipo visitante) {
        // Coloco al equipo local
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
    }

    public boolean hayJugadorEn(int fila, int columna){
        return campo[fila][columna] != null ;
    }
    public Jugador devolverJugador(int fila, int columna){
        return campo[fila][columna];
    }

}
