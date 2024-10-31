package app;

import cola.Cola;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCola extends JFrame implements ActionListener {
    Cola cola;
    JTextField tamanoField, valorField;
    JTextArea colaArea;
    JButton crearColaBtn, agregarValorBtn, eliminarPrimeroBtn, eliminarUltimoBtn, eliminarValorBtn;

    public InterfazCola() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(249, 253, 95));
        panel.setLayout(null);

        JLabel titulo = new JLabel("ELIMINADOS");
        titulo.setBounds(150, 20, 300, 50);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titulo);

        JLabel tamanoLabel = new JLabel("Tamaño de la cola:");
        tamanoLabel.setBounds(50, 80, 150, 20);
        panel.add(tamanoLabel);

        tamanoField = new JTextField();
        tamanoField.setBounds(200, 80, 80, 30);
        panel.add(tamanoField);

        crearColaBtn = new JButton("Crear Cola");
        crearColaBtn.setBounds(300, 80, 120, 30);
        crearColaBtn.addActionListener(this);
        panel.add(crearColaBtn);

        JLabel valorLabel = new JLabel("Valor:");
        valorLabel.setBounds(50, 130, 150, 20);
        panel.add(valorLabel);

        valorField = new JTextField();
        valorField.setBounds(200, 130, 80, 30);
        panel.add(valorField);

        agregarValorBtn = new JButton("Agregar Valor");
        agregarValorBtn.setBounds(300, 130, 120, 30);
        agregarValorBtn.addActionListener(this);
        panel.add(agregarValorBtn);

        eliminarPrimeroBtn = new JButton("Eliminar Primero");
        eliminarPrimeroBtn.setBounds(50, 180, 150, 30);
        eliminarPrimeroBtn.addActionListener(this);
        panel.add(eliminarPrimeroBtn);

        eliminarUltimoBtn = new JButton("Eliminar Último");
        eliminarUltimoBtn.setBounds(220, 180, 150, 30);
        eliminarUltimoBtn.addActionListener(this);
        panel.add(eliminarUltimoBtn);

        eliminarValorBtn = new JButton("Eliminar Valor");
        eliminarValorBtn.setBounds(50, 230, 150, 30);
        eliminarValorBtn.addActionListener(this);
        panel.add(eliminarValorBtn);

        colaArea = new JTextArea(10, 10);
        colaArea.setBounds(50, 280, 370, 200);
        colaArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(colaArea);
        scrollPane.setBounds(50, 280, 370, 200);
        panel.add(scrollPane);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == crearColaBtn) {
            try {
                int tamaño = Integer.parseInt(tamanoField.getText());
                cola = new Cola(tamaño);
                colaArea.setText("Cola creada con tamaño " + tamaño + ".\n");
            } catch (NumberFormatException ex) {
                colaArea.setText("Error: Ingrese un tamaño válido.\n");
            }
        } else if (cola == null) {
            colaArea.setText("Error: Primero cree una cola antes de realizar esta operación.\n");
        } else if (e.getSource() == agregarValorBtn) {
            try {
                int valor = Integer.parseInt(valorField.getText());
                cola.agregar(valor);
                colaArea.setText("Valor " + valor + " agregado a la cola.\n");
                mostrarCola();
            } catch (NumberFormatException ex) {
                colaArea.setText("Error: Ingrese un valor válido.\n");
            }
        } else if (e.getSource() == eliminarPrimeroBtn) {
            cola.eliminarPrimerValor();
            colaArea.setText("El primer valor ha sido eliminado.\n");
            mostrarCola();
        } else if (e.getSource() == eliminarUltimoBtn) {
            cola.eliminarUltimoValor();
            colaArea.setText("El último valor ha sido eliminado.\n");
            mostrarCola();
        } else if (e.getSource() == eliminarValorBtn) {
            try {
                int valor = Integer.parseInt(valorField.getText());
                cola.eliminarValor(valor);
                colaArea.setText("El valor " + valor + " ha sido eliminado de la cola.\n");
                mostrarCola();
            } catch (NumberFormatException ex) {
                colaArea.setText("Error: Ingrese un valor válido.\n");
            }
        }
    }

    public void mostrarCola() {
        if (cola.estaVacia()) {
            colaArea.append("La cola está vacía.\n");
        } else {
            StringBuilder colaStr = new StringBuilder("Cola: ");
            for (int i = cola.frente; i <= cola.finalCola; i++) {
                colaStr.append(cola.cola[i]).append(" ");
            }
            colaStr.append("\n");
            colaArea.append(colaStr.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfazCola gui = new InterfazCola();
            gui.setVisible(true);
        });
    }
}
