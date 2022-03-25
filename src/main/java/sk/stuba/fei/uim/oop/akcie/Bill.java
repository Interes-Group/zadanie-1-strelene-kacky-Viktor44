package sk.stuba.fei.uim.oop.akcie;

import sk.stuba.fei.uim.oop.logika.Karta;
import sk.stuba.fei.uim.oop.logika.Hra;

public class Bill extends Karta {

    public Bill(int x, int y) {
        super(x,y);
        this.funkcia = "Divoky Bill";
    }

    public Hra vykonajAkciu(Karta[] karta, Boolean[] bool, int x){
        Hra hr = new Hra();
        bool[x-1] = false;
        karta[x-1].setIndex(-1);
        hr.zamer = bool;
        hr.rybnicek = karta;
        return hr;
    }

}
