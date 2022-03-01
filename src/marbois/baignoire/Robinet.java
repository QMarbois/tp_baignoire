package marbois.baignoire;

public class Robinet implements Runnable{

    private Baignoire baignoire;
    private int volumeDebite;

    public Robinet(Baignoire baignoire, int volumeDebite) {
        this.baignoire = baignoire;
        this.volumeDebite = volumeDebite;
    }

    public void debite() throws InterruptedException {

        while (baignoire.getVolume() + volumeDebite <= baignoire.getVolumeMax()) {

            if (baignoire.getNbFuite() > 10) {

                synchronized (this) {
                    System.out.println("OULALA ça fuit !!!!!!");
                    // on coupe le robinet, on le met en attente
                    this.wait();
                }

                System.out.println("C'est bon on remet de l'eau");
            }

            synchronized (baignoire) {
                baignoire.setVolume(baignoire.getVolume() + volumeDebite);
                System.out.println("Je rempli -> le volume de la baignoire est : " + baignoire.getVolume());
            }

            Thread.sleep(1);
        }

        System.out.println("C'est bon je me suis fait coulé un bain");

    }

    @Override
    public void run() {
        try {
            debite();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
