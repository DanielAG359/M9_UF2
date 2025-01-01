import java.util.Random;

public class Futbolista extends Thread {
    private static final int NUM_JUGADORS = 11;
    private static final int NUM_TIRADES = 20;
    private static final float PROBABILITAT = 0.5f;
    private int ngols = 0;
    private Random random = new Random();

    public Futbolista(String nom) {
        super(nom);
    }
    @Override
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            if (random.nextFloat() < PROBABILITAT) {
                ngols++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Futbolista[] jugadors = new Futbolista[NUM_JUGADORS];
        jugadors[0] = new Futbolista("Piqué");
        jugadors[1] = new Futbolista("Vinicius");
        jugadors[2] = new Futbolista("Torres");
        jugadors[3] = new Futbolista("Ramos");
        jugadors[4] = new Futbolista("Ronaldo");
        jugadors[5] = new Futbolista("Lewan");
        jugadors[6] = new Futbolista("Belli");
        jugadors[7] = new Futbolista("Arnau");
        jugadors[8] = new Futbolista("Aspas");
        jugadors[9] = new Futbolista("Messi");
        jugadors[10] = new Futbolista("MBapé");
        System.out.println("Inici dels xuts --------------------");
        for (Futbolista jugador : jugadors) {
            jugador.start();
        }
        for (Futbolista jugador : jugadors) {
            jugador.join();
        }
        System.out.println("Fi dels xuts -----------------------");
        System.out.println("--- Estadístiques ------");
        for (Futbolista jugador : jugadors) {
            System.out.println(jugador.getName() + " -> " + jugador.ngols + " gols");
        }
    }
}
