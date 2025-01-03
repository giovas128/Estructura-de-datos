package ExamenA2;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Operaciones op = new Operaciones();

        int opcion = 0;

        do {
            menu();
            while (!teclado.hasNextInt()) {
                System.out.println("Error: solo se permiten números. Intente de nuevo.");
                teclado.next();
            }
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    op.llenar();
                    // Opcional: Imprimir las listas para verificar
                    imprimirListas(op);
                    break;
                case 2:
                    op.sumar();
                    break;
                case 3:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 3);
        teclado.close();
    }

    public static void menu() {
        System.out.println("\nMenu:");
        System.out.println("1.- Llenar");
        System.out.println("2.- Sumar");
        System.out.println("3.- Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void imprimirListas(Operaciones op) {
        Operaciones.imprimirLista(Operaciones.listaA, "ListaA");
        Operaciones.imprimirLista(Operaciones.listaB, "ListaB");
        Operaciones.imprimirLista(Operaciones.listaC, "ListaC");
    }
}
