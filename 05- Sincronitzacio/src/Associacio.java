public class Associacio {
    private static final int numSocis = 1000;
    private Soci[] socis = new Soci[numSocis];
    private Compte compte;

    public Associacio() {
        this.compte = Compte.getInstance();
        for (int i = 0; i < numSocis; i++) {
            socis[i] = new Soci(compte);
        }
    }

    public void iniciaCompteTempsSocis() {
        for (Soci soci : socis) {
            soci.start();
        }
    }

    public void esperaPeriodeSocis() {
        for (Soci soci : socis) {
            try {
                soci.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void mostraBalancComptes() {
        System.out.println("Saldo final del compte: " + compte.getSaldo());
    }

    public static void main(String[] args) {
        Associacio associacio = new Associacio();
        associacio.iniciaCompteTempsSocis();
        associacio.esperaPeriodeSocis();
        associacio.mostraBalancComptes();
    }
}