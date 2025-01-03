package EXAMEND2P;

import java.util.Scanner;

public class Principal{

    static int opt = 0;
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
                    op.llenar();
                    break;
                case 2:
                    op.agregarM();
                    break;
                case 3:
                    op.eliminarI();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }while(opt != 4);
        teclado.close();
    }

    public static void menu(){
        System.out.println("Menu:\n"
                          +"1.-Llenar\n"
                          +"2.-Agregar por Multiplo\n"
                          +"3.-Eliminar impares\n"
                          +"4.-Salir");
    }
}