package EA;

import java.util.Random;
import java.util.Scanner;

public class ExamenA{

	static int t = 0;
	static int opc = 0;
	static int tope = 0;
	static int tope2 = 0;
	static int tope3 = 0;

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese el tamaño de la pila: ");
		while (!teclado.hasNextInt()) {
            System.out.println("Error: solo se permiten números. Intente de nuevo.");
            teclado.next();
        }
        t = teclado.nextInt();
		char[] pila = new char[t];
		char[] pila2= new char[t];
		char[] pila3= new char[t];
		do{
		    menu();
		    while (!teclado.hasNextInt()) {
                System.out.println("Error: solo se permiten números. Intente de nuevo.");
                teclado.next();
            }
            opc = teclado.nextInt();
		    switch(opc){
		    case 1:
		    	llenar(pila, pila2, pila3, t);
		    	break;
		    case 2:
		    	mostrar(pila, pila2, pila3);
		    	break;
		    case 3:
		    	unir(pila, pila2, pila3);
		    	break;
		    case 4: 
		    	sumar(pila, pila2, pila3);
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
		System.out.println("menu: \n"
	                      +"1-Llenar\n"
	                      +"2-Mostrar\n"
	                      +"3-Unir\n"
	                      +"4-Sumar\n"
	                      +"5-Salir\n");
	}

	public static void llenar(char[] pila, char[] pila2, char[] pila3, int t){

        tope = 0;
    tope2 = 0;
    tope3 = 0;

		System.out.println("Llenado de la pilaA...");
		pilaA(pila, t);
		System.out.println("Llenado de la PilaB...");
		pilaB(pila2,t);
		System.out.println("Llenado de la PilaC...");
		pilaC(pila3,t);
		System.out.println("Se llenaron las pilas");
	}
	public static void mostrar(char[] pila, char[] pila2, char[] pila3){
		if (tope == 0) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("Contenido de la pilaA en minusculas:");
            for (int i = tope - 1; i >= 0; i--) {
                System.out.println(pila[i]);
            }
        }
        if (tope2 == 0) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("Contenido de la pilaB en mayusculas:");
            for (int i = tope2 - 1; i >= 0; i--) {
                System.out.println(pila2[i]);
            }
        }
        if (tope3 == 0) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("Contenido de la pilaC de lista de caracteres:");
            for (int i = tope3 - 1; i >= 0; i--) {
                System.out.println(pila3[i]);
            }
        }

	}
	public static void unir(char[] pila, char[] pila2, char[] pila3){
		char[] UnionA = new char[tope + tope2 + tope3];
        int index = 0;
        for (int i = tope - 1; i >= 0; i--) {
            UnionA[index++] = pila[i];
        }
        for (int i = tope2 - 1; i >= 0; i--) {
            UnionA[index++] = pila2[i];
        }
        for (int i = tope3 - 1; i >= 0; i--) {
            UnionA[index++] = pila3[i];
        }
        System.out.println("Contenido de la pila UnionA:");
        for (int i = UnionA.length - 1; i >= 0; i--) {
            System.out.println(UnionA[i]);
        }
	}
    public static String[] sumar(char[] pila1, char[] pila2, char[] pila3) {
    int minSize = Math.min(tope, Math.min(tope2, tope3)); 
    String[] UnionB = new String[minSize];
    
    for (int i = 0; i < minSize; i++) {
        UnionB[i] = "" + pila1[tope - 1 - i] + pila2[tope2 - 1 - i] + pila3[tope3 - 1 - i];
    }

    return UnionB; // Retornamos el arreglo con los resultados
}




	public static void pilaA(char[] pila, int t){
		if (tope >= t) {
            System.out.println("Error: la pila está llena.");
        }else{
            Random random = new Random();
            while (tope < t) {
            char letra = (char) (random.nextInt(26) + 'a');
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

	public static void pilaB(char[] pila, int t){
		if (tope2 >= t) {
            System.out.println("Error: la pila está llena.");
        }else{
            Random random = new Random();
            while (tope2 < t) {
            char letra = (char) (random.nextInt(26) + 'A');
            boolean existe = false;
                for (int i = 0; i < tope2; i++) {
                    if (pila[i] == letra) {
                        existe = true;
                    }
                }
                if (!existe) {
                    pila[tope2] = letra;
                    tope2++;
                }
            }
        }
	}

	public static void pilaC(char[] pila, int t){
		if (tope3 >= t) {
            System.out.println("Error: la pila está llena.");
        }else{
            Random random = new Random();
            while (tope3 < t) {
            char[] especiales = {'@', '+', '-', '/', '%', '*', '!', '?', '&'};
            char letra = especiales[random.nextInt(especiales.length)];
            boolean existe = false;
                for (int i = 0; i < tope3; i++) {
                    if (pila[i] == letra) {
                        existe = true;
                    }
                }
                if (!existe) {
                    pila[tope3] = letra;
                    tope3++;
                }
            }
        }
	}
}