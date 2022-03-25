package sk.stuba.fei.uim.oop.logika;

//-----------Tato trieda je pre jedneho hraca kde bude mat hrac vsetky dolezite informacie---------------------
public class Hrac {
    private int cislo;
    private String meno;
    private int kacky;
    private Karta[] ruka = new Karta[3];

    public Hrac(int c, String m){
        this.cislo = c;
        this.meno = m;
        this.kacky = 15;
        for (int i = 0;i<3;i++){
            this.ruka[i] = new Karta(-1,-1);
        }
    }

    public Karta[] getRuka(){
        return this.ruka;
    }

    public void setRuka(Karta[] x){
        this.ruka = x;
    }

    public void setKacky(int x){
        this.kacky = x;
    }

    public int getKacky(){
        return this.kacky;
    }

    public int getCislo(){
        return this.cislo;
    }

    public String getMeno(){
        return this.meno;
    }

    public Karta getKarta(int x){
        return this.ruka[x];
    }

    public void tahKarty(Karta karta){
        for (int i = 0 ; i<3;i++){
            if (this.ruka[i].getIndex() == -1){
                this.ruka[i] = karta;
                this.ruka[i].setIndex(1);
                break;
            }

        }

    }

    public Karta pouzitKartu(int x){
        Karta a1 = this.ruka[x];
        this.ruka[x].setIndex(-1);
        return a1;
    }


}
