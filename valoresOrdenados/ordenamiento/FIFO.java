package ordenamiento;


import java.util.Scanner;

public class FIFO{
	static int t = 0;
	static String[] pila;
	static int tope = 0;
	static int opc=0;
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese el tamaño de la pila:\n");
		while (!teclado.hasNextInt()) {
            System.out.println("Error: solo se permiten números. Intente de nuevo.");
            teclado.next();
        }
        t = teclado.nextInt();
		String[] pila = new String[t];
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
		    	mostrar(pila);
		    	break;
		    case 3:
		    	ordenar(pila);
		    	break;
		    case 4: 
		    	eliminar();
		    	break;
		    case 5:
		    	agregar(pila, t);
		    	break;
		    case 6:
		    	break;
		    default:
		    	System.out.println("No existe esta opcion");
		    	break;
		    }
		}while(opc!= 6);
	}

	public static void menu(){
		System.out.println("\nMenu:\n"
	                      +"1-Llenar\n"
	                      +"2-mostrar\n"
	                      +"3-ordenar\n"
	                      +"4-eliminar\n"
	                      +"5-agregar\n");
	}

	public static void mostrar(String[] pila){
		if (tope == 0) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("Contenido de la pila:");
            for (int i = tope - 1; i >= 0; i--) {
                System.out.print(" "+pila[i]);
            }
        }
	}
	public static void llenar(String[] pila, int t){

	}
	public static void ordenar(String[] pila){

	}
	public static void eliminar(){
		if (tope == 0) {
            System.out.println("Error: la pila está vacía. No hay elementos para eliminar.");
        } else {
            for (int i=0;i<tope;i++) {
                tope--;
            }
            System.out.println("Último valor eliminado.");
        }
	}
	public static void agregar(String[] pila, int t){
		Scanner sc = new Scanner(System.in);
        if (tope >= t) {
            System.out.println("Error: la pila está llena.");
        } else {
            System.out.println("Agrega el valor:");
            String valor = sc.nextLine();
            pila[tope] = valor;
            tope++;
            System.out.println("Valor agregado.");
        }
	}
}