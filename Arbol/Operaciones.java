package Arbol;

public class Operaciones {

    Nodo inicio;

    public Operaciones() {
        this.inicio = null;
    }

    public void agregar(int dato) {
        inicio = agregarRecursivo(inicio, dato);
    }

    private Nodo agregarRecursivo(Nodo actual, int dato) {
        if (actual == null) {
            return new Nodo(dato);
        }

        if (dato < actual.valor) {
            actual.izq = agregarRecursivo(actual.izq, dato);
        } else if (dato > actual.valor) {
            actual.der = agregarRecursivo(actual.der, dato);
        } else {
            System.out.println("El valor " + dato + " ya existe en el árbol.");
        }

        return actual;
    }

    public void mostrarArbol() {
        mostrarArbolRecursivo(inicio, "", true);
    }

    private void mostrarArbolRecursivo(Nodo nodo, String prefix, boolean esUltimo) {
        if (nodo != null) {
            System.out.print(prefix);

            System.out.print(esUltimo ? "└-- " : "|-- ");
            
            System.out.println(nodo.valor);

            String nuevoPrefijo = prefix + (esUltimo ? "    " : "|   ");

            mostrarArbolRecursivo(nodo.izq, nuevoPrefijo, false);
            mostrarArbolRecursivo(nodo.der, nuevoPrefijo, true);
        }
    }
}
