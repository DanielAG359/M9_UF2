public class Fumador extends Thread {
    private final Estanc estanc;
    private final int id;
    private Tabac tabac = null;
    private Llumi llumi = null;
    private Paper paper = null;
    private int fumades = 0;
    public Fumador(Estanc estanc, int id) {
        this.estanc = estanc;
        this.id = id;
    }
    public int getFumades() {
        return fumades;
    }
    public void afegirTabac(Tabac tabac) {
        this.tabac = tabac;
    }
    public void afegirLlumi(Llumi llumi) {
        this.llumi = llumi;
    }
    public void afegirPaper(Paper paper) {
        this.paper = paper;
    }
    public void incrementarFumades() {
        this.fumades++;
    }
    private void fuma() throws InterruptedException {
        if (tabac != null && llumi != null && paper != null) {
            System.out.println("Fumador " + id + " està fumant...");
            Thread.sleep((long) (500 + Math.random() * 500));
            incrementarFumades();
            System.out.println("Fumador " + id + " ha fumat " + fumades + " vegades.");
            tabac = null;
            llumi = null;
            paper = null;
        }
    }
    private void compraTabac() throws InterruptedException {
        afegirTabac(estanc.venTabac());
        System.out.println("Fumador " + id + " ha comprat tabac.");
    }
    private void compraLlumi() throws InterruptedException {
        afegirLlumi(estanc.venLlumi());
        System.out.println("Fumador " + id + " ha comprat llumí.");
    }
    private void compraPaper() throws InterruptedException {
        afegirPaper(estanc.venPaper());
        System.out.println("Fumador " + id + " ha comprat paper.");
    }
    @Override
    public void run() {
        try {
            while (fumades < 3) {
                compraTabac();
                compraLlumi();
                compraPaper();
                fuma();
            }
            System.out.println("Fumador " + id + " ha acabat de fumar.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}