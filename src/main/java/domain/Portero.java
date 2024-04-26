package domain;

public class Portero extends Jugador {
    int div;
    int han;
    int kic;
    int ref;
    int spd;
    int pos;

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
}
