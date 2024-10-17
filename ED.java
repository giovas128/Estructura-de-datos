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
		    	separar(pila);
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

    public static void separar(int[] pila){
    	int[] pilaM3 = new int[t];
        int[] pilaM5 = new int[t];
        int[] pilaM7 = new int[t];
        int topeM3 = 0;
        int topeM5 = 0;
        int topeM7 = 0;
        for (int i = tope - 1; i >= 0; i--) {
            int valor = pila[i];
            if (valor % 3 == 0) {
                pilaM3[topeM3] = valor;
                topeM3++;
            }
            if (valor % 5 == 0) {
                pilaM5[topeM5] = valor;
                topeM5++;
            }
            if (valor % 7 == 0) {
                pilaM7[topeM7] = valor;
                topeM7++;
            }
        }
        System.out.println("Pila M3 (múltiplos de 3):");
        mostrarPila(pilaM3, topeM3);
        System.out.println("Pila M5 (múltiplos de 5):");
        mostrarPila(pilaM5, topeM5);
        System.out.println("Pila M7 (múltiplos de 7):");
        mostrarPila(pilaM7, topeM7);
    }

    public static void mostrarPila(int[] pila, int tope) {
        if (tope == 0) {
            System.out.println("La pila está vacía.");
        } else {
            for (int i = tope - 1; i >= 0; i--) {
                System.out.println(pila[i]);
            }
        }
    }
}