import java.util.Random;

public class Assistent extends Thread {
    private Esdeveniment esdeveniment;
    private String nom;
    private Random random;
    public Assistent(String nom, Esdeveniment esdeveniment) {
        this.nom = nom;
        this.esdeveniment = esdeveniment;
        this.random = new Random();
    }
    public String getNom() {
        return nom;
    }
    @Override
    public void run() {
        try {
            while (true) {
                double probabilitat = random.nextDouble();
                if (probabilitat < 0.3) {
                    esdeveniment.ferReserva(this);
                } else {
                    esdeveniment.cancelaReserva(this);
                }
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}