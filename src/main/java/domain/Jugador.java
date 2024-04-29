package domain;


public class Jugador {
    private String nombre;
    private int dorsal;
    private String posicion;

    private boolean tieneBalon = false;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getPac() {
        return pac;
    }

    public void setPac(int pac) {
        this.pac = pac;
    }

    public int getSho() {
        return sho;
    }

    public void setSho(int sho) {
        this.sho = sho;
    }

    public int getPas() {
        return pas;
    }

    public void setPas(int pas) {
        this.pas = pas;
    }

    public int getDri() {
        return dri;
    }

    public void setDri(int dri) {
        this.dri = dri;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getPhy() {
        return phy;
    }

    public void setPhy(int phy) {
        this.phy = phy;
    }

    public boolean isTieneBalon() {
        return tieneBalon;
    }

    public void setTieneBalon(boolean tieneBalon) {
        this.tieneBalon = tieneBalon;
    }
}
