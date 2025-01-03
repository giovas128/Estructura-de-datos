package EXAMEND2P;

import java.util.Random;

public class Operaciones {
    static Nodo inicio;

    public Operaciones() {
        inicio = null;
    }

    public static String llenar() {
        Random random = new Random();
        int contador = 0;
    
        while (contador < 100) {
            int valor = random.nextInt(300) + 1;
            if (!existeValor(valor)) {  
                Nodo nuevo = new Nodo(valor);
                nuevo.siguiente = inicio;
                inicio = nuevo;
                contador++;
            }
        }

        return obtenerListaComoTexto();  
    }

    private static boolean existeValor(int valor) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.valor == valor) {
                return true;  
            }
            actual = actual.siguiente;
        }
        return false;  
    }

    public static String[] agregarM() {
        Nodo actual = inicio;
        Nodo multiplosDe3 = null;
        Nodo multiplosDe5 = null;
    
        while (actual != null) {
            if (actual.valor % 3 == 0) {
                Nodo nuevoNodo = new Nodo(actual.valor);
                nuevoNodo.siguiente = multiplosDe3;
                multiplosDe3 = nuevoNodo;
            }
            if (actual.valor % 5 == 0) {
                Nodo nuevoNodo = new Nodo(actual.valor);
                nuevoNodo.siguiente = multiplosDe5;
                multiplosDe5 = nuevoNodo;
            }
            actual = actual.siguiente;
        }
    
        return new String[] {
            obtenerListaComoTexto(multiplosDe3),
            obtenerListaComoTexto(multiplosDe5)
        };
    }

    public static String eliminarI() {
        if (inicio == null) return "";

        Nodo actual = inicio;
        Nodo previo = null;
        int pos = 1;
    
        while (actual != null) {
            if (pos % 2 != 0) { 
                if (previo == null) {
                    inicio = actual.siguiente;
                } else {
                    previo.siguiente = actual.siguiente;
                }
            } else {
                previo = actual;
            }
            actual = actual.siguiente;
            pos++;
        }
    
        return obtenerListaComoTexto();  
    }


    public static void mostrar() {
        Nodo actual = inicio;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    private static String obtenerListaComoTexto() {
        return obtenerListaComoTexto(inicio);
    }

    private static String obtenerListaComoTexto(Nodo nodo) {
        StringBuilder builder = new StringBuilder();
        Nodo actual = nodo;
        while (actual != null) {
            builder.append(actual.valor).append("\n");
            actual = actual.siguiente;
        }
        return builder.toString();
    }

}
