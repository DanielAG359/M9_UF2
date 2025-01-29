import java.util.Random;

public class Soci extends Thread {
    private Compte compte;
    private float aportacio = 10.0f;
    private int esperaMax = 100;
    private Random random = new Random();
    private int maxAnys = 10;

    public Soci(Compte compte) {
        this.compte = compte;
    }

    public Compte getCompte() {
        return compte;
    }

    @Override
    public void run() {
        for (int any = 0; any < maxAnys; any++) {
            for (int mes = 0; mes < 12; mes++) {
                if (mes % 2 == 0) {
                    compte.ingresar(aportacio);
                } else {
                    compte.retirar(aportacio);
                }
                try {
                    Thread.sleep(random.nextInt(esperaMax));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}