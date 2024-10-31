package app;

import cola.Cola;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Ingrese el tamaño de la cola: ");
        int tamaño = scanner.nextInt();
        
        Cola cola = new Cola(tamaño); 
        for (int i = 0; i < tamaño; i++) {
            System.out.print("Ingrese un número para agregar a la cola: ");
            int numero = scanner.nextInt();
            cola.agregar(numero);
        }

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nOpciones:");
            System.out.println("1. Eliminar el primer valor");
            System.out.println("2. Eliminar el último valor");
            System.out.println("3. Eliminar un valor específico");
            System.out.println("4. Mostrar la cola");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();  

            switch (opcion) {
                case 1:
                    System.out.println("\nEliminando el primer valor...");
                    cola.eliminarPrimerValor();
                    cola.mostrarCola();
                    break;
                case 2:
                    System.out.println("\nEliminando el último valor...");
                    cola.eliminarUltimoValor();
                    cola.mostrarCola();
                    break;
                case 3:
                    System.out.print("\nIngrese un número específico para eliminar de la cola: ");
                    int valorEliminar = scanner.nextInt();
                    cola.eliminarValor(valorEliminar);
                    cola.mostrarCola();
                    break;
                case 4:
                    System.out.println("\nMostrando la cola:");
                    cola.mostrarCola();
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        scanner.close(); 
    }
}
