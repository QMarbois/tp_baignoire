package marbois.baignoire;

public class Main {
    public static void main(String[] args) {
        Baignoire baignoire = new Baignoire(1000, 10);
        MonRunnableBaignoire monRunnableBaignoire = new MonRunnableBaignoire(baignoire);
        Thread monThreadBaignoire = new Thread(monRunnableBaignoire);

        Robinet robinet = new Robinet(baignoire,50);
        MonRunnableRobinet monRunnableRobinet = new MonRunnableRobinet(robinet);
        Thread monThreadRobinet = new Thread(monRunnableRobinet);


        monThreadRobinet.start();
        monThreadBaignoire.start();
    }
}
