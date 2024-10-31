package cola;

public class Cola {
    public int[] cola;
    public int frente;
    public int finalCola;
    public int capacidad;

    public Cola(int capacidad) {
        this.capacidad = capacidad;
        cola = new int[capacidad];
        frente = -1; 
        finalCola = -1;
    }

    public boolean estaVacia() {
        return (frente == -1);
    }

    public boolean estaLlena() {
        return (finalCola == capacidad - 1);
    }

    public void agregar(int numero) {
        if (estaLlena()) {
            System.out.println("La cola está llena.");
        } else {
            if (estaVacia()) {
                frente = 0; 
            }
            finalCola++;
            cola[finalCola] = numero;
            System.out.println(numero + " agregado a la cola.");
        }
    }

    public int eliminarPrimerValor() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return -1;
        } else {
            int valorEliminado = cola[frente];
            System.out.println(valorEliminado + " eliminado del frente de la cola.");
            
            if (frente == finalCola) {
                frente = -1;
                finalCola = -1;
            } else {
                frente++;
            }
            return valorEliminado;
        }
    }

    public int eliminarUltimoValor() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return -1;
        } else {
            int valorEliminado = cola[finalCola];
            System.out.println(valorEliminado + " eliminado del final de la cola.");

            if (frente == finalCola) {
                frente = -1;
                finalCola = -1;
            } else {
                finalCola--;
            }
            return valorEliminado;
        }
    }

    public boolean eliminarValor(int numero) {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return false;
        } else {
            boolean encontrado = false;
            for (int i = frente; i <= finalCola; i++) {
                if (cola[i] == numero) {
                    encontrado = true;

                    for (int j = i; j < finalCola; j++) {
                        cola[j] = cola[j + 1];
                    }
                    finalCola--; 
                    System.out.println("Número " + numero + " eliminado.");
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Número " + numero + " no se encontró en la cola.");
            }
            return encontrado;
        }
    }

    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
        } else {
            System.out.print("Cola: ");
            for (int i = frente; i <= finalCola; i++) {
                System.out.print(cola[i] + " ");
            }
            System.out.println();
        }
    }
}
