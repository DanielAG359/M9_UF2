public class Barri {
    public static void main(String[] args) {
        Estanc estanc = new Estanc();
        Fumador[] fumadors = {new Fumador(estanc, 0), new Fumador(estanc, 1), new Fumador(estanc, 2)};
        estanc.start();
        for (Fumador fumador : fumadors) fumador.start();
        try {
            for (Fumador fumador : fumadors) fumador.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        estanc.tancarEstanc();
    }
}
