import java.util.Random;
import java.util.Scanner;

public class Motor extends Thread {
    private int potencia = 0;
    private Random random = new Random();
    public Motor(int potencia) {
        this.potencia = potencia;
    }
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int num = Integer.parseInt(scanner.nextLine());
            long randomValue = random.nextInt(2000) + 1;
            System.out.println("Motor "+(potencia > num ? "Decre." : "Incre." )+" Objectiu:"+num+" Actual: " + potencia);
            if (potencia > num){
                potencia --;
                try {
                    Thread.sleep(randomValue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                potencia ++;
                try {
                    Thread.sleep(randomValue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(potencia == 0){break;}
        }
        scanner.close();
    }
}