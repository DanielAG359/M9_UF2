import java.util.LinkedList;
import java.util.Queue;

public class Barberia {
    private final int maxCadires;
    private final Queue<Client> salaEspera;
    private final Object condBarber;
    private static Barberia instancia;

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
