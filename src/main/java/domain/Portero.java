package domain;

public class Portero extends Jugador {
    private int div;
    private int han;
    private int kic;
    private int ref;
    private int spd;
    private int pos;

    public Portero() {
    }

    public Portero(int div, int han, int kic, int ref, int spd, int pos) {
        this.div = div;
        this.han = han;
        this.kic = kic;
        this.ref = ref;
        this.spd = spd;
        this.pos = pos;
    }

    public Portero(String nombre, int dorsal, String posicion, int pac, int sho, int pas, int dri, int def, int phy) {
        super(nombre, dorsal, posicion, pac, sho, pas, dri, def, phy);
    }

    public Portero(String nombre, int dorsal, String posicion, int pac, int sho, int pas, int dri, int def, int phy, int div, int han, int kic, int ref, int spd, int pos) {
        super(nombre, dorsal, posicion, pac, sho, pas, dri, def, phy);
        this.div = div;
        this.han = han;
        this.kic = kic;
        this.ref = ref;
        this.spd = spd;
        this.pos = pos;
    }

    public Portero(String nombre, int dorsal, String posicion) {
        super(nombre, dorsal, posicion);
    }

    public int getDiv() {
        return div;
    }

    public void setDiv(int div) {
        this.div = div;
    }

    public int getHan() {
        return han;
    }

    public void setHan(int han) {
        this.han = han;
    }

    public int getKic() {
        return kic;
    }

    public void setKic(int kic) {
        this.kic = kic;
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public void inicalizarEstadisticas(){
        super.inicializarEstadisticas();

        div = 80;
        han = 80;
        kic = 80;
        ref = 80;
        spd = 80;
        pos = 80;
    }
}
