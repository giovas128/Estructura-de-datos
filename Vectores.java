import java.util.Scanner;

public class Vectores {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese un número para el parámetro:");
        int n = teclado.nextInt();  // Cambié el nombre de 'numero' a 'n' para evitar conflicto.
        String[] palabras = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese una palabra:");
            System.out.println(palabras);
            palabras[i] = teclado.next();
        }

        System.out.println("Las palabras ingresadas son:");
        for (int i = 0; i < n; i++) {
            System.out.println(palabras[i]);
        } // Cierra el scanner para evitar posibles fugas de memoria.
    }
}
