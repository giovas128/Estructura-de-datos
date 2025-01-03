package ArbolSin;

import java.util.Scanner;

public class Principal{

	static int opt = 0;
	static int t = 0;

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Operaciones op = new Operaciones();
		
        do{
        	menu();
        	while (!teclado.hasNextInt()) {
                System.out.println("Error: solo se permiten números. Intente de nuevo.");
                teclado.next();
            }
            opt = teclado.nextInt();
            teclado.nextLine();

            switch (opt) {
            	case 1:
            		System.out.println("Ingrese el elemento a agregar: ");
            		int dato = teclado.nextInt();
                    op.agregar(dato);
            		break;
            	case 2:
            		op.mostrar();
            		break;
            	case 3:
            		break;
            	default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }while(opt != 3);
        teclado.close();
	}

	public static void menu(){
		System.out.println("Menu:\n"
	                      +"1.-Agregar\n"
	                      +"2.-Mostrar\n"
	                      +"3.-Salir");
	}
}