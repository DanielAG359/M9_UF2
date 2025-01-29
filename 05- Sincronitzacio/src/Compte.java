public class Compte {
    private static Compte instance = null;
    private float saldo;

    private Compte() {
        this.saldo = 0.0f;
    }

    public static synchronized Compte getInstance() {
        if (instance == null) {
            instance = new Compte();
        }
        return instance;
    }

    public synchronized void ingresar(float cantidad) {
        saldo += cantidad;
    }

    public synchronized void retirar(float cantidad) {
        saldo -= cantidad;
    }

    public synchronized float getSaldo() {
        return saldo;
    }
}