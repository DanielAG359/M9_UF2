import java.util.Scanner;

public class Coet {
    public static void main(String[] args) {
        Motor[] motors = new Motor[4];
        for (int i = 0; i < 4; i++) {
            motors[i] = new Motor(i);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix la potència objectiu: ");
        int potenciaObjectiu = scanner.nextInt();
        passaAPotencia(potenciaObjectiu, motors);
        arranca(motors);
        gestionarPotencies(motors);
        scanner.close();
    }

    public static void arranca(Motor[] motors) {
        for (int i = 0; i < 4; i++) {
            motors[i].start();
        }
    }

    public static void passaAPotencia(int p, Motor[] motors) {
        if (p < 0 || p > 10) {
            System.out.println("Potència no vàlida. Ha de ser entre 0 i 10.");
            return;
        }
        System.out.println("Passant a potència " + p);
        for (int i = 0; i < 4; i++) {
            motors[i].setPotencia(p);
        }
    }

    public static void gestionarPotencies(Motor[] motors) {
        Scanner scanner = new Scanner(System.in);
        int potenciaObjectiu;

        while (true) {
            System.out.print("Introdueix la potència objectiu: ");
            potenciaObjectiu = scanner.nextInt();
            passaAPotencia(potenciaObjectiu, motors);

            if (potenciaObjectiu == 0) {
                break;
            }
        }
        scanner.close();
    }
}

