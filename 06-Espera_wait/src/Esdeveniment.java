import java.util.List;
import java.util.ArrayList;

public class Esdeveniment {
    private List<Assistent> reserves;
    private int placesDisponibles;
    public Esdeveniment(int placesMaximes) {
        this.reserves = new ArrayList<>();
        this.placesDisponibles = placesMaximes;
    }
    public synchronized void ferReserva(Assistent assistent) throws InterruptedException {
        while (placesDisponibles == 0) {
            wait();
        }
        reserves.add(assistent);
        placesDisponibles--;
        System.out.println(assistent.getNom() + " ha fet una reserva. Places disponibles: " + placesDisponibles);
        notifyAll();
    }
    public synchronized void cancelaReserva(Assistent assistent) {
        if (reserves.contains(assistent)) {
            reserves.remove(assistent);
            placesDisponibles++;
            System.out.println(assistent.getNom() + " ha cancel·lat una reserva. Places disponibles: " + placesDisponibles);
            notifyAll();
        } else {
            System.out.println(assistent.getNom() + " no ha pogut cancel·lar una reserva inexistent. Places disponibles: " + placesDisponibles);
        }
    }
}
