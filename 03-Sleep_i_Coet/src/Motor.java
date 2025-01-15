import java.util.Random;

public class Motor extends Thread{
    private int potenciaActual = 0;
    private int potenciaObjectiu = 0;
    public int id = 0;

    public Motor(int num){
        id = num;
    }
    public void setPotencia(int p) {
        if (p < 0 || p > 10) {
            System.out.println("Potència no vàlida. Ha de ser entre 0 i 10.");
            return;
        }
        potenciaObjectiu = p;
    }
    public void run(){
        Random random = new Random();
        while (true){
            while (potenciaActual != potenciaObjectiu) {
                long randomvalue = random.nextInt(2000) + 1;
                if (potenciaActual < potenciaObjectiu) {
                    System.out.println("Motor " + id + ": Incre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                    potenciaActual++;
                } else {
                    System.out.println("Motor " + id + ": Decre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                    potenciaActual--;
                }
                try {
                    Thread.sleep(randomvalue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(potenciaActual == potenciaObjectiu){
                    System.out.println("Motor " + id + ": FerRes Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(potenciaActual == 0){break;}
        }
    }

    public int getPotenciaActual() {
        return potenciaActual;
    }
}
