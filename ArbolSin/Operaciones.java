package ArbolSin;

public class Operaciones {

    static Nodo inicio;

    public Operaciones() {
        this.inicio = null;
    }

    public static void agregar(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (inicio == null) {
            inicio = nuevoNodo;
            return;
        }
        Nodo actual = inicio;
        Nodo padre = null;
        while (actual != null) {
            padre = actual;
            if (valor < actual.valor) {
                actual = actual.izq;
            } else if (valor > actual.valor) {
                actual = actual.der;
            } else {
                return;
            }
        }

        if (valor < padre.valor) {
            padre.izq = nuevoNodo;
        } else {
            padre.der = nuevoNodo;
        }
    }

    public void mostrar(){
        System.out.println("Elemento");
        mostrarEnOrden(inicio);
        System.out.println();
    }

    private void mostrarEnOrden(Nodo nodo) {
        if (nodo != null) {
            mostrarEnOrden(nodo.izq);
            System.out.print(nodo.valor + " ");
            mostrarEnOrden(nodo.der);
        }
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
