package ExamenC2P;

import java.util.Scanner;

public class Principal{

	static int opc = 0;
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Operaciones op = new Operaciones();

		do{
			menu();
            while (!teclado.hasNextInt()) {
                System.out.println("Error: solo se permiten números. Intente de nuevo.");
                teclado.next();
            }
            opc = teclado.nextInt();
            teclado.nextLine();
            switch(opc){
            case 1:
                System.out.print("Ingrese el elemento a agregar: ");
                String dato = teclado.nextLine();
                op.agregar(dato);
                break;
            case 2:
                System.out.print("Ingrese el elemento a agregar: ");
                String datoP = teclado.nextLine();
                op.agregarP(datoP);
                break;
            case 3:
                System.out.print("Ingrese el elemento a agregar: ");
                String datoU = teclado.nextLine();
                op.agregarU(datoU);
                break;
            case 4:
                System.out.print("Ingrese el elemento a agregar: ");
                String nuevoDato = teclado.nextLine();
                System.out.print("Ingrese la posición donde agregarlo: ");
                int posicion = teclado.nextInt();
                teclado.nextLine();
                op.agregarE(nuevoDato, posicion);
                break;
            case 5:
                op.mostrar();
                break;
            case 6: 
            	String[] resultados = op.agregarM(); 
                System.out.println("Múltiplos de 2:");
                System.out.println(resultados[0]); 
                System.out.println("Múltiplos de 3:");
                System.out.println(resultados[1]); 
                break;
            case 7:
            	break;
            default:
            	System.out.println("No existe esa opcion");
            	break;
            }
		}while(opc != 7);
		teclado.close();
	}

	public static void menu(){
        System.out.println("Menu:\n"
                          +"1.-Agregar\n"
                          +"2.-Agregar Primero\n"
                          +"3.-Agregar Ultimo\n"
                          +"4.-Agregar Especial\n"
                          +"5.-Mostrar\n"
                          +"6.-Agregar Multiplos\n"
                          +"7.-Salir");
    }
}