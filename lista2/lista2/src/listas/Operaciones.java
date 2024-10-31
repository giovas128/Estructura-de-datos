package Listas;

public class Operaciones {
    Nodo inicio;

    public Operaciones() {
        this.inicio = null;
    }

    // Método para agregar un nodo al final de la lista
    public void agregar(String dato) {
        Nodo nuevo = new Nodo(dato);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo temp = inicio;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        }
        System.out.println("Elemento agregado: " + dato);
    }

    // Método para agregar un nodo en una posición específica
    public void agregarEnPosicion(String dato, int posicion) {
        Nodo nuevo = new Nodo(dato);

        if (posicion == 0) { // Insertar al inicio
            nuevo.siguiente = inicio;
            inicio = nuevo;
            System.out.println("Elemento agregado en la posición 0: " + dato);
        } else {
            Nodo temp = inicio;
            int contador = 0;

            // Recorremos hasta la posición anterior a la deseada
            while (temp != null && contador < posicion - 2) {
                temp = temp.siguiente;
                contador++;
            }

            if (temp == null) {
                System.out.println("La posición está fuera de rango.");
            } else {
                nuevo.siguiente = temp.siguiente;
                temp.siguiente = nuevo;
                System.out.println("Elemento agregado en la posición " + posicion + ": " + dato);
            }
        }
    }

    // Método para mostrar los elementos de la lista
    public void mostrar() {
        Nodo temp = inicio;
        if (temp == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        while (temp != null) {
            System.out.print(temp.dato + " ");
            temp = temp.siguiente;
        }
        System.out.println();
    }

    // Método para eliminar el último elemento
    public void eliminarUltimo() {
        if (inicio == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        if (inicio.siguiente == null) {
            System.out.println("Eliminando último elemento: " + inicio.dato);
            inicio = null;
        } else {
            Nodo temp = inicio;
            while (temp.siguiente.siguiente != null) {
                temp = temp.siguiente;
            }
            System.out.println("Eliminando último elemento: " + temp.siguiente.dato);
            temp.siguiente = null;
        }
    }

    // Método para eliminar el primer elemento
    public void eliminarPrimero() {
        if (inicio == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.println("Eliminando primer elemento: " + inicio.dato);
        inicio = inicio.siguiente;
    }

    // Método para eliminar una cadena específica
    public void eliminarEspecial(String dato) {
        if (inicio == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        // Caso de eliminar el primer nodo
        if (inicio.dato.equals(dato)) {
            System.out.println("Eliminando elemento especial: " + inicio.dato);
            inicio = inicio.siguiente;
            return;
        }

        Nodo temp = inicio;
        while (temp.siguiente != null) {
            if (temp.siguiente.dato.equals(dato)) {
                System.out.println("Eliminando elemento especial: " + temp.siguiente.dato);
                temp.siguiente = temp.siguiente.siguiente; // Eliminar el nodo
                return;
            }
            temp = temp.siguiente;
        }
        System.out.println("Elemento no encontrado: " + dato);
    }
}