public class Forquilla {
    private int numero;
    private int propietari;
    private static final int LLIURE = -1;
    public Forquilla(int numero) {
        this.numero = numero;
        this.propietari = LLIURE;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getPropietari() {
        return propietari;
    }
    public void setPropietari(int propietari) {
        this.propietari = propietari;
    }
    public static int getLLIURE() {
        return LLIURE;
    }
    public synchronized boolean agafar(int propietari)  throws InterruptedException {
        if (propietari != LLIURE) {
            wait();
        }
        this.propietari = propietari;
        return true;
    }
    public synchronized void deixar() {
        this.propietari = LLIURE;
        notifyAll();
    }
}