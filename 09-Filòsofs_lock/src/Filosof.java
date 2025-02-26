import java.util.Random;

public class Filosof extends Thread {
    private String nom;
    private int iniciGana;
    private int fiGana;
    private int gana;
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;

    public Filosof(String nom, Forquilla esquerra, Forquilla dreta) {
        this.nom = nom;
        this.forquillaEsquerra = esquerra;
        this.forquillaDreta = dreta;
        this.fiGana = (int) (System.currentTimeMillis() / 1000);
    }
    @Override
    public void run() {
        while (true) {
            pensar();
            menjar();
        }
    }
    public void menjar() {
        resetGana();
        agafarForquilles();
        calculaGana();
        System.out.println(nom + " menja amb gana " + gana);
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(2000 - 1000 + 1) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fiGana = (int) (System.currentTimeMillis())/ 1000;
        gana = fiGana - iniciGana;
        System.out.println(nom + " ha acabat de menjar");
        deixarForquilles();
    }
    public void pensar() {
        System.out.println(nom + " pensant");
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(2000 - 1000 + 1) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void agafarForquilles() {
        while (true) {
            forquillaEsquerra.agafar();
            if (forquillaDreta.getBloqueig().tryLock()) {
                break;
            } else {
                forquillaEsquerra.deixar();
                try {
                    Random random = new Random();
                    Thread.sleep(random.nextInt(1000 - 500 + 1) + 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(nom + " té forquilles esq(" + forquillaEsquerra.getNum() + ") dreta(" + forquillaDreta.getNum() + ")");
    }
    public void agafarForquillaEsquerra() {
        forquillaEsquerra.agafar();
    }
    public void agafarForquillaDreta() {
        forquillaDreta.agafar();
    }
    public void deixarForquilles() {
        forquillaDreta.deixar();
        forquillaEsquerra.deixar();
    }
    public void resetGana() {
        iniciGana = (int) (System.currentTimeMillis())/ 1000;
    }
    public void calculaGana() {
        System.out.println("Fi gana: "+ fiGana);
        System.out.println("Inici gana: "+ iniciGana);
        this.gana = fiGana - iniciGana;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }
    public void setForquillaEsquerra(Forquilla forquillaEsquerra) {
        this.forquillaEsquerra = forquillaEsquerra;
    }
    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }
    public void setForquillaDreta(Forquilla forquillaDreta) {
        this.forquillaDreta = forquillaDreta;
    }
}
