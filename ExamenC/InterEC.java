package ExamenC;

import EC.ExamenC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterEC extends JFrame implements ActionListener {
    private Color colorfra;
    private JButton btnAgregar, btnMostrar, btnEliminar, btnLlenar, btnMostrarEliminados, btnCrearPila;
    private JTextField inputTamaño, inputValor;
    private JTextArea pilaArea, eliminadosArea;
    private boolean pilaCreada = false;  // Verifica si la pila ha sido creada

    public InterEC() {
        // Configuración básica de la ventana
        setTitle("Interfaz Examen C");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);
        JPanel ventana = new JPanel();
        colorfra = new Color(189, 95, 253);
        ventana.setBackground(colorfra);
        ventana.setLayout(null);

        // Etiqueta y campo para el tamaño de la pila
        JLabel lblTamaño = new JLabel("Tamaño de la pila:");
        lblTamaño.setBounds(50, 50, 150, 30);
        ventana.add(lblTamaño);
        inputTamaño = new JTextField();
        inputTamaño.setBounds(200, 50, 100, 30);
        ventana.add(inputTamaño);

        // Botón para crear la pila
        btnCrearPila = new JButton("Crear Pila");
        btnCrearPila.setBounds(320, 50, 100, 30);
        btnCrearPila.addActionListener(this);
        ventana.add(btnCrearPila);

        // Etiqueta y campo para el valor a agregar
        JLabel lblValor = new JLabel("Valor a agregar:");
        lblValor.setBounds(50, 100, 150, 30);
        ventana.add(lblValor);
        inputValor = new JTextField();
        inputValor.setBounds(200, 100, 100, 30);
        ventana.add(inputValor);

        // Botones de acción
        btnAgregar = new JButton("Agregar valor");
        btnAgregar.setBounds(50, 150, 150, 30);
        btnAgregar.addActionListener(this);
        ventana.add(btnAgregar);

        btnMostrar = new JButton("Mostrar Pila");
        btnMostrar.setBounds(220, 150, 150, 30);
        btnMostrar.addActionListener(this);
        ventana.add(btnMostrar);

        btnEliminar = new JButton("Eliminar valor");
        btnEliminar.setBounds(50, 200, 150, 30);
        btnEliminar.addActionListener(this);
        ventana.add(btnEliminar);

        btnLlenar = new JButton("Llenar Aleatoriamente");
        btnLlenar.setBounds(220, 200, 150, 30);
        btnLlenar.addActionListener(this);
        ventana.add(btnLlenar);

        btnMostrarEliminados = new JButton("Mostrar Eliminados");
        btnMostrarEliminados.setBounds(50, 250, 150, 30);
        btnMostrarEliminados.addActionListener(this);
        ventana.add(btnMostrarEliminados);

        // Área para mostrar la pila
        pilaArea = new JTextArea();
        pilaArea.setBounds(50, 300, 150, 200);
        pilaArea.setEditable(false);
        pilaArea.setBorder(BorderFactory.createTitledBorder("Pila"));
        ventana.add(pilaArea);

        // Área para mostrar los valores eliminados
        eliminadosArea = new JTextArea();
        eliminadosArea.setBounds(220, 300, 150, 200);
        eliminadosArea.setEditable(false);
        eliminadosArea.setBorder(BorderFactory.createTitledBorder("Valores Eliminados"));
        ventana.add(eliminadosArea);

        // Añadir el panel a la ventana
        add(ventana);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCrearPila) {
            // Crear la pila con el tamaño indicado
            try {
                int tamaño = Integer.parseInt(inputTamaño.getText());
                ExamenC.crearPila(tamaño);
                pilaCreada = true;  // Indicar que la pila ha sido creada
                JOptionPane.showMessageDialog(this, "Pila creada con tamaño: " + tamaño);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: Ingresa un tamaño válido.");
            }
        } else if (e.getSource() == btnAgregar) {
            if (!pilaCreada) {
                JOptionPane.showMessageDialog(this, "Error: Debes crear la pila antes de agregar valores.");
            } else {
                ExamenC.agregarValor(inputValor.getText());  // Lógica separada en ExamenC
                actualizarPilaArea();
            }
        } else if (e.getSource() == btnMostrar) {
            actualizarPilaArea();
        } else if (e.getSource() == btnEliminar) {
            if (!pilaCreada) {
                JOptionPane.showMessageDialog(this, "Error: Debes crear la pila antes de eliminar valores.");
            } else {
                ExamenC.eliminarValor();  // Lógica separada en ExamenC
                actualizarPilaArea();
                actualizarEliminadosArea();
            }
        } else if (e.getSource() == btnLlenar) {
            if (!pilaCreada) {
                JOptionPane.showMessageDialog(this, "Error: Debes crear la pila antes de llenarla.");
            } else {
                ExamenC.llenarPilaAleatoriamente();  // Lógica separada en ExamenC
                actualizarPilaArea();
            }
        } else if (e.getSource() == btnMostrarEliminados) {
            actualizarEliminadosArea();
        }
    }

    private void actualizarPilaArea() {
        pilaArea.setText(ExamenC.getPilaComoTexto());  // Obtener datos de la pila desde ExamenC
    }

    private void actualizarEliminadosArea() {
        eliminadosArea.setText(ExamenC.getEliminadosComoTexto());  // Obtener datos de eliminados desde ExamenC
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InterEC::new);
    }
}
