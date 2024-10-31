package Listas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Listas.Operaciones;
import Listas.Nodo;


public class interfaz extends JFrame implements ActionListener {
    Color colorFondo;
    JButton btnCrearLista, btnAgregar, btnMostrar, btnEliminar;
    JTextField inputValor, inputPosicion, inputEliminar;
    JTextArea areaLista;
    DefaultListModel<String> modeloLista = new DefaultListModel<>();
    boolean listaCreada = false;
    Operaciones listaOperaciones; // Instancia de Operaciones para manejar la lista

    public interfaz() {
        // Configuración de la ventana
        setTitle("INTERFAZ AGREGAR");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 400);
        setLocationRelativeTo(null);
        JPanel ventana = new JPanel();
        colorFondo = new Color(72, 201, 176);
        ventana.setBackground(colorFondo);
        ventana.setLayout(null);

        // Inicializar lista de operaciones
        listaOperaciones = new Operaciones();

        JLabel lblTitulo = new JLabel("AGREGAR");
        lblTitulo.setBounds(150, 20, 300, 50);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        ventana.add(lblTitulo);

        // Botón para crear la lista
        btnCrearLista = new JButton("Crear Lista");
        btnCrearLista.setBounds(50, 80, 120, 30);
        btnCrearLista.addActionListener(this);
        ventana.add(btnCrearLista);

        // Campo y botón para agregar valores a la lista
        JLabel lblValor = new JLabel("Valor a agregar:");
        lblValor.setBounds(50, 120, 100, 30);
        ventana.add(lblValor);

        inputValor = new JTextField();
        inputValor.setBounds(150, 120, 100, 30);
        ventana.add(inputValor);

        JLabel lblPosicion = new JLabel("Posición:");
        lblPosicion.setBounds(50, 160, 100, 30);
        ventana.add(lblPosicion);

        inputPosicion = new JTextField();
        inputPosicion.setBounds(150, 160, 100, 30);
        ventana.add(inputPosicion);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(50, 200, 120, 30);
        btnAgregar.addActionListener(this);
        ventana.add(btnAgregar);

        areaLista = new JTextArea();
        areaLista.setBounds(300, 80, 90, 200);
        areaLista.setEditable(false);
        ventana.add(areaLista);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(50, 250, 120, 30);
        btnEliminar.addActionListener(this);
        ventana.add(btnEliminar);

        JLabel lbleliminar = new JLabel("Eliminar valor:");
        lbleliminar.setBounds(50, 300, 120, 30);
        ventana.add(lbleliminar);

        inputEliminar = new JTextField();
        inputEliminar.setBounds(150, 300, 100, 30);
        ventana.add(inputEliminar);

        add(ventana);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCrearLista) {
            listaCreada = true;
            JOptionPane.showMessageDialog(this, "Lista creada.");
        } else if (e.getSource() == btnAgregar) {
            if (!listaCreada) {
                JOptionPane.showMessageDialog(this, "Error: Debes crear la lista primero.");
            } else {
                String valor = inputValor.getText();
                String posicionStr = inputPosicion.getText();
                if (!valor.isEmpty()) {
                    try {
                        int posicion = posicionStr.isEmpty() ? modeloLista.getSize() : Integer.parseInt(posicionStr) - 1;
                        listaOperaciones.agregar(valor);
                        actualizarLista();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Error: Posición no válida.");
                    }
                }
            }
        } else if (e.getSource() == btnEliminar) {
            if (!listaCreada) {
                JOptionPane.showMessageDialog(this, "Error: Debes crear la lista primero.");
            } else {
                String valorAEliminar = inputEliminar.getText();
                listaOperaciones.eliminarEspecial(valorAEliminar);
                actualizarLista();
            }
        }
    }

    private void actualizarLista() {
        StringBuilder contenido = new StringBuilder();
        Nodo temp = listaOperaciones.inicio;
        while (temp != null) {
            contenido.append(temp.dato).append("\n");
            temp = temp.siguiente;
        }
        areaLista.setText(contenido.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(interfaz::new);
    }
}
