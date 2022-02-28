package marbois.baignoire;

public class Baignoire {
    private final int volMax;
    private int vol;
    private int volFuite;

    public Baignoire(int volMax, int volFuite) {
        this.volMax = volMax;
        this.volFuite = volFuite;
    }

    void fuite(){
        while (this.vol > 0){
            synchronized (this) {
                this.setVol(- volFuite);
                System.out.println("FUIIIIIITE " + this);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void colmater(){
        this.setVolFuite(- 1);
        System.out.println("COLMATAGATION");
    }

    public int getVolMax() {
        return volMax;
    }

    public int getVol() {
        return vol;
    }

    public int getVolFuite() {
        return volFuite;
    }

    public void setVol(int vol) {
        if ((this.vol + vol) >= 0 && (this.vol + vol) <= volMax){
            this.vol += vol;
        }
    }

    public void setVolFuite(int volFuite) {
        if (this.volFuite != 0){
            this.volFuite += volFuite;
        }
    }

    @Override
    public String toString() {
        return "Volume d'eau contenu --> " + this.getVol() + " /" + this.getVolMax();
    }
}
