package valoresOrdenados;

import ordenamiento.FIFO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inter extends JFrame implements ActionListener{
	Color colorfra;
    JButton llenar, eliminar, mostrar, ordenar, agregar;
    JTextField t;
    JTextArea aleatorio;
    String[] pila;

    public inter(){
    	setTitle("Valores ordenados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 500);
        setLocationRelativeTo(null);
        JPanel ventana = new JPanel();
        colorfra = new Color(217,136,128);
        ventana.setBackground(colorfra);

        JLabel vr = new JLabel("VALORES ORDENADOS");
        vr.setBounds(130, 20, 300, 50);
        vr.setFont(new Font("Arial", Font.BOLD, 20));
        ventana.add(vr);

        JLabel txtT = new JLabel("Tamaño de la pila: ");
        txtT.setBounds(50, 80, 110, 20);
        ventana.add(txtT);

        t = new JTextField();
        t.setBounds(50, 120, 80, 40);
        ventana.add(t);

        aleatorio = new JTextArea(10, 10);
        aleatorio.setBounds(200, 100, 300, 300);
        aleatorio.setEditable(false);

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

        ordenar = new JButton("ORDENAR");
        ordenar.setBounds(50,330,100,40);
        ordenar.addActionListener(this);
        ventana.add(ordenar);

        agregar = new JButton("AGREGAR");
        agregar.setBounds(50,380,100,40);
        agregar.addActionListener(this);
        ventana.add(agregar);


        JScrollPane barra = new JScrollPane(aleatorio);
        barra.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        barra.setBounds(200, 100, 300, 300);
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
                FIFO.llenar(pila, tamaño);
            } catch (NumberFormatException e) {
                aleatorio.setText("ERROR: Tamaño inválido");
            } catch (Exception e) {
                aleatorio.setText("Error: " + e.getMessage());
            }
        }
        if (accion.getSource() == eliminar) {
            try {
                FIFO.eliminar();
            } catch (NumberFormatException e) {
                aleatorio.setText("ERROR: Tamaño inválido");
            } catch (Exception e) {
                aleatorio.setText("Error: " + e.getMessage());
            }
        }
        if (accion.getSource() == mostrar) {
            try {
                aleatorio.setText("");
                FIFO.mostrar(pila);
                for (int i = 0; i < pila.length; i++) {
                    aleatorio.append(pila[i] + "\n");
                }
            } catch (NumberFormatException e) {
                aleatorio.setText("ERROR: Tamaño inválido");
            } catch (Exception e) {
                aleatorio.setText("Error: " + e.getMessage());
            }
        }
        if (accion.getSource() == ordenar) {
            try {
                aleatorio.setText("");
                FIFO.ordenar(pila);
            } catch (NumberFormatException e) {
                aleatorio.setText("ERROR: Tamaño inválido");
            } catch (Exception e) {
                aleatorio.setText("Error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new inter();
    }
}