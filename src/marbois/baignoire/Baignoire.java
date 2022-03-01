package marbois.baignoire;

public class Baignoire implements Runnable {

    private Robinet robinet;
    private int volumeMax;

    private int volume;

    private int volumeDeFuite;

    private int nbFuite;

    public Baignoire( int volumeMax, int volumeDeFuite) {

        this.volumeMax = volumeMax;
        volume = 0;
        this.volumeDeFuite = volumeDeFuite;
        nbFuite = 0;
    }

    public void fuit() throws InterruptedException {

        while (volumeDeFuite > 0) {

            if (volume == 0) {
                // Je n'ai pas d'eau et je peux colmater
                volumeDeFuite -= 1;
            } else {
                nbFuite++;

                synchronized (this) {
                    if (volume - volumeDeFuite < 0) {
                        volume = 0;
                    } else {
                        volume = volume - volumeDeFuite;
                    }
                    System.out.println("Ca fuit ---> le volume de la baignoire est : " + volume);
                }
            }

            Thread.sleep(1);

        }

        synchronized (robinet) {
            System.out.println("Ca ne fuit plus, la fuite a été colmatée, on peut relancer le robinet !!!");
            robinet.notify();
            nbFuite = 0;
        }

    }

    public int getVolume() {
        return volume;
    }

    public int getVolumeMax() {
        return volumeMax;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getNbFuite() {
        return nbFuite;
    }

    public void setRobinet(Robinet robinet) {
        this.robinet = robinet;
    }

    @Override
    public void run() {
        try {
            fuit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
