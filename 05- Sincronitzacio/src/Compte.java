public class Compte {
    private float saldo;
    private static Compte compte;
    public Compte getCompte() {
        return compte;
    }
    
    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public static Compte creaCompte(){
        if(compte == null){
            compte = new Compte();
        }
        return compte;
    }
    private Compte(){
        setSaldo(0f);
    }
    private Compte(float saldo){
        setSaldo(saldo);
    }
}
