package sk.stuba.fei.uim.oop.logika;
import java.util.Random;

import sk.stuba.fei.uim.oop.akcie.Bill;
import sk.stuba.fei.uim.oop.akcie.Vystrelit;
import sk.stuba.fei.uim.oop.akcie.Zamerenie;
import sk.stuba.fei.uim.oop.pohyby.Pochod;
import sk.stuba.fei.uim.oop.pohyby.Rosambo;
import sk.stuba.fei.uim.oop.pohyby.Tanec;
import sk.stuba.fei.uim.oop.pohyby.Turbo;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class Hra {
    public Random rnd = new Random();
    public Karta[] rybnicek = new Karta[6];
    public Boolean[] zamer = new Boolean[6];
    public int poradieAkcie;
    public int poradieJazero;

    public void zaciatok(){
        int pocetHracov  = 7;
        while (pocetHracov > 6 || pocetHracov < 2) {
            pocetHracov = ZKlavesnice.readInt("Zadajte ze kolko hracov bude hrat (min = 2, max = 6): ");
        }
        Hrac[] hrace = new Hrac[pocetHracov];
        Karta[] kopkaAkcie = new Karta[34];
        Karta[] vytahnuteAkcie = new Karta[34];
        int pocetJazero = (5*pocetHracov + 5);
        Karta[] kopkaJazero = new Karta[pocetJazero];
        Karta[] vytahnuteJazero = new Karta[pocetJazero];
        Pomoc help = new Pomoc();



        int i = 0;
        int j = 0;
        this.poradieAkcie = 0;
        this.poradieJazero = 0;
        int winner = 0;
        String str;
        int inp;
        int hracNaTahu=0;
        Karta vybrataKarta;
        Karta vybrataKarta2;
        int typKarty;
        boolean vystrelenaKacka = true;
        Hra vyber;


        for (i=0; i<pocetHracov;i++) {
            str = ZKlavesnice.readString("Zadate meno hraca " + (i + 1) + ": ");
            hrace[i] = new Hrac((i + 1), str);
        }

        for (i = 0; i<34;i++){
            if (i<10){
                kopkaAkcie[i] = new Zamerenie(1,1);
            }
            if (i>=10 && i < 22){
                kopkaAkcie[i] = new Vystrelit(1,2);
            }
            if (i>=22 && i < 24){
                kopkaAkcie[i] = new Bill(1,3);
            }
            if (i>=24 && i < 30){
                kopkaAkcie[i] = new Pochod(1,4);
            }
            if (i == 30){
                kopkaAkcie[i] = new Turbo(1,5);
            }
            if (i>=31 && i < 33){
                kopkaAkcie[i] = new Rosambo(1,6);
            }
            if (i == 33) {
                kopkaAkcie[i] = new Tanec(1,7);
            }
        }
        kopkaAkcie = help.zamiesat(kopkaAkcie);


        for (i = 0 ; i<pocetHracov;i++){
            for (int l = 0 ; l <3;l++) {
                hrace[i].tahKarty(kopkaAkcie[this.poradieAkcie]);
                this.poradieAkcie++;
            }
        }

        for (i = 0 ; i<=pocetHracov;i++){
            for (int l = 0 ; l <5;l++) {
                kopkaJazero[this.poradieJazero] = new Karta(2,i);
                kopkaJazero[this.poradieJazero].cislo = this.poradieJazero;
                this.poradieJazero++;
            }
        }
        this.poradieJazero = 0;

        kopkaJazero = help.zamiesat(kopkaJazero);

        for (i = 0;i<6;i++){
            this.rybnicek[i] = kopkaJazero[this.poradieJazero];
            this.zamer[i] = false;
            this.poradieJazero++;
        }


        while (1 == 1){

            System.out.print("\n \n");
            if (this.poradieJazero == kopkaJazero.length-1){
                kopkaJazero = help.zamiesat(kopkaJazero);
                this.poradieJazero = 0;
            }
            vystrelenaKacka = true;
            for (i = 0;i<6;i++){
                if (this.zamer[i] == false){
                    System.out.print(i+1 + ": Nezamierené - ");
                }
                else {
                    System.out.print(i+1 + ": Zamierené - ");
                }
                if (this.rybnicek[i].getTyp() == 0){
                    System.out.print("Voda " + "\n");
                }
                else{
                    System.out.print("Kacka Hraca " + this.rybnicek[i].getTyp() + "\n");
                }
            }

            if (winner != 0){
                break;
            }

            System.out.print("\n");
            System.out.print("Hrac na tahu: Hrac "+ (hracNaTahu+1) + ", meno: " + hrace[hracNaTahu].getMeno() + ", Pocet kacky: " + hrace[hracNaTahu].getKacky()/3 +"\n");
            System.out.print("Karty: ");
            for (i = 0;i<3;i++){
                System.out.print((i+1) + " - " + hrace[hracNaTahu].getKarta(i).getFunkcia() + ",  ");
            }
            System.out.print("\n");

            inp = 0;
            while(inp < 1 || inp > 3)
                inp = ZKlavesnice.readInt("Vyberte kartu: ");
            vybrataKarta = hrace[hracNaTahu].pouzitKartu(inp-1);
            typKarty = vybrataKarta.getTyp();
            hrace[hracNaTahu].setRuka(help.vymena(hrace[hracNaTahu].getRuka(),inp-1,kopkaAkcie[this.poradieAkcie]));
            this.poradieAkcie++;

            if (this.poradieJazero == kopkaJazero.length-1){
                kopkaJazero = help.zamiesat(kopkaJazero);
                this.poradieJazero = 0;
            }

            if (typKarty < 4) {
                if (typKarty == 1) {
                    inp = 0;
                    while(inp < 1 || inp > 6)
                        inp = ZKlavesnice.readInt("Na ktoru kartu chcete zamierit: ");
                }
                else {
                    inp = 0;
                    while(inp < 1 || inp > 6)
                        inp = ZKlavesnice.readInt("Na ktoru kartu chcete vystrelit: ");
                }
                vyber = vybrataKarta.vykonajAkciu(this.rybnicek, this.zamer, inp);
                if (vyber == null){
                    System.out.println("\nTam sa neda strelit/zamierit !!! \nTeraz ide dalsi hrac !!!");
                    if (hracNaTahu == pocetHracov-1){
                        hracNaTahu = 0;
                    }
                    else
                        hracNaTahu++;

                    continue;
                }
                this.rybnicek = vyber.rybnicek;
                this.zamer = vyber.zamer;

                for (i = 0;i<6;i++){
                    if (this.rybnicek[i].getIndex() == -1){
                        vybrataKarta2 = this.rybnicek[i];
                        this.rybnicek = help.vymena(this.rybnicek,i,vybrataKarta2);
                        //kopkaJazero = help.odstranit(kopkaJazero,vybrataKarta2);
                        if (vybrataKarta2.getTyp() != 0) {
                            hrace[vybrataKarta2.getTyp() - 1].setKacky(hrace[vybrataKarta2.getTyp() - 1].getKacky() - 1);
                        }

                    }
                }


            }
            else {
                if (typKarty != 5){
                    vyber = vybrataKarta.vykonajPohyb(this,kopkaJazero,-1);
                    this.poradieJazero = vyber.poradieJazero;
                    this.rybnicek = vyber.rybnicek;
                    this.zamer = vyber.zamer;
                    this.poradieAkcie = vyber.poradieAkcie;
                    vystrelenaKacka = true;
                }
                else{
                    inp = 0;
                    while (inp < 1 || inp > 6)
                        inp = ZKlavesnice.readInt("Vyberte kacku: ");
                    vyber = vybrataKarta.vykonajPohyb(this,kopkaJazero,inp);
                    this.poradieJazero = vyber.poradieJazero;
                    this.rybnicek = vyber.rybnicek;
                    this.zamer = vyber.zamer;
                    this.poradieAkcie = vyber.poradieAkcie;
                    vystrelenaKacka = true;
                }

            }

            for (i = 0; i<6;i++){
                if (this.rybnicek[i].getIndex() == -1) {
                    if (this.rybnicek[i].getTyp() != 0) {
                        hrace[this.rybnicek[i].getTyp()-1].setKacky(hrace[this.rybnicek[i].getTyp()-1].getKacky() - 1);
                        for (j = i; j < 6-1; j++) {
                            this.rybnicek[i] = this.rybnicek[i + 1];
                        }
                        this.rybnicek[5] = kopkaJazero[this.poradieJazero];
                        this.poradieJazero++;
                        vystrelenaKacka = true;
                        break;
                    }
                }
            }

            if (this.poradieJazero == kopkaJazero.length-1){
                kopkaJazero = help.zamiesat(kopkaJazero);
                this.poradieJazero = 0;
            }

            for (i = 0; i < pocetHracov; i++){
                if (hrace[i].getKacky() == 0) {
                    hrace = help.odstranitHraca(hrace,hrace[i]);
                    pocetHracov--;
                    hracNaTahu--;
                }
            }

            if (pocetHracov == 1){
                winner = hrace[0].getCislo();
            }

            if (hracNaTahu == pocetHracov-1){
                hracNaTahu = 0;
            }
            else
                hracNaTahu++;



        }
        System.out.println("\n" + "VYHRAL HRAC: " + winner + " !!!!!!\n");
    }
}
