package domain;

import java.util.ArrayList;
import java.util.List;

public abstract class ComprobarAcciones {
    public static boolean movimientoValido(Jugador[][] campo, int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        boolean valido = false;
        if (Math.abs(saltoHorizontal(columnaInicial, columnaFinal)) == 1 || Math.abs(saltoVertical(filaInicial, filaFinal)) == 1 || Math.abs(saltoDiagonal(filaInicial, filaFinal, columnaInicial, columnaFinal)) == 1) {
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
     *
     * @return true si es jugador del equipo local, false si es jugador del equipo visitante
     */
    public static boolean esJugadorLocal(Juego juego, int fila, int columna) {
        boolean esLocal = false;
        if (juego.getCampo()[fila][columna] != null) {
            for (Jugador jugador : juego.getEquipoLocal().getPlantilla()) {
                if (juego.getCampo()[fila][columna].getNombre().equals(jugador.getNombre())) {
                    esLocal = true;
                }
            }
        }
        return esLocal;
    }

    public static boolean esPenalti(boolean turno, int filaDelantero, int columnaDelantero) {
        boolean penalti = false;
        if (turno) { // Si la falta la hace el equipo local
            if (filaDelantero >= 3 && filaDelantero <= 11 && columnaDelantero >= 18 && columnaDelantero <= 21) {
                penalti = true;
            }
        } else { // Si la falta la hace el equipo visitante

            if (filaDelantero >= 3 && filaDelantero <= 11 && columnaDelantero >= 0 && columnaDelantero <= 3) {
                penalti = true;
            }
        }
        return penalti;
    }

    public static boolean esFueraDeJuego(Juego juego, int filaReceptor, int columnaReceptor, int columnaPasador) {
        int rivalesDelante = 0;
        int rivalesEnLinea = 0;
        boolean paseAtras = false;
        boolean hayFueraDeJuego = false;
        if (juego.isTurno()) {
            if (columnaPasador >= columnaReceptor) {
                paseAtras = true;
            }
        } else {
            if (columnaPasador <= columnaReceptor) {
                paseAtras = true;
            }
        }
        if (!paseAtras) {
            if (juego.isTurno()) { // Si es el turno del equipo local
                for (int i = juego.getCampo()[0].length - 1; i > columnaReceptor; i--) {
                    for (int j = juego.getCampo().length - 1; j >= 0; j--) {
                        if (juego.getCampo()[j][i] != null) {
                            if (hayRivalEn(juego, j, i)) {
                                rivalesDelante++;
                            } else {
                                break;
                            }
                        }
                    }
                }
            } else { // Si es el turno del equipo visitante
                for (int i = 0; i < juego.getCampo().length; i++) {
                    for (int j = 0; j < columnaReceptor; j++) {
                        if (juego.getCampo()[i][j] != null) {
                            if (hayRivalEn(juego, i, j)) {
                                rivalesDelante++;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
            if (rivalesDelante < 2) { // Si no hay rivales suficientes delante, se determina el fuera de juego con los que estan en linea
                for (int i = 0; i < juego.getCampo().length; i++) {
                    if (juego.getCampo()[i][columnaReceptor] != null) {
                        if (hayRivalEn(juego, i, columnaReceptor)) {
                            rivalesEnLinea++;
                        }
                    }
                }
                for (int i = 0; i < juego.getCampo().length; i++) { // Hago un random por cada rival en linea y si gana el pasador sumo el rival en linea a los rivales delante
                    if (juego.getCampo()[i][columnaReceptor] != null) {
                        if (hayRivalEn(juego, i, columnaReceptor)) {
                            int defensa = (int) (Math.random() * juego.getCampo()[i][columnaReceptor].getPac());
                            int ataque = (int) (Math.random() * juego.getCampo()[filaReceptor][columnaReceptor].getPac() * rivalesEnLinea);
                            if (ataque > defensa) {
                                rivalesDelante++;
                            }
                        }
                    }
                }
            }
            if (rivalesDelante < 2) {
                hayFueraDeJuego = true;
            }
        }
        return hayFueraDeJuego;
    }
}
