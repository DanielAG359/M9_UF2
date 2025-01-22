import java.util.Random;

public class Soci extends Thread {
    private Compte compte;
    private float saldo;
    private double aportacio = 10.0;
    private long esperaMax = 100;
    private int maxAnys = 10;
    private Random random;

    public Soci() {
        this.compte = Compte.creaCompte();
        this.random = new Random();
    }

    public double getCompte() {
        return compte.getSaldo();
    }

    @Override
    public void run() {
        for (int any = 1; any <= maxAnys; any++) {
            for (int mes = 0; mes < 12; mes++) {
                if (mes % 2 == 0) {
                    saldo += aportacio;
                    System.out.println(saldo);
                } else {
                    saldo -= aportacio;
                    System.out.println(saldo);
                }
                try {
                    Thread.sleep(random.nextLong(esperaMax));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
