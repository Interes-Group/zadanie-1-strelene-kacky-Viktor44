package sk.stuba.fei.uim.oop.pohyby;

import sk.stuba.fei.uim.oop.logika.Hra;
import sk.stuba.fei.uim.oop.logika.Karta;
import sk.stuba.fei.uim.oop.logika.Pomoc;

public class Rosambo extends Karta {
    public Rosambo(int x, int y) {
        super(x,y);
        this.funkcia = "Rosambo";
    }
    public Hra vykonajPohyb(Hra hra, Karta[] kopka, int x){
        Pomoc p = new Pomoc();
        hra.rybnicek = p.zamiesat(hra.rybnicek);

        return hra;
    }
}
