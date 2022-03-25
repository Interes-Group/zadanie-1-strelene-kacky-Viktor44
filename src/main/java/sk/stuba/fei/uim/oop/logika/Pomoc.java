package sk.stuba.fei.uim.oop.logika;

import java.util.*;

//------------V tomto triede mam tie metody ktore budem pouzivat viac krat-------------
public class Pomoc {

    public Karta[] zamiesat(Karta[] kopka){
        List<Karta> kartaList = Arrays.asList(kopka);
        Collections.shuffle(kartaList);
        kartaList.toArray(kopka);

        return kopka;
    }

    public Karta[] vymena(Karta[] kopka, int x , Karta karta){
        ArrayList<Karta> kartaList = new ArrayList<>();
        for (int i = 0 ; i<kopka.length;i++){
            kartaList.add(kopka[i]);
        }
        kartaList.remove(x);
        //kartaList.ensureCapacity(kopka.length);
        kartaList.add(karta);
        kartaList.toArray(kopka);
        return kopka;
    }

    public Karta[] odstranit(Karta[] kopka, Karta karta){
        ArrayList<Karta> kartaList = new ArrayList<>();
        for (int i = 0 ; i<kopka.length;i++){
            kartaList.add(kopka[i]);
        }
        for (int i = 0; i < kopka.length;i++){
            if (kopka[i].getTyp() == karta.getTyp()){
                kartaList.remove(i);
                break;
            }
        }
        kartaList.toArray(kopka);
        return kopka;
    }

    public Hrac[] odstranitHraca(Hrac[] kopka, Hrac h){
        ArrayList<Hrac> kartaList = new ArrayList<>();
        for (int i = 0 ; i<kopka.length;i++){
            kartaList.add(kopka[i]);
        }
        for (int i = kopka.length-1; i>=0;i--){
            if (kopka[i].getCislo() == h.getCislo()){
                kartaList.remove(i);
            }
        }
        kartaList.toArray(kopka);
        return kopka;
    }

}
