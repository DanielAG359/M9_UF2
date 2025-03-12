import java.util.*;
public class Estanc extends Thread{
    private final List<Tabac> tabac = new ArrayList<>();
    private final List<Paper> paper = new ArrayList<>();
    private final List<Llumi> llumi = new ArrayList<>();

    private boolean obert = true;
    public synchronized void nouSubministrament() {
        try {
            Thread.sleep((long) (500 + Math.random() * 1000));
            int producte = new Random().nextInt(3);
            switch (producte) {
                case 0 : {
                    addTabac();
                };
                case 1: {
                    addPaper();
                };
                case 2: {
                    addLlumi();
                };
            }
            notifyAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public synchronized void addTabac() {
        tabac.add(new Tabac());
        System.out.println("Afegint Tabac");
    }
    public synchronized void addPaper() {
        paper.add(new Paper());
        System.out.println("Afegint Paper");
    }
    public synchronized void addLlumi() {
        llumi.add(new Llumi());
        System.out.println("Afegint Llumí");
    }
    public synchronized Tabac venTabac() throws InterruptedException {
        while (tabac.isEmpty() && obert) wait();
        return obert ? tabac.remove(0) : null;
    }
    public synchronized Paper venPaper() throws InterruptedException {
        while (paper.isEmpty() && obert) wait();
        return obert ? paper.remove(0) : null;
    }
    public synchronized Llumi venLlumi() throws InterruptedException {
        while (llumi.isEmpty() && obert) wait();
        return obert ? llumi.remove(0) : null;
    }
    public synchronized void tancarEstanc() {
        obert = false;
        notifyAll();
        System.out.println("Estanc tancat");
    }
    public void run() {
        System.out.println("Estanc obert");
        while (obert) nouSubministrament();
    }
}