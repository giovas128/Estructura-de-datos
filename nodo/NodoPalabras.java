package nodo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NodoPalabras extends JFrame implements ActionListener {
    private Operaciones op;
    private JTextField palabraField;
    private JTextArea listaArea, listaAreaMultiplo3, listaAreaMultiplo5, listaAreaMultiplo7;
    private JButton agregarButton, mostrarButton, separarButton, salirButton;
    
    public NodoPalabras() {
        op = new Operaciones();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);
        setLocationRelativeTo(null);
        JPanel ventana = new JPanel();
        ventana.setBackground(new Color(249, 253, 95));
        ventana.setLayout(null);

        JLabel titulo = new JLabel("PAR E IMPAR");
        titulo.setBounds(130, 20, 300, 50);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        ventana.add(titulo);

        JLabel lblPalabra = new JLabel("Ingrese palabra:");
        lblPalabra.setBounds(50, 80, 120, 20);
        ventana.add(lblPalabra);

        palabraField = new JTextField();
        palabraField.setBounds(50, 120, 150, 40);
        ventana.add(palabraField);

        agregarButton = new JButton("Agregar Palabra");
        agregarButton.setBounds(50, 180, 150, 40);
        agregarButton.addActionListener(this);
        ventana.add(agregarButton);

        mostrarButton = new JButton("Mostrar Listas");
        mostrarButton.setBounds(210, 180, 150, 40);
        mostrarButton.addActionListener(this);
        ventana.add(mostrarButton);

        salirButton = new JButton("Salir");
        salirButton.setBounds(210, 230, 150, 40);
        salirButton.addActionListener(this);
        ventana.add(salirButton);

        listaArea = new JTextArea();
        listaArea.setBounds(50, 280, 100, 300);
        listaArea.setEditable(false);
        JScrollPane scrollLista = new JScrollPane(listaArea);
        scrollLista.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollLista.setBounds(50, 280, 100, 300);
        ventana.add(scrollLista);

        add(ventana);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agregarButton) {
            String palabra = palabraField.getText().trim();
            if (!palabra.isEmpty()) {
                op.agregar(palabra);
                palabraField.setText("");
                JOptionPane.showMessageDialog(null, "Palabra agregada.");
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese una palabra.");
            }
        }

        if (e.getSource() == mostrarButton) {
            listaArea.setText(op.mostrarAmbasListas());
        }

        if (e.getSource() == separarButton) {
            listaAreaMultiplo3.setText("");
            listaAreaMultiplo5.setText("");
            listaAreaMultiplo7.setText("");
            
            String[] palabrasMultiplo3 = op.separarPorMultiplo(3);
            for (String palabra : palabrasMultiplo3) {
                listaAreaMultiplo3.append(palabra + "\n");
            }

            String[] palabrasMultiplo5 = op.separarPorMultiplo(5);
            for (String palabra : palabrasMultiplo5) {
                listaAreaMultiplo5.append(palabra + "\n");
            }

            String[] palabrasMultiplo7 = op.separarPorMultiplo(7);
            for (String palabra : palabrasMultiplo7) {
                listaAreaMultiplo7.append(palabra + "\n");
            }
        }

        if (e.getSource() == salirButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new NodoPalabras();
    }
}
