package sk.stuba.fei.uim.oop.pohyby;

import sk.stuba.fei.uim.oop.logika.Hra;
import sk.stuba.fei.uim.oop.logika.Karta;
import sk.stuba.fei.uim.oop.logika.Pomoc;

public class Tanec extends Karta {
    public Tanec(int x, int y) {
        super(x,y);
        this.funkcia = "Kačací tanec";
    }
    public Hra vykonajPohyb(Hra hra, Karta[] kopka, int x){
        int i,j;
        Pomoc p = new Pomoc();
        Karta[] tabula = new Karta[6];
        for (i = 0;i<6;i++){
            tabula[i] = hra.rybnicek[i];
        }
        for (i = 0 ; i<6;i++){
            hra.rybnicek[i] = kopka[hra.poradieJazero];
            if (hra.poradieJazero == kopka.length-1){
                kopka = p.zamiesat(kopka);
                hra.poradieJazero = 0;
            }
            hra.poradieJazero++;
        }

        return hra;
    }
}
