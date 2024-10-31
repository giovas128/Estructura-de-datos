package Listas;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Operaciones op = new Operaciones();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar elemento");
            System.out.println("2. Agregar elemento en una posicin");
            System.out.println("3. Mostrar elementos");
            System.out.println("4. Eliminar primer elemento");
            System.out.println("5. Eliminar ultimo elemento");
            System.out.println("6. Eliminar elemento especial");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de leer el entero

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento a agregar: ");
                    String dato = scanner.nextLine();
                    op.agregar(dato);
                    break;
                case 2:
                    System.out.print("Ingrese el elemento a agregar: ");
                    String nuevoDato = scanner.nextLine();
                    System.out.print("Ingrese la posición donde agregarlo: ");
                    int posicion = scanner.nextInt();
                    op.agregarEnPosicion(nuevoDato, posicion);
                    break;
                case 3:
                    op.mostrar();
                    break;
                case 4:
                    op.eliminarPrimero();
                    break;
                case 5:
                    op.eliminarUltimo();
                    break;
                case 6:
                    System.out.print("Ingrese el elemento a eliminar: ");
                    String elementoEspecial = scanner.nextLine();
                    op.eliminarEspecial(elementoEspecial);
                    break;
                case 7:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }
}