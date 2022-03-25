package sk.stuba.fei.uim.oop.logika;

public class Karta {
    protected int index;
    private int typ;
    protected String funkcia = "Karta";
    public int cislo;

    public Karta(int x, int y){
        this.index = x;
        this.typ = y;
    }

    public void setTyp(int x){
        this.typ = x;
    }

    public int getTyp(){
        return this.typ;
    }

    public String getFunkcia(){
        return this.funkcia;
    }

    public int getIndex(){
        return this.index;
    }

    public void setIndex(int x){
        this.index = x;
    }

    public Hra vykonajAkciu(Karta[] karta, Boolean[] bool, int x){
        Hra hr = new Hra();
        return hr;
    }

    public Hra vykonajPohyb(Hra h, Karta[] kopka, int x){


        return h;
    }


}
