package Agregado;



public class Operaciones{
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

    public void agregarE(String dato, int posicion) {
        int valor = Integer.parseInt(dato);
        if (valor % 2 != 0) {
            System.out.println("El valor no es par. No se puede agregar en una posición específica.");
            return;
        }
        
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

    public void agregarU(String dato) {
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
        System.out.println("Elemento agregado al final: " + dato);
    }

    public void agregarP(String dato) {
        Nodo nuevo = new Nodo(dato);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            nuevo.siguiente = inicio;
            inicio = nuevo;
            System.out.println("Elemento agregado al principio: " + dato);
        }
    }

    public void eliminarPorValor(String valor) {
        int numero = Integer.parseInt(valor);
        if (numero % 2 != 0) {
            System.out.println("Imposible borrar: El valor no es par.");
            return;
        }
        
        if (inicio == null) return;

        if (inicio.dato.equals(valor)) {
            inicio = inicio.siguiente;
            System.out.println("Elemento " + valor + " eliminado.");
            return;
        }

        Nodo temp = inicio;
        while (temp.siguiente != null && !temp.siguiente.dato.equals(valor)) {
            temp = temp.siguiente;
        }

        if (temp.siguiente != null) {
            temp.siguiente = temp.siguiente.siguiente;
            System.out.println("Elemento " + valor + " eliminado.");
        } else {
            System.out.println("El valor " + valor + " no se encuentra en la lista.");
        }
    }

    public int contar(int valor) {
        Nodo temp = inicio;
        int contador = 0;
        while (temp != null) {
            if (Integer.parseInt(temp.dato) > valor) {
                contador++;
            }
            temp = temp.siguiente;
        }
        return contador;
    }
}