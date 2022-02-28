package marbois.baignoire;

public class MonRunnableRobinet implements Runnable{

    private Robinet robinet;

    public MonRunnableRobinet(Robinet robinet) {
        this.robinet = robinet;
    }

    @Override
    public void run() {
//        while (this.robinet.getBaignoire().getVolFuite() != 0){
//            if (this.robinet.getBaignoire().getVol() == 0){
                this.robinet.debite();
//            }
//        }
    }
}
