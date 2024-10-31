package nodo1;

import nodo1.Operaciones;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NodoPalabras extends JFrame implements ActionListener {
    Operaciones operaciones;
    JTextField valorField;
    JTextArea listaArea;
    JButton agregarValorBtn, eliminarPrimeroBtn, eliminarUltimoBtn, eliminarValorBtn, mostrarAmbasBtn;

    public NodoPalabras() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(249, 253, 95));
        panel.setLayout(null);

        JLabel titulo = new JLabel("ELIMINAR");
        titulo.setBounds(120, 20, 300, 50);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titulo);

        JLabel valorLabel = new JLabel("valor:");
        valorLabel.setBounds(50, 80, 150, 20);
        panel.add(valorLabel);

        valorField = new JTextField();
        valorField.setBounds(200, 80, 150, 30);
        panel.add(valorField);

        agregarValorBtn = new JButton("Agregar valor");
        agregarValorBtn.setBounds(370, 80, 150, 30);
        agregarValorBtn.addActionListener(this);
        panel.add(agregarValorBtn);

        eliminarPrimeroBtn = new JButton("Eliminar Primero");
        eliminarPrimeroBtn.setBounds(50, 130, 150, 30);
        eliminarPrimeroBtn.addActionListener(this);
        panel.add(eliminarPrimeroBtn);

        eliminarUltimoBtn = new JButton("Eliminar Último");
        eliminarUltimoBtn.setBounds(220, 130, 150, 30);
        eliminarUltimoBtn.addActionListener(this);
        panel.add(eliminarUltimoBtn);

        eliminarValorBtn = new JButton("Eliminar valor");
        eliminarValorBtn.setBounds(50, 180, 150, 30);
        eliminarValorBtn.addActionListener(this);
        panel.add(eliminarValorBtn);


        listaArea = new JTextArea(10, 10);
        listaArea.setBounds(50, 230, 370, 300);
        listaArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(listaArea);
        scrollPane.setBounds(50, 230, 370, 300);
        panel.add(scrollPane);

        add(panel);
        operaciones = new Operaciones(); // Inicializamos las operaciones
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agregarValorBtn) {
            String palabra = valorField.getText().trim();
            if (!palabra.isEmpty()) {
                operaciones.agregar(palabra);
                valorField.setText("");
            } else {
                listaArea.append("Error: Ingrese un valor válida.\n");
            }
        } else if (e.getSource() == eliminarPrimeroBtn) {
            operaciones.eliminarPrimero();
            listaArea.append("El primer elemento ha sido eliminado.\n");
        } else if (e.getSource() == eliminarUltimoBtn) {
            operaciones.eliminarUltimo();
            listaArea.append("El último elemento ha sido eliminado.\n");
        } else if (e.getSource() == eliminarValorBtn) {
            String palabra = valorField.getText().trim();
            if (!palabra.isEmpty()) {
                operaciones.eliminarPorValor(palabra);
                
                valorField.setText("");
            } else {
                listaArea.append("Error: Ingrese un valor válida.\n");
            }
        } 
        // Mostrar el contenido actualizado después de cada acción
        mostrarLista();
    }

    public void mostrarLista() {
        String resultado = operaciones.mostrarAmbasListas();
        listaArea.append("Contenido de las listas:\n" + resultado);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NodoPalabras gui = new NodoPalabras();
            gui.setVisible(true);
        });
    }
}
