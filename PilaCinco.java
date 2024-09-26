import java.util.Scanner;
import java.util.Random;
public class PilaCinco {
    static int topeA = 0;
    static int topeB = 0;
    static int t = 0;
    static int opt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Agregue el tamaño de la pila");
        t = sc.nextInt();

        String[] pilaA = new String[t];
        String[] pilaB = new String[t];
        String[] pilaC = new String[t];
        do {
            System.out.println("Menú:\n"
                    + "1- Llenar A\n"
                    + "2- Llenar B\n"
                    + "3- unir a+b y mostrar C\n"
                    + "4- Salir\n");
            while (!sc.hasNextInt()) {
                System.out.println("Error: solo se permiten números. Intente de nuevo.");
                sc.next();
            }
            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    A(pilaA);
                    break;
                case 2:
                    B(pilaB);
                    break;
                case 3:
                    mostrarc(pilaA, pilaB, pilaC);
                    break;
                case 4:
                    
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opt != 4);
    }

    public static void A(String[] pilaA){
        if (topeA >= t) {
            System.out.println("está llena.");
        }else{
            Random random = new Random();
            while (topeA < t) {
            String celdas = "";
            char letraM = (char) (random.nextInt(26) + 'A');
            celdas += letraM;
            System.out.println(letraM);
            pilaA[topeA] = celdas;
            topeA++;
            }
        }
    }

     public static void B(String[] pilaB) {
        if (topeB >= t) {
            System.out.println("Error: la pila está llena.");
        } else {
            Random random = new Random();
            while (topeB < t) {
                String celdas = "";
                int numero = random.nextInt(100);
                celdas += numero;
                System.out.println(numero);
                pilaB[topeB] = celdas;
                topeB++;
            }
        }
    }

    public static void mostrarc(String[] pilaA, String[] pilaB, String[] pilac) {
    if (topeA != topeB) {
        System.out.println("Error: las pilas A y B deben tener el mismo tamaño.");
    } else {
        String[] pilaC = new String[t];
        for (int i = 0; i < t; i++) {
            pilaC[i] = pilaA[i] + pilaB[i];
        }
        for (int i = pilaC.length-1;i>=0;i--) {
            System.out.println(pilaC[i]);
        }
    }    
}
}   
               
