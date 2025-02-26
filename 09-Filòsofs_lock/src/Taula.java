public class Taula {
    private Filosof[] comensals;
    private Forquilla[] forquilles;

    public Taula(int numComensals) {
        comensals = new Filosof[numComensals];
        forquilles = new Forquilla[numComensals];

        for (int i = 0; i < numComensals; i++) {
            forquilles[i] = new Forquilla(i);
        }

        for (int i = 0; i < numComensals; i++) {
            Forquilla esquerra = forquilles[i];
            Forquilla dreta = forquilles[(i + 1) % numComensals];
            comensals[i] = new Filosof("Fil" + i, esquerra, dreta);
        }
    }
    public void showTaula() {
        for (int i = 0; i < comensals.length; i++) {
            System.out.println("Comensal:" + comensals[i].getNom() + " esq:" + comensals[i].getForquillaEsquerra().getNum() + " dret:" + comensals[i].getForquillaDreta().getNum());
        }
    }
    public void cridarATaula() {
        for (Filosof comensal : comensals) {
            comensal.start();
        }
    }
    public Filosof[] getComensals() {
        return comensals;
    }
    public void setComensals(Filosof[] comensals) {
        this.comensals = comensals;
    }
    public Forquilla[] getForquilles() {
        return forquilles;
    }
    public void setForquilles(Forquilla[] forquilles) {
        this.forquilles = forquilles;
    }
    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        taula.cridarATaula();
    }
}
