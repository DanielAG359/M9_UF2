public class Principal {
    public static void main(String[] args) {
        Fil filJuan = new Fil("Juan");
        Fil filPepe = new Fil("Pepe");
        filPepe.start();
        filJuan.start();
        System.out.println("Termina thread main");
    }
}
