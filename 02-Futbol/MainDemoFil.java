public class MainDemoFil {
    public static void main(String[] args) {
        // Capturar el fil actual
        Thread currentThread = Thread.currentThread();

        // Mostrar informació sobre el fil actual
        System.out.println(currentThread.getName() + ".main:");
        System.out.println("Prioritat -> " + currentThread.getPriority());
        System.out.println("Nom -> " + currentThread.getName());
        System.out.println("toString() -> " + currentThread.toString());
    }
}
