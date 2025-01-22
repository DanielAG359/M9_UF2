public class Associacio {
    private int numSocis = 1000;
    private Soci[] socis;
    public Associacio() {
        socis = new Soci[numSocis];
        for (int i = 0; i < numSocis; i++) {
            socis[i] = new Soci();
        }
    }

    public static void main(String[] args) {
        Associacio associacio = new Associacio();
        associacio.iniciaCompteTempsSocis();
        associacio.mostraBalancComptes();
    }

    public void iniciaCompteTempsSocis() {
        for (int i = 0; i < numSocis; i++) {
            socis[i].start();
        }
        for (int i = 0; i < numSocis; i++) {
            try {
                socis[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void mostraBalancComptes() {
        double num = 0;
        for (int i = 0; i < numSocis; i++) {
            num = num + socis[i].getCompte();
            // System.out.println("Soci " + (i+1) + " - Saldo: " + socis[i].getCompte());
        }
        System.out.println("Saldo total: " + num);
    }
}
