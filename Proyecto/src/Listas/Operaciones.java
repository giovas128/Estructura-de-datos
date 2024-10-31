package Listas;

public class Operaciones {
    Nodo inicio;

    public Operaciones() {
        this.inicio = null;
    }

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

    public void agregarEnPosicion(String dato, int posicion) {
        Nodo nuevo = new Nodo(dato);
    
        if (posicion == 1) {
            nuevo.siguiente = inicio;
            inicio = nuevo;
            System.out.println("Elemento agregado en la posición 1: " + dato);
        } else {
            Nodo temp = inicio;
            int contador = 1; 
    
            while (temp != null && contador < posicion - 1) {
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

    public void eliminarUltimo() {
        if (inicio == null) {
    System.out.println("La lista está vacía.");
} else if (inicio.siguiente == null) {
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

    public void eliminarPrimero() {
        if (inicio == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.println("Eliminando primer elemento: " + inicio.dato);
        inicio = inicio.siguiente;
    }

    public void eliminarEspecial(String dato) {
        if (inicio == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        if (inicio.dato.equals(dato)) {
            System.out.println("Eliminando elemento especial: " + inicio.dato);
            inicio = inicio.siguiente;
            return;
        }

        Nodo temp = inicio;
        while (temp.siguiente != null) {
            if (temp.siguiente.dato.equals(dato)) {
                System.out.println("Eliminando elemento especial: " + temp.siguiente.dato);
                temp.siguiente = temp.siguiente.siguiente; 
                return;
            }
            temp = temp.siguiente;
        }
        System.out.println("Elemento no encontrado: " + dato);
    }
}