import java.util.LinkedList;
import java.util.Queue;

public class Barberia {
    private final int maxCadires;
    private final Queue<Client> salaEspera;
    private final Object condBarber;
    private static Barberia instancia;

    public static void main(String[] args) {
        Barberia.crearInstancia(3);
        Barberia barberia = Barberia.getInstancia();
        Barber barber = new Barber("Pepe", barberia);
        barber.start();
        for (int i = 1; i <= 10; i++) {
            final int id = i;
            new Thread(() -> {
                try {
                    Thread.sleep(500 * id);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Client client = new Client(id);
                barberia.entrarClient(client);
            }).start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 11; i <= 20; i++) {
            final int id = i;
            new Thread(() -> {
                try {
                    Thread.sleep(500 * id);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Client client = new Client(id);
                barberia.entrarClient(client);
            }).start();
        }
    }
    public Barberia(int maxCadires) {
        this.maxCadires = maxCadires;
        this.salaEspera = new LinkedList<>();
        this.condBarber = new Object();
    }
    public void entrarClient(Client client) {
        synchronized (condBarber) {
            if (salaEspera.size() < maxCadires) {
                salaEspera.offer(client);
                System.out.println("Client " + client.getNom() + " en espera");
                condBarber.notify(); 
            } else {
                System.out.println("No queden cadires, client " + client.getNom() + " se'n va");
            }
        }
    }
    public Client seguentClient() {
        synchronized (condBarber) {
            return salaEspera.poll();
        }
    }
    public Object getCondBarber() {
        return condBarber;
    }
    public static Barberia getInstancia() {
        return instancia;
    }
    public static void crearInstancia(int maxCadires) {
        if (instancia == null) {
            instancia = new Barberia(maxCadires);
        }
    }
}
