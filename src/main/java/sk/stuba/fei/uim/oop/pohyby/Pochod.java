package sk.stuba.fei.uim.oop.pohyby;

import sk.stuba.fei.uim.oop.logika.Hra;
import sk.stuba.fei.uim.oop.logika.Karta;
import sk.stuba.fei.uim.oop.logika.Pomoc;

public class Pochod extends Karta {
    public Pochod(int x, int y) {
        super(x,y);
        this.funkcia = "Kačací pochod";
    }
    public Hra vykonajPohyb(Hra hra, Karta[] kopka, int x){
        int i;
        Pomoc help = new Pomoc();
        hra.rybnicek = help.vymena(hra.rybnicek,0,kopka[hra.poradieJazero]);
        hra.poradieJazero++;

        return hra;
    }
}
