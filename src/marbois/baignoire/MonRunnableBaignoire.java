package marbois.baignoire;

public class MonRunnableBaignoire implements Runnable{

    private Baignoire baignoire;

    public MonRunnableBaignoire(Baignoire baignoire) {
        this.baignoire = baignoire;
    }

    @Override
    public void run() {
        while (this.baignoire.getVolFuite() != 0){
            this.baignoire.fuite();
            if (this.baignoire.getVol() == 0 && this.baignoire.getVolFuite() != 0){
                this.baignoire.colmater();
            }
        }
    }
}
