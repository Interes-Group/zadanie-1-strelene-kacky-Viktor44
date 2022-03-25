package sk.stuba.fei.uim.oop.akcie;

import sk.stuba.fei.uim.oop.logika.Hra;
import sk.stuba.fei.uim.oop.logika.Karta;
import sk.stuba.fei.uim.oop.logika.Pomoc;

public class Vystrelit extends Karta {
    Pomoc help = new Pomoc();


    public Vystrelit(int x, int y) {
        super(x,y);
        this.funkcia = "Vystrelit";
    }

    public Hra vykonajAkciu(Karta[] karta, Boolean[] bool, int x){
        Hra hr = new Hra();
        if (bool[x-1] == true){
            bool[x-1] = false;
            karta[x-1].setIndex(-1);
        }
        else{
            return null;
        }

        hr.zamer = bool;
        hr.rybnicek = karta;
        return hr;
    }
}
