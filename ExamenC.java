import java.util.Scanner;
import java.util.Random;

public class ExamenC{
	static int tope = 0;
	static int tope2 = 0;
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
        char[] pila = new char[t];
        char[] pila2 = new char[t];
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
                    eliminar(pila,pila2);
                    break;
                case 4:
                    llenado(t,pila);
                    break;
                case 5:
                	mostrarE(pila2);
                    break;
                case 6:
                	break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opt != 6);
    }

    public static void menu(){
        System.out.println("Menú:\n"
                    + "1- Agregar\n"
                    + "2- Mostrar Pila\n"
                    + "3- Eliminar\n"
                    + "4- Llenar\n"
                    + "5- Mostrar Eliminados\n"
                    + "6-salir");
    }

     public static void agregar(int t, char[] pila){
        Scanner sc = new Scanner(System.in);
        if (tope >= t) {
            System.out.println("Error: la pila está llena.");
        } else {
            System.out.println("Agrega el valor:");
            char letra = sc.next().charAt(0);
            while (!Character.isLetter(letra)) {
                System.out.println("Error: solo se permiten letras. Intente de nuevo.");
                letra = sc.next().charAt(0);
            }
             boolean existe = false;
                for (int i = 0; i < tope; i++) {
                    if (pila[i] == letra) {
                        existe = true;
                        System.out.println("Ingrese una letra diferente");
                        break;
                    }
                }
                if (!existe) {
                    pila[tope] = letra;
                    tope++;
                }
        }
    }

    public static void mostrar(char[] pila){
        if (tope == 0) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("Contenido de la pila:");
            for (int i = tope - 1; i >= 0; i--) {
                System.out.println("pilaPosicion "+(i+1)+" con el valor "+pila[i]);
            }
        }
    }
    public static void eliminar(char[] pila, char[] pila2){
        if (tope == 0) {
            System.out.println("Error: la pila está vacía. No hay elementos para eliminar.");
        } else {
            tope--;
            System.out.println("Último valor eliminado.");
            char eliminar = pila[tope];
            pila2[tope2] = eliminar;
            tope2++;
        }
    }
    public static void mostrarE(char[] pila2){
        if (tope2 == 0) {
            System.out.println("No hay valores eliminados.");
        } else {
            System.out.println("Contenido de la pila de eliminados:");
            for (int i = tope2 - 1; i >= 0; i--) {
                System.out.println("pilaPosicion "+(i+1)+" con el valor "+pila2[i]);
            }
        }
    }
    public static void llenado(int t, char[] pila){
        if (tope >= t) {
            System.out.println("Error: la pila está llena.");
        }else{
            Random random = new Random();
            while (tope < t) {
            char letra = (char) (random.nextInt(26) + 'A');
            boolean existe = false;
                for (int i = 0; i < tope; i++) {
                    if (pila[i] == letra) {
                        existe = true;
                    }
                }
                if (!existe) {
                    pila[tope] = letra;
                    tope++;
                }
            }
        }
    }
}