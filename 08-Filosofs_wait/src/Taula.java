public class Taula {
    private Filosof[] filosofs;
    private Forquilla[] forquilles;

    public Taula(int numFilosofs) {
        this.forquilles = new Forquilla[numFilosofs];
        this.filosofs = new Filosof[numFilosofs];
        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }
        for (int i = 0; i < numFilosofs; i++) {
            Forquilla forquillaEsquerra = forquilles[i];
            Forquilla forquillaDreta = forquilles[(i + 1) % numFilosofs];
            filosofs[i] = new Filosof("fil" + i, forquillaEsquerra, forquillaDreta, i);
        }
    }
    public void showTaula() {
        for (int i = 0; i < filosofs.length; i++) {
            System.out.println("Comensal: " + filosofs[i].getNom() +
                    " esq: " + filosofs[i].getForquillaEsquerra().getNumero() +
                    " dret: " + filosofs[i].getForquillaDreta().getNumero());
        }
        System.out.println("-----------------------------");
    }
    public void cridarATaula() {
        for (Filosof filosof : filosofs) {
            new Thread(filosof).start();
        }
    }
    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        taula.cridarATaula();
    }
}
