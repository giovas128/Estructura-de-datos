package ValoresAleatorios;

import Pila.valores; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class valoresAle extends JFrame implements ActionListener {
    Color colorfra;
    JButton llenar, eliminar, mostrar;
    JTextField t;
    JTextArea aleatorio;
    String[] pila;

    public valoresAle() {
        setTitle("Pila");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 500);
        setLocationRelativeTo(null);
        JPanel ventana = new JPanel();
        colorfra = new Color(181, 233, 255);
        ventana.setBackground(colorfra);

        JLabel vr = new JLabel("VALORES RANDOM");
        vr.setBounds(130, 20, 300, 50);
        vr.setFont(new Font("Arial", Font.BOLD, 20));
        ventana.add(vr);

        JLabel txtT = new JLabel("Tamaño de la pila: ");
        txtT.setBounds(50, 80, 110, 20);
        ventana.add(txtT);

        t = new JTextField();
        t.setBounds(50, 120, 80, 40);
        ventana.add(t);

        llenar = new JButton("LLENAR");
        llenar.setBounds(50, 180, 100, 40);
        llenar.addActionListener(this);
        ventana.add(llenar);

        eliminar = new JButton("ELIMINAR");
        eliminar.setBounds(50, 230, 100, 40);
        eliminar.addActionListener(this);
        ventana.add(eliminar);

        mostrar = new JButton("MOSTRAR");
        mostrar.setBounds(50, 280, 100, 40);
        mostrar.addActionListener(this);
        ventana.add(mostrar);

        aleatorio = new JTextArea(10, 10);
        aleatorio.setBounds(200, 100, 150, 300);
        aleatorio.setEditable(false);

        JScrollPane barra = new JScrollPane(aleatorio);
        barra.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        barra.setBounds(200, 100, 150, 300);
        ventana.add(barra);

        ventana.setLayout(null);
        ventana.setSize(500, 600);
        add(ventana);
        setVisible(true);
        pila = null;
    }

    public void actionPerformed(ActionEvent accion) {
        if (accion.getSource() == llenar) {
            try {
                int tamaño = Integer.parseInt(t.getText());
                pila = new String[tamaño];
                valores.llenado(tamaño, pila);
            } catch (NumberFormatException e) {
                aleatorio.setText("ERROR: Tamaño inválido");
            } catch (Exception e) {
                aleatorio.setText("Error: " + e.getMessage());
            }
        }
        if (accion.getSource() == eliminar) {
            try {
                valores.eliminar();
            } catch (NumberFormatException e) {
                aleatorio.setText("ERROR: Tamaño inválido");
            } catch (Exception e) {
                aleatorio.setText("Error: " + e.getMessage());
            }
        }
        if (accion.getSource() == mostrar) {
            try {
                aleatorio.setText("");
                valores.mostrar(pila);
                for (int i = 0; i < pila.length; i++) {
                    aleatorio.append(pila[i] + "\n");
                }
            } catch (NumberFormatException e) {
                aleatorio.setText("ERROR: Tamaño inválido");
            } catch (Exception e) {
                aleatorio.setText("Error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new valoresAle();
    }
}
