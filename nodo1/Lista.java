package nodo1;

public class Lista {
    private Nodo cabeza;

    // Agrega una nueva palabra al final de la lista
    public void agregarPalabra(String palabra) {
        Nodo nuevoNodo = new Nodo(palabra);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
        }
    }

    // Muestra todos los elementos de la lista como un String
    public String mostrarLista() {
        StringBuilder resultado = new StringBuilder();
        Nodo temp = cabeza;
        if (temp == null) {
            return "";
        }
        while (temp != null) {
            resultado.append(temp.palabra).append("\n");
            temp = temp.siguiente;
        }
        return resultado.toString();
    }

    // Retorna el tamaño de la lista
    public int getTamano() {
        int tamano = 0;
        Nodo temp = cabeza;
        while (temp != null) {
            tamano++;
            temp = temp.siguiente;
        }
        return tamano;
    }

    // Obtiene una palabra en una posición específica de la lista
    public String obtenerPalabra(int index) {
        Nodo temp = cabeza;
        int contador = 0;
        while (temp != null && contador < index) {
            temp = temp.siguiente;
            contador++;
        }
        return (temp != null) ? temp.palabra : null;
    }

    // Convierte la lista a un arreglo de Strings
    public String[] toArray() {
        int tamano = getTamano();
        String[] array = new String[tamano];
        Nodo temp = cabeza;
        int i = 0;
        while (temp != null) {
            array[i++] = temp.palabra;
            temp = temp.siguiente;
        }
        return array;
    }

    // Eliminar el primer nodo de la lista
    public void eliminarPrimero() {
        if (cabeza != null) {
            cabeza = cabeza.siguiente;  // El primer nodo es eliminado
        }
    }

    // Eliminar el último nodo de la lista
    public void eliminarUltimo() {
        if (cabeza == null) {
            return;  // Lista vacía
        }

        if (cabeza.siguiente == null) {
            cabeza = null;  // Solo un nodo, se elimina
            return;
        }

        Nodo temp = cabeza;
        while (temp.siguiente.siguiente != null) {
            temp = temp.siguiente;  // Llegamos al penúltimo nodo
        }
        temp.siguiente = null;  // Eliminamos el último nodo
    }

    // Eliminar un nodo con un valor específico
    public void eliminarPorValor(String valor) {
        if (cabeza == null) {
            return;  // Lista vacía
        }

        if (cabeza.palabra.equals(valor)) {
            cabeza = cabeza.siguiente;  // El primer nodo contiene el valor, lo eliminamos
            return;
        }

        Nodo temp = cabeza;
        while (temp.siguiente != null && !temp.siguiente.palabra.equals(valor)) {
            temp = temp.siguiente;
        }

        if (temp.siguiente != null) {
            temp.siguiente = temp.siguiente.siguiente;  // Eliminamos el nodo con el valor
        }
    }
}
