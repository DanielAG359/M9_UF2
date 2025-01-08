import java.util.Random;

public class DormAleatori extends Thread {
    private String nom;
    private long startTime;
    private Random random = new Random();
    public DormAleatori(String nom) {
        this.nom = nom;
        this.startTime = System.currentTimeMillis();
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            long randomValue = random.nextInt(10000) + 1;
            System.out.println(nom+"("+i+") a dormir "+randomValue+"ms total "+(System.currentTimeMillis() - startTime));
            try {
                Thread.sleep(randomValue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}