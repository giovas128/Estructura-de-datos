package nodo;

public class Operaciones {
    private Lista listaPar = new Lista();  // Lista para letras en índices pares
    private Lista listaImpar = new Lista(); // Lista para letras en índices impares

    // Método para agregar cada letra a la lista correspondiente según su índice (par o impar)
    public void agregar(String palabra) {
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            if (i % 2 == 0) {  // Índices pares
                listaPar.agregarPalabra(Character.toString(letra));
            } else {  // Índices impares
                listaImpar.agregarPalabra(Character.toString(letra));
            }
        }
    }

    // Método para retornar ambas listas (letras en índices pares e impares) como un String
    public String mostrarAmbasListas() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Letras en índices pares:\n");
        resultado.append(listaPar.mostrarLista());
        
        resultado.append("\nLetras en índices impares:\n");
        resultado.append(listaImpar.mostrarLista());

        return resultado.toString();
    }

    // Método para separar palabras por múltiplos de un número dado
    public String[] separarPorMultiplo(int multiplo) {
        Lista listaMultiplo = new Lista();
        for (int i = 0; i < listaPar.getTamano(); i++) {
            if (i % multiplo == 0) {
                listaMultiplo.agregarPalabra(listaPar.obtenerPalabra(i));
            }
        }
        return listaMultiplo.toArray(); // Retorna las palabras como un array
    }
}
