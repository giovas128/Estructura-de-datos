package ExamenE2P;

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
                System.out.print("Ingrese el elemento a agregar (solo números primos): ");
                String primoDato = teclado.nextLine();
                System.out.print("Ingrese la posición donde agregarlo: ");
                int primoPosicion = teclado.nextInt();
                teclado.nextLine();
                op.agregarE(primoDato, primoPosicion);
                break;
            case 5:
                op.mostrar();
                break;
            case 6: 
            	op.encontrarMaximoYMinimo();
                break;
            case 7:
            	System.out.print("Ingrese el inicio del rango: ");
                int inicioRango = teclado.nextInt();
                System.out.print("Ingrese el fin del rango: ");
                int finRango = teclado.nextInt();
                teclado.nextLine();
                op.eliminarEnRango(inicioRango, finRango);
            	break;
            case 8:
            	break;
            default:
            	System.out.println("No existe esa opcion");
            	break;
            }
		}while(opc != 8);
		teclado.close();
	}

	public static void menu(){
        System.out.println("Menu:\n"
                          +"1.-Agregar\n"
                          +"2.-Agregar Primero\n"
                          +"3.-Agregar Ultimo\n"
                          +"4.-Agregar Especial\n"
                          +"5.-Mostrar\n"
                          +"6.-Encontrar Maximo y Minimo\n"
                          +"7.-EliminarEnRango\n"
                          +"8.-Salir");
    }
}