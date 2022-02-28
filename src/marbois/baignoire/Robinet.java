package marbois.baignoire;

public class Robinet {
    private final Baignoire baignoire;
    private final int volDebite;

    public Robinet(Baignoire baignoire, int volDebite) {
        this.baignoire = baignoire;
        this.volDebite = volDebite;
    }

    public Baignoire getBaignoire() {
        return baignoire;
    }

    void debite(){
        while (this.baignoire.getVol() + volDebite <= this.baignoire.getVolMax()){

            synchronized (baignoire) {
                this.baignoire.setVol(this.volDebite);
                System.out.println(this.baignoire);
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
