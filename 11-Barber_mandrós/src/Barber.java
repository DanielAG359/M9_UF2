public class Barber extends Thread {
    private String nom;
    private final Barberia barberia;

    public Barber(String nom, Barberia barberia) {
        this.nom = nom;
        this.barberia = barberia;
    }
    @Override
    public void run() {
        while (true) {
            Client client = null;
            synchronized (barberia.getCondBarber()) {
                client = barberia.seguentClient();
                if (client == null) {
                    System.out.println("Ningú en espera");
                    try {
                        System.out.println("Barber " + nom + " dormint");
                        barberia.getCondBarber().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (client != null) {
                System.out.println("Li toca al client " + client.getNom());
                client.tallarseElCabell();
                try {
                    Thread.sleep(900 + (int) (Math.random() * 100)); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public String getNom() {
        return nom;
    }
}
