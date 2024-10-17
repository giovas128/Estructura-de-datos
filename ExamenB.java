import java.util.Random;
import java.util.Scanner;

public class ExamenB {

    private static int[] pilaA;
    private static int[] pilaB;
    private static int[] pilaC;
    private static int topeA = -1;
    private static int topeB = -1;
    private static int topeC = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño de las pilas: ");
        int tamanoPila = scanner.nextInt();
        
        pilaA = new int[tamanoPila];
        pilaB = new int[tamanoPila];
        pilaC = new int[tamanoPila];

        int opcion;

        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Llenar pilas");
            System.out.println("2. Mostrar pilas");
            System.out.println("3. Unión 1");
            System.out.println("4. Unión 2");
            System.out.println("5. Unión 3");
            System.out.println("6. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    llenarPilas(); 
                    break; 
                case 2:
                    mostrarPilas();
                    break; 
                case 3:
                    union1();    
                    break;   
                case 4:
                    union2(); 
                    break;      
                case 5:
                    union3(); 
                    break;      
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 6);
        scanner.close();
    }
    private static void llenarPilas() {
        llenarPilaA();
        llenarPilaB();
        llenarPilaC();
    }
    private static void llenarPilaA() {
        Random rand = new Random();
        topeA = -1;
        for (int i = 100; i <= 500 && topeA < pilaA.length - 1; i++) {
            if (i % 3 == 0) {
                pilaA[++topeA] = i;
            }
        }
    }


    private static void llenarPilaB() {
        Random rand = new Random();
        topeB = -1;
        for (int i = 100; i <= 200 && topeB < pilaB.length - 1; i++) {
            if (i % 7 == 0) {
                pilaB[++topeB] = i;
            }
        }
    }

    private static void llenarPilaC() {
        Random rand = new Random();
        topeC = -1;
        for (int i = 0; i <= 100 && topeC < pilaC.length - 1; i++) {
            if (i % 5 == 0) {
                pilaC[++topeC] = i;
            }
        }
    }

    // Mostrar el contenido de las pilas
    private static void mostrarPilas() {
        mostrarPila("Pila A", pilaA, topeA);
        mostrarPila("Pila B", pilaB, topeB);
        mostrarPila("Pila C", pilaC, topeC);
    }

    private static void mostrarPila(String nombre, int[] pila, int tope) {
        System.out.println(nombre + ":");
        for (int i = 0; i <= tope; i++) {
            System.out.println("Posición " + (i + 1) + " con el valor " + pila[i]);
        }
    }

    private static void union1() {
        int[] union = new int[topeA + topeB + topeC + 3];
        int indice = 0;

        for (int i = 0; i <= topeA; i++) {
            union[indice++] = pilaA[i];
        }
        for (int i = 0; i <= topeB; i++) {
            union[indice++] = pilaB[i];
        }
        for (int i = 0; i <= topeC; i++) {
            union[indice++] = pilaC[i];
        }

        System.out.println("Unión 1 (Pila A + Pila B + Pila C):");
        mostrarUnion(union);
    }

    // Unión 2: Se intercalan los valores, valor Pila A, valor Pila B, valor Pila C
    private static void union2() {
        int maxSize = Math.max(topeA + 1, Math.max(topeB + 1, topeC + 1));
        int[] union = new int[maxSize * 3];
        int indice = 0;

        for (int i = 0; i < maxSize; i++) {
            if (i <= topeA) {
                union[indice++] = pilaA[i];
            }
            if (i <= topeB) {
                union[indice++] = pilaB[i];
            }
            if (i <= topeC) {
                union[indice++] = pilaC[i];
            }
        }

        System.out.println("Unión 2 (Intercalado A, B, C):");
        mostrarUnion(union);
    }

    // Unión 3: Suma de cada valor correspondiente a la iteración Pila A + Pila B + Pila C
    private static void union3() {
        int maxSize = Math.max(topeA + 1, Math.max(topeB + 1, topeC + 1));
        int[] union = new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            int suma = 0;
            if (i <= topeA) {
                suma += pilaA[i];
            }
            if (i <= topeB) {
                suma += pilaB[i];
            }
            if (i <= topeC) {
                suma += pilaC[i];
            }
            union[i] = suma;
        }

        System.out.println("Unión 3 (Suma A + B + C):");
        mostrarUnion(union);
    }

    // Mostrar los resultados de las uniones
    private static void mostrarUnion(int[] union) {
        for (int i = 0; i < union.length && union[i] != 0; i++) {
            System.out.println("Posición " + (i + 1) + " con el valor " + union[i]);
        }
    }
}