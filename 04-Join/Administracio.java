public class Administracio {
    private static final int NUM_POBLACIO_ACTIVA = 50;
    private Treballador[] poblacio_activa;

    public Administracio() {
        poblacio_activa = new Treballador[NUM_POBLACIO_ACTIVA];
        for (int i = 0; i < NUM_POBLACIO_ACTIVA; i++) {
            poblacio_activa[i] = new Treballador("Ciutadà-" + i, 25000.0f, 20, 65);
        }
    }

    public void executarSimulacio() {
        for (int i = 0; i < NUM_POBLACIO_ACTIVA; i++) {
            poblacio_activa[i].start();
        }
        for (int i = 0; i < NUM_POBLACIO_ACTIVA; i++) {
            try {
                poblacio_activa[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < NUM_POBLACIO_ACTIVA; i++) {
            System.out.println("Ciutadà-"+i+" -> edat: "+poblacio_activa[i].getEdat()+" / total: "+poblacio_activa[i].getCobrat());
        }
    }

    public static void main(String[] args) {
        Administracio administracio = new Administracio();
        administracio.executarSimulacio();
    }
}
