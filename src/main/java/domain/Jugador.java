package domain;


import lombok.Data;



@Data

public class Jugador implements Cloneable, Comparable {
    private String nombre;
    private int dorsal;
    private String posicion;

    private boolean tieneBalon = false;
    private boolean tieneAmarilla = false;

    int pac;
    int sho;
    int pas;
    int dri;
    int def;
    int phy;

    public Jugador() {

    }

    public Jugador(String nombre, int dorsal, String posicion) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.posicion = posicion;
    }

    public Jugador(String nombre, int dorsal, String posicion, int pac, int sho, int pas, int dri, int def, int phy) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.pac = pac;
        this.sho = sho;
        this.pas = pas;
        this.dri = dri;
        this.def = def;
        this.phy = phy;
    }


    public void inicializarEstadisticas(){
        pac = 80;
        sho = 80;
        pas = 80;
        dri = 80;
        def = 80;
        phy = 80;
        dorsal = 1;
    }

    @Override
    public int compareTo(Object o) {
        Jugador jugador = (Jugador) o;
        return Integer.compare(dorsal, jugador.getDorsal());
    }

    @Override
    public String toString() {
        return STR."Jugador{nombre='\{nombre}\{'\''}, dorsal=\{dorsal}, posicion='\{posicion}\{'\''}, tieneBalon=\{tieneBalon}, tieneAmarilla=\{tieneAmarilla}, pac=\{pac}, sho=\{sho}, pas=\{pas}, dri=\{dri}, def=\{def}, phy=\{phy}\{'}'}";
    }
}
