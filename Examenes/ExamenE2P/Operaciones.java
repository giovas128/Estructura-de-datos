package ExamenE2P;

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

        if (!esPrimo(valor)) { 
            System.out.println("El valor no es un número primo. No se puede agregar.");
            return;
        }
    
        Nodo nuevo = new Nodo(dato);
        if (posicion == 1) { 
            nuevo.siguiente = inicio;
            inicio = nuevo;
            System.out.println("Elemento primo agregado en la posición 1: " + dato);
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
                System.out.println("Elemento primo agregado en la posición " + posicion + ": " + dato);
            }
        }
    }

    private boolean esPrimo(int numero) {
        if (numero <= 1) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) return false; 
        }
        return true;
    }

    public String encontrarMaximoYMinimo() {
        if (inicio == null) {	
            return "La lista esta vacia";
        }
    
        Nodo temp = inicio;
        int maximo = Integer.MIN_VALUE;
        int minimo = Integer.MAX_VALUE;
    
        while (temp != null) {
            int valor = Integer.parseInt(temp.dato);
            if (valor > maximo) maximo = valor;
            if (valor < minimo) minimo = valor;
            temp = temp.siguiente;
        }
        
    return "Máximo: " + maximo + "\nMínimo: " + minimo;
    }


    public void eliminarEnRango(int inicioRango, int finRango) {
        if (inicio == null) {
            System.out.println("La lista está vacía.");
            return;
        }
    
        if (inicioRango > finRango) {
            int temp = inicioRango;
            inicioRango = finRango;
            finRango = temp;
        }
    
        while (inicio != null && Integer.parseInt(inicio.dato) >= inicioRango && Integer.parseInt(inicio.dato) <= finRango) {
            System.out.println("Eliminando nodo con valor: " + inicio.dato);
            inicio = inicio.siguiente;
        }
    
        Nodo actual = inicio;
        while (actual != null && actual.siguiente != null) {
            if (Integer.parseInt(actual.siguiente.dato) >= inicioRango && Integer.parseInt(actual.siguiente.dato) <= finRango) {
                System.out.println("Eliminando nodo con valor: " + actual.siguiente.dato);
                actual.siguiente = actual.siguiente.siguiente;
            } else {
                actual = actual.siguiente;
            }
        }
    
        System.out.println("Todos los nodos en el rango [" + inicioRango + ", " + finRango + "] han sido eliminados.");
    }


}