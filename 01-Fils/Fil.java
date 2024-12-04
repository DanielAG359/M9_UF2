public class Fil extends Thread {
    private String nom;
    public Fil(String nom) {
        this.nom = nom;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.printf("%s %d \n", nom, i);
        }
        System.out.println("Termina el fil " + nom);
    }
}
