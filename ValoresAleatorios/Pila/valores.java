package Pila;

import java.util.Random;

public class valores{
    static int tope = 0;
    static String[] pila;

    public static void mostrar(String[] pila){
        if (tope == 0) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("Contenido de la pila:");
            for (int i = tope - 1; i >= 0; i--) {
                System.out.println(pila[i]);
            }
        }
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

    public static void llenado(int t, String[] pila){
        if (tope >= t) {
            System.out.println("Error: la pila está llena.");
        }else{
            Random random = new Random();
            while (tope < t) {
            String espacio = "";
                char letraM = (char) (random.nextInt(26) + 'A');
                espacio += letraM;

                char letra = (char) (random.nextInt(26) + 'a');
                espacio += letra;

                letra = (char) (random.nextInt(26) + 'a');
                espacio += letra;

                char[] especiales = {'@', '+', '-', '/', '%', '*', '!', '?', '&'};
                char letraE = especiales[random.nextInt(especiales.length)];
                espacio += letraE;

                letraE = especiales[random.nextInt(especiales.length)];
                espacio += letraE;

                int numero = (int) (random.nextInt(9));
                espacio += numero;
            pila[tope] = espacio;
            tope++;
            }
        }
    }
}