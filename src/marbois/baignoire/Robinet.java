package marbois.baignoire;

public class Robinet {
    private final Baignoire baignoire;
    private final int volDebite;

    public Robinet(Baignoire baignoire, int volDebite) {
        this.baignoire = baignoire;
        this.volDebite = volDebite;
    }

    void debite(){
        while (this.baignoire.getVol() < this.baignoire.getVolMax()){
            if (this.baignoire.getVolMax() - this.baignoire.getVol() < this.volDebite){
                this.baignoire.setVol(this.baignoire.getVolMax() - this.baignoire.getVol());
            }
            this.baignoire.setVol(this.volDebite);
            System.out.println(this.baignoire);
        }
    }
}
