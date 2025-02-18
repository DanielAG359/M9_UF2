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
            filosofs[i] = new Filosof("fil"+i,forquillaEsquerra,forquillaDreta);
        }
    }
    public void showTaula() {

    }
    public void cridarATaula() {
    }
    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        taula.cridarATaula();
    }
}