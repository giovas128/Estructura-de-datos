package ExamenA2;

import java.util.Random;

public class Operaciones {
    static Nodo listaA;
    static Nodo listaB;
    static Nodo listaC;
    static Nodo UnionB;

    public Operaciones() {
        listaA = null;
        listaB = null;
        listaC = null;
        UnionB = null;
    }

    public static void llenar() {
        llenarListaA();
        llenarListaB();
        llenarListaC();
        System.out.println("Listas llenadas exitosamente.");
    }

    private static void llenarListaA() {
        String letrasMinusculas = "abcdefghijklmnopqrstuvwxyz";
        listaA = generarListaUnica(letrasMinusculas, 10);
    }

    private static void llenarListaB() {
        String letrasMayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        listaB = generarListaUnica(letrasMayusculas, 10);
    }

    private static void llenarListaC() {
        String caracteresEspeciales = "¡\"#$%&/()=?¡¨[];:_/*-+";
        listaC = generarListaUnica(caracteresEspeciales, 10);
    }

    private static Nodo generarListaUnica(String caracteres, int cantidad) {
        Random rand = new Random();
        Nodo cabeza = null;
        int intentos = 0;
        while (cantidad > 0 && intentos < 100) { 
            char c = caracteres.charAt(rand.nextInt(caracteres.length()));
            if (!existeEnLista(cabeza, c)) {
                Nodo nuevo = new Nodo(c);
                nuevo.sig = cabeza;
                cabeza = nuevo;
                cantidad--;
            }
            intentos++;
        }
        if (cantidad > 0) {
            System.out.println("No se pudieron generar suficientes caracteres únicos.");
        }
        return cabeza;
    }

    private static boolean existeEnLista(Nodo cabeza, char c) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato == c) {
                return true;
            }
            actual = actual.sig;
        }
        return false;
    }

    public static void sumar() {
        
        UnionB = null;

        apilarLista(listaA);
        
        apilarLista(listaB);
        
        apilarLista(listaC);

        System.out.println("Listas combinadas en UnionB respetando LIFO.");
        imprimirLista(UnionB, "UnionB");
    }

    private static void apilarLista(Nodo lista) {
        Nodo actual = lista;
        while (actual != null) {
            Nodo nuevo = new Nodo(actual.dato);
            nuevo.sig = UnionB;
            UnionB = nuevo;
            actual = actual.sig;
        }
    }

    public static void imprimirLista(Nodo cabeza, String nombreLista) {
    System.out.print(nombreLista + ": ");
    Nodo actual = cabeza;
    while (actual != null) {
        System.out.print((char) actual.dato + " ");
        actual = actual.sig;
    }
    System.out.println();
}

}
