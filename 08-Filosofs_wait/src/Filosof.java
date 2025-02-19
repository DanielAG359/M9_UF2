import java.util.Random;

public class Filosof extends Thread {
    private String nom;
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private int comensal;
    private int gana;
    private Random random;
    public Filosof(String nom, Forquilla forquillaEsquerra, Forquilla forquillaDreta, int comensal) {
        this.nom = nom;
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
        this.comensal = comensal;
        this.gana = 0;
        this.random = new Random();
    }
    private void pensar() throws InterruptedException {
        System.out.println("Filòsof: " + nom + " pensant");
        Thread.sleep(random.nextInt(1000) + 1000);
    }
    private void menjar() throws InterruptedException {
        boolean agafarForquilles = false;
        while (agafarForquilles) {
            agafarForquilles = agafarForquilles();
        }
        deixarForquilles();
        System.out.println("Filòsof: "+nom+" deixa la forquilla esquerra "+forquillaEsquerra.getNumero());
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
    private boolean agafarForquilles() throws InterruptedException {
        boolean agafatEsquerra = false;
        boolean agafatDreta = false;
        agafatEsquerra = agafaForquillaEsquerra();
        if (agafatEsquerra) {
            System.out.println("Filòsof: " + nom + " agafa la forquilla esquerra " + forquillaEsquerra.getNumero());
            agafatDreta = agafaForquillaDreta();
            if (agafatDreta) {
                System.out.println("Filòsof: " + nom + " agafa la forquilla dreta " + forquillaDreta.getNumero());
                System.out.println("Filòsof: " + nom + " menja");
                Thread.sleep(random.nextInt(1000) + 1000);
                deixarForquilles();
                System.out.println("Filòsof: " + nom + " deixa la forquilla dreta " + forquillaDreta.getNumero());
            } else {
                deixarForquilles();
                System.out.println("Filòsof: " + nom + " deixa l'esquerra (" + forquillaEsquerra.getNumero() + ") i espera (dreta ocupada)");
                gana++;
                System.out.println("Filòsof: " + nom + " gana=" + gana);
            }
        } else {
            System.out.println("Filòsof: " + nom + " no pot agafar la forquilla esquerra " + forquillaEsquerra.getNumero());
        }
        if (!agafatEsquerra || !agafatDreta) {
            Thread.sleep(random.nextInt(500) + 500);
        }
        return agafatEsquerra && agafatDreta;
    }
    private boolean agafaForquillaEsquerra() throws InterruptedException {
        return forquillaEsquerra.agafar(comensal);
    }
    private boolean agafaForquillaDreta() throws InterruptedException {
        return forquillaDreta.agafar(comensal);
    }
    private void deixarForquilles() {
        if (forquillaEsquerra.getPropietari() == comensal) {
            forquillaEsquerra.deixar();
        }
        if (forquillaDreta.getPropietari() == comensal) {
            forquillaDreta.deixar();
        }
    }
    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                menjar();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Filòsof: "+nom+" ha estat interromput");
        }
    }
}
