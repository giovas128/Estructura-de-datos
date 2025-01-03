package ExamenC2P;

public class Operaciones{

	Nodo inicio;

	public Operaciones(){
		this.inicio = null;
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

    public void agregarE(String dato, int posicion) {
        int valor = Integer.parseInt(dato);
        if (valor % 3 != 0) {
            System.out.println("El valor no es impar. No se puede agregar en una posición específica.");
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

     public String[] agregarM() {
        Nodo actual = inicio;
        Nodo multiplosDe3 = null;
        Nodo multiplosDe5 = null;

        while (actual != null) {
            int valor = Integer.parseInt(actual.dato);
            if (valor % 2 == 0) {
                Nodo nuevoNodo = new Nodo(actual.dato);
                nuevoNodo.siguiente = multiplosDe3;
                multiplosDe3 = nuevoNodo;
            }
            if (valor % 3 == 0) {
                Nodo nuevoNodo = new Nodo(actual.dato);
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

    private String obtenerListaComoTexto(Nodo nodo) {
        StringBuilder builder = new StringBuilder();
        Nodo actual = nodo;
        while (actual != null) {
            builder.append(actual.dato).append("\n");
            actual = actual.siguiente;
        }
        return builder.toString();
    }


}