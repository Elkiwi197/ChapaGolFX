package domain;

import java.util.ArrayList;
import java.util.List;

public abstract class ComprobarAcciones {
    public static boolean movimientoValido(Jugador[][] campo, int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        boolean valido = false;
        if (Math.abs(saltoHorizontal(columnaInicial, columnaFinal)) == 1 || Math.abs(saltoVertical(filaInicial, filaFinal)) == 1  || Math.abs(saltoDiagonal(filaInicial, filaFinal, columnaInicial, columnaFinal)) == 1){
            valido = true;
        }
        return valido;
    }

    public static boolean esMovimientoVertical(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        return Math.abs(saltoHorizontal(columnaInicial, columnaFinal)) == 0 && Math.abs(saltoVertical(filaInicial, filaFinal)) != 0;
    }

    /**
     * @return Booleano que indica si el movimiento es horizontal
     */
    public static boolean esMovimientoHorizontal(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        return Math.abs(saltoHorizontal(columnaInicial, columnaFinal)) != 0 && Math.abs(saltoVertical(filaInicial, filaFinal)) == 0;
    }

    /**
     * @return Booleano que indica si el movimiento es diagonal
     */
    public static boolean esMovimientoDiagonal(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        return Math.abs(saltoHorizontal(columnaInicial, columnaFinal)) == Math.abs(saltoVertical(filaInicial, filaFinal));
    }

    /**
     * @return número de casillas avanzadas o retrocedidas en horizontal
     */
    public static int saltoHorizontal(int columnaInicial, int columnaFinal) {
        return columnaFinal - columnaInicial;
    }

    /**
     * @return número de casillas avanzadas o retrocedidas en vertical
     */
    public static int saltoVertical(int filaInicial, int filaFinal) {
        return filaFinal - filaInicial;
    }

    /**
     * @return número de casillas avanzadas o retrocedidas en diagonal
     */
    public static int saltoDiagonal(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        if (esMovimientoDiagonal(filaInicial, columnaInicial, filaFinal, columnaFinal)) {
            return saltoVertical(filaInicial, filaFinal);
        } else {
            return 0;
        }
    }

    public static boolean hayJugadorEn(Jugador[][] campo, int fila, int columna) {
        return campo[fila][columna] != null;
    }

    public static boolean hayPosibleMovimiento(Jugador[][] campo, int fila, int columna) {
        boolean hayMovimiento = false;

        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (i >= 0 && i <= 14 && j >= 0 && j <= 21) { // Evito el OutOfBoundsException
                    if (!hayJugadorEn(campo, i, j)) {
                        hayMovimiento = true;
                    }
                }
            }
        }
        return hayMovimiento;
    }

    public static boolean esTurnoDeJugador(Juego juego, int fila, int columna) {
        boolean esSuTurno = false;
        Jugador jugadorSeleccionado = juego.getCampo()[fila][columna];
        if (juego.isTurno()) {
            for (Jugador jugador : juego.getEquipoLocal().getPlantilla()) {
                if (jugador == jugadorSeleccionado) {
                    esSuTurno = true;
                    break;
                }
            }
        } else {
            for (Jugador jugador : juego.getEquipoVisitante().getPlantilla()) {
                if (jugador == jugadorSeleccionado) {
                    esSuTurno = true;
                    break;
                }
            }
        }
        return esSuTurno;
    }

    public static boolean hayRivalAlrededor(Juego juego, int fila, int columna, boolean turno) {
        boolean hayRival = false;
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (i >= 0 && i <= 14 && j >= 0 && j <= 21) { // Evito el OutOfBoundsException
                    if (hayJugadorEn(juego.getCampo(), fila, columna)) {
                        if (turno) { // Si es el turno de locales recorro plantilla de visitantes
                            for (Jugador rival : juego.getEquipoVisitante().getPlantilla()) {
                                if (rival == juego.devolverJugador(i, j)) {
                                    hayRival = true;
                                }
                            }
                        } else { // Si es el turno de visitantes recorro plantilla de locales
                            for (Jugador rival : juego.getEquipoLocal().getPlantilla()) {
                                if (rival == juego.devolverJugador(i, j)) {
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

    public static int calcularDistanciaReal(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        int catetoVertical = saltoVertical(filaInicial, filaFinal);
        int catetoHorizontal = saltoHorizontal(columnaInicial, columnaFinal);
        return (int) Math.sqrt(catetoVertical * catetoVertical + catetoHorizontal * catetoHorizontal);

    }

    /**
     * Recibe una casilla y una instancia de juego. Recorre la plantilla rival para ver si algun jugador esta situado en dicha casilla
     *
     * @param juego
     * @param fila
     * @param columna
     * @return booleano que determina si hay un rival en la casilla introducida
     */
    public static boolean hayRivalEn(Juego juego, int fila, int columna) {
        boolean hayRival = false;
        boolean equipo = juego.isTurno();
        List<Jugador> plantillaRival = new ArrayList<>();
        if (equipo) { // Si es el turno del equipo local recorro la plantilla visitante
            plantillaRival = juego.getEquipoVisitante().getPlantilla();
        } else {// Si es el turno del equipo visitante recorro la plantilla local
            plantillaRival = juego.getEquipoLocal().getPlantilla();
        }
        if (juego.getCampo()[fila][columna] != null) {
            for (Jugador jugador : plantillaRival) {
                if (juego.getCampo()[fila][columna].getNombre().equals(jugador.getNombre())) {
                    hayRival = true;
                }
            }
        }
        return hayRival;
    }

    /**
     * Recibe un campo y unas coordenadas y devuelve de que equipo es el jugador de las coordenadas
     * @return true si es jugador del equipo local, false si es jugador del equipo visitante
     */
    public static boolean esJugadorLocal(Juego juego, int fila, int columna){
        boolean esLocal = false;
        if (juego.getCampo()[fila][columna] != null){
            for (Jugador jugador : juego.getEquipoLocal().getPlantilla()) {
                if (juego.getCampo()[fila][columna].getNombre().equals(jugador.getNombre())){
                    esLocal = true;
                }
            }
        }
        return esLocal;
    }
}
