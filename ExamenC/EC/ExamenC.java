package EC;

import javax.swing.*;
import java.util.Random;

public class ExamenC {
    private static char[] pila, pila2;
    private static int tope = 0, tope2 = 0, t = 0;

    public static void crearPila(int tamaño) {
        t = tamaño;
        pila = new char[t];
        pila2 = new char[t];
        tope = 0;
        tope2 = 0;
    }

    public static void agregarValor(String valorTexto) {
        if (tope >= t) {
            JOptionPane.showMessageDialog(null, "Error: la pila está llena.");
        } else if (valorTexto.length() != 1 || !Character.isLetter(valorTexto.charAt(0))) {
            JOptionPane.showMessageDialog(null, "Error: Solo se permite un carácter de letra.");
        } else {
            char letra = valorTexto.charAt(0);
            for (int i = 0; i < tope; i++) {
                if (pila[i] == letra) {
                    JOptionPane.showMessageDialog(null, "Error: El valor ya existe en la pila.");
                    return;
                }
            }
            pila[tope++] = letra;
        }
    }

    public static void eliminarValor() {
        if (tope == 0) {
            JOptionPane.showMessageDialog(null, "Error: la pila está vacía.");
        } else {
            pila2[tope2++] = pila[--tope];
        }
    }

    public static void llenarPilaAleatoriamente() {
        Random random = new Random();
        while (tope < t) {
            char letra = (char) (random.nextInt(26) + 'A');
            boolean existe = false;
            for (int i = 0; i < tope; i++) {
                if (pila[i] == letra) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                pila[tope++] = letra;
            }
        }
    }

    public static String getPilaComoTexto() {
        if (tope == 0) {
            return "La pila está vacía.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = tope - 1; i >= 0; i--) {
            sb.append("Posición ").append(i + 1).append(": ").append(pila[i]).append("\n");
        }
        return sb.toString();
    }

    public static String getEliminadosComoTexto() {
        if (tope2 == 0) {
            return "No hay valores eliminados.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = tope2 - 1; i >= 0; i--) {
            sb.append("Posición ").append(i + 1).append(": ").append(pila2[i]).append("\n");
        }
        return sb.toString();
    }
}
