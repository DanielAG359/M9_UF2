import java.util.Random;

public class Filosof implements Runnable {
    private String nom;
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private int gana;
    private Random random;
    public Filosof(String nom, Forquilla forquillaEsquerra, Forquilla forquillaDreta) {
        this.nom = nom;
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
        this.gana = 0;
        this.random = new Random();
    }
    private void pensar() throws InterruptedException {
        System.out.println("Filòsof: " + nom + " pensant");
        Thread.sleep(random.nextInt(1000) + 1000); // Pensar entre 1s i 2s
    }
    private void menjar() throws InterruptedException {
        System.out.println("Filòsof: " + nom + " menja");
        Thread.sleep(random.nextInt(1000) + 1000); // Menjar entre 1s i 2s
    }
    public String getNom() {
        return nom;
    }
    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }
    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }
    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                boolean agafatEsquerra = false;
                boolean agafatDreta = false;
                while (!agafatEsquerra || !agafatDreta) {
                    agafatEsquerra = forquillaEsquerra.agafar();
                    if (agafatEsquerra) {
                        System.out.println("Filòsof: "+nom+" agafa la forquilla esquerra "+forquillaEsquerra.getNumero());
                        agafatDreta = forquillaDreta.agafar();
                        if (agafatDreta) {
                            System.out.println("Filòsof: "+nom+" agafa la forquilla dreta "+forquillaDreta.getNumero());
                            menjar();
                            forquillaDreta.deixar();
                            System.out.println("Filòsof: "+nom+" deixa la forquilla dreta "+forquillaDreta.getNumero());
                        } else {
                            forquillaEsquerra.deixar();
                            System.out.println("Filòsof: "+nom+" deixa l'esquerra ("+forquillaEsquerra.getNumero()+") i espera (dreta ocupada)");
                            gana++;
                            System.out.println("Filòsof: "+nom+" gana=" + gana);
                        }
                    } else {
                        System.out.println("Filòsof: "+nom+" no pot agafar la forquilla esquerra "+forquillaEsquerra.getNumero());
                    }
                    if (!agafatEsquerra || !agafatDreta) {
                        Thread.sleep(random.nextInt(500) + 500);
                    }
                }
                forquillaEsquerra.deixar();
                System.out.println("Filòsof: "+nom+" deixa la forquilla esquerra "+forquillaEsquerra.getNumero());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Filòsof: "+nom+" ha estat interromput");
        }
    }
}
