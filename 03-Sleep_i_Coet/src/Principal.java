public class Principal {
    public static void main(String[] args) {
        DormAleatori filJuan = new DormAleatori("Juan");
        DormAleatori filPepe = new DormAleatori("Pepe");
        filPepe.start();
        filJuan.start();
        System.out.println("-- Fi de main -----------");
    }
}