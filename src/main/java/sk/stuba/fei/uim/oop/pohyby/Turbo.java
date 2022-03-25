package sk.stuba.fei.uim.oop.pohyby;

import sk.stuba.fei.uim.oop.logika.Hra;
import sk.stuba.fei.uim.oop.logika.Karta;

public class Turbo extends Karta {
    public Turbo(int x, int y) {
        super(x,y);
        this.funkcia = "Turbo kačka";
    }
    public Hra vykonajPohyb(Hra hra, Karta[] kopka, int x){
        Karta k = hra.rybnicek[x-1];
        for (int i = x-1;i>0; i--){
            hra.rybnicek[i] = hra.rybnicek[i-1];
            hra.rybnicek[i-1] = k;
        }

        return hra;
    }
}
