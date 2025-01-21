import java.util.Random;

public class Treballador extends Thread {
    private float nou_anual_brut;
    private int edat_inici_treball;
    private int edat_fi_treball;
    private String nom;
    private int edat_actual;
    private float cobrat;
    private Random rnd;
    public float getCobrat() {
        return cobrat;
    }
    public int getEdat() {
        return edat_actual;
    }
    public Treballador(String nom, float nou_anual_brut, int edat_inici_treball, int edat_fi_treball) {
        this.nom = nom;
        this.nou_anual_brut = nou_anual_brut;
        this.edat_inici_treball = edat_inici_treball;
        this.edat_fi_treball = edat_fi_treball;
        this.edat_actual = 0;
        this.cobrat = 0.0f;
        this.rnd = new Random();
    }
    @Override
    public void run() {
        for (int edat = edat_inici_treball; edat <= edat_fi_treball; edat++) {
            edat_actual = edat;
            this.cobra();
            this.pagaImpostos();
            try {
                Thread.sleep(rnd.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void cobra() {
        this.cobrat += nou_anual_brut / 12;
    }
    public void pagaImpostos() {
        this.cobrat -= (nou_anual_brut / 12) * 0.24f;
    }
}
