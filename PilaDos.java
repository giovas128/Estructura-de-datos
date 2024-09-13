import java.util.Scanner;

public class PilaDos {
    static int tope = 0;
    static int t = 0;
    static int opt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tamaño de la pila");
        while (!sc.hasNextInt()) {
            System.out.println("Error: solo se permiten números. Intente de nuevo.");
            sc.next();
        }
        t = sc.nextInt();

        String[] pila = new String[t];
        do {
            menu();
            while (!sc.hasNextInt()) {
                System.out.println("Error: solo se permiten números. Intente de nuevo.");
                sc.next();
            }
            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    agregar(t,pila);
                    break;
                case 2:
                    mostrar(pila);
                    break;
                case 3:
                    eliminar();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opt != 4);
    }

    public static void menu(){
        System.out.println("Menú:\n"
                    + "1- Agregar valor a la pila\n"
                    + "2- Mostrar pila\n"
                    + "3- Eliminar valor de la pila\n"
                    + "4- Salir\n");
    }


    public static void agregar(int t, String[] pila){
        Scanner sc = new Scanner(System.in);
        if (tope >= t) {
            System.out.println("Error: la pila está llena.");
        } else {
            System.out.println("Agrega el valor:");
            String valor = sc.nextLine();
            while (!valor.matches("[a-z]+")) {
                System.out.println("Error: solo se permiten letras. Intente de nuevo.");
                valor = sc.nextLine();
            }
            pila[tope] = valor;
            tope++;
            System.out.println("Valor agregado.");
        }
    }


    public static void mostrar(String[] pila){
        if (tope == 0) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("Contenido de la pila:");
            for (int i = tope - 1; i >= 0; i--) {
                System.out.println(pila[i]);
            }
        }
    }


    public static void eliminar(){
        if (tope == 0) {
            System.out.println("Error: la pila está vacía. No hay elementos para eliminar.");
        } else {
            tope--;
            System.out.println("Último valor eliminado.");
        }
    }
}
