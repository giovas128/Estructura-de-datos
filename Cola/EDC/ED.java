package EDC;

import java.util.Scanner;
import java.util.Random;

public class ED{
	static int t = 0;
	static int tope = 0;
	static int opc = 0;
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Tamaño de la pila:");
		while (!teclado.hasNextInt()) {
            System.out.println("Error: solo se permiten números. Intente de nuevo.");
            teclado.next();
        }
        t = teclado.nextInt();
		int[] pila = new int[t];
		do{
		    menu();
		    while (!teclado.hasNextInt()) {
                System.out.println("Error: solo se permiten números. Intente de nuevo.");
                teclado.next();
            }
            opc = teclado.nextInt();
		    switch(opc){
		    case 1:
		    	llenar(pila, t);
		    	break;
		    case 2:
		    	agregar(pila, t);
		    	break;
		    case 3:
		    	mostrar(pila);
		    	break;
		    case 4: 
		    	separar3(pila);
                separar5(pila);
                separar7(pila);
		    	break;
		    case 5:
		    	break;
		    default:
		    	System.out.println("No existe esta opcion");
		    	break;
		    }
		}while(opc!= 5);
	}

	public static void menu(){
        System.out.println("Menú:\n"
                    + "1- Llenar\n"
                    + "2- Agregar\n"
                    + "3- Mostrar\n"
                    + "4- Separar\n"
                    + "5-salir");
    }

    public static void llenar(int[] pila, int t){
        if (tope >= t) {
            System.out.println("Error: la pila está llena.");
        }else{
            Random random = new Random();
            while (tope < t) {
            int letra = random.nextInt(300);
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

    public static void agregar(int[] pila, int t){
        Scanner teclado = new Scanner(System.in);
        if (tope >= t) {
            System.out.println("Error: la pila está llena.");
        } else {
            System.out.println("Agrega el valor:");
            while (!teclado.hasNextInt()) {
                System.out.println("Error: solo se permiten letras. Intente de nuevo.");
                teclado.next();
            }
            int letra = teclado.nextInt();
            boolean existe = false;
            for (int i = 0; i < tope; i++) {
                if (pila[i] == letra){
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

    public static void mostrar(int[] pila){
        if (tope == 0) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("Contenido de la pila:");
            for (int i = tope - 1; i >= 0; i--) {
                System.out.println("pilaPosicion "+(i+1)+" con el valor "+pila[i]);
            }
        }
    }

    public static int[] separar3(int[] pila) {
    int[] pilaM3 = new int[pila.length];
    int topeM3 = 0;
        for (int i = 0; i < tope; i++) {
            if (pila[i] % 3 == 0) {
                pilaM3[topeM3] = pila[i];
                topeM3++;
            }
        }
        // Devuelve solo la parte útil del arreglo
        return java.util.Arrays.copyOf(pilaM3, topeM3);
    }
    
    public static int[] separar5(int[] pila) {
        int[] pilaM5 = new int[pila.length];
        int topeM5 = 0;
        for (int i = 0; i < tope; i++) {
            if (pila[i] % 5 == 0) {
                pilaM5[topeM5] = pila[i];
                topeM5++;
            }
        }
        return java.util.Arrays.copyOf(pilaM5, topeM5);
    }
    
    public static int[] separar7(int[] pila) {
        int[] pilaM7 = new int[pila.length];
        int topeM7 = 0;
        for (int i = 0; i < tope; i++) {
            if (pila[i] % 7 == 0) {
                pilaM7[topeM7] = pila[i];
                topeM7++;
            }
        }
        return java.util.Arrays.copyOf(pilaM7, topeM7);
    }
    
}