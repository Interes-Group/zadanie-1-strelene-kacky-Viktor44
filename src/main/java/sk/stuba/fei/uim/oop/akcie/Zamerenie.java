package sk.stuba.fei.uim.oop.akcie;

import sk.stuba.fei.uim.oop.logika.Hra;
import sk.stuba.fei.uim.oop.logika.Karta;

public class Zamerenie extends Karta {
    public Zamerenie(int x, int y) {
        super(x,y);
        this.funkcia = "Zamierit";
    }
    public Hra vykonajAkciu(Karta[] karta, Boolean[] bool, int x){
        Hra hr = new Hra();
        hr.rybnicek = karta;
        if (bool[x-1] == false){
            bool[x-1] = true;
            hr.zamer = bool;
        }
        else{
            hr = null;
        }

        return hr;
    }
}
