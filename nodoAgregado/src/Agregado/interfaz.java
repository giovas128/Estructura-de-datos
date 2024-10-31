package Agregado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interfaz extends JFrame implements ActionListener {
    Color colorFondo;
    JButton eliminarValorBtn, eliminarUltimoBtn, eliminarPrimeroBtn, btnCrearLista, btnAgregar, btnMostrar, btnAgregarUltimo, btnAgregarPrimero, btnAgregarEspecial;
    JTextField inputValor, inputPosicion, valorField;
    JTextArea areaLista;
    boolean listaCreada = false;
    Operaciones listaOperaciones;

    public interfaz() {
        setTitle("INTERFAZ AGREGADO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 450);
        setLocationRelativeTo(null);
        JPanel ventana = new JPanel();
        colorFondo = new Color(72, 201, 176);
        ventana.setBackground(colorFondo);
        ventana.setLayout(null);
        listaOperaciones = new Operaciones();

        JLabel lblTitulo = new JLabel("AGREGAR");
        lblTitulo.setBounds(150, 20, 300, 50);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        ventana.add(lblTitulo);

        btnCrearLista = new JButton("Crear Lista");
        btnCrearLista.setBounds(50, 80, 120, 30);
        btnCrearLista.addActionListener(this);
        ventana.add(btnCrearLista);

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
        btnAgregar.setBounds(50, 200, 140, 30);
        btnAgregar.addActionListener(this);
        ventana.add(btnAgregar);

        btnAgregarPrimero = new JButton("Agregar Primero");
        btnAgregarPrimero.setBounds(50, 240, 140, 30);
        btnAgregarPrimero.addActionListener(this);
        ventana.add(btnAgregarPrimero);

        btnAgregarUltimo = new JButton("Agregar Último");
        btnAgregarUltimo.setBounds(50, 280, 140, 30);
        btnAgregarUltimo.addActionListener(this);
        ventana.add(btnAgregarUltimo);

        btnAgregarEspecial = new JButton("Agregar Especial");
        btnAgregarEspecial.setBounds(50, 320, 140, 30);
        btnAgregarEspecial.addActionListener(this);
        ventana.add(btnAgregarEspecial);

        eliminarPrimeroBtn = new JButton("Eliminar Primero");
        eliminarPrimeroBtn.setBounds(200, 200, 140, 30);
        eliminarPrimeroBtn.addActionListener(this);
        ventana.add(eliminarPrimeroBtn);

        eliminarUltimoBtn = new JButton("Eliminar Último");
        eliminarUltimoBtn.setBounds(200, 240, 140, 30);
        eliminarUltimoBtn.addActionListener(this);
        ventana.add(eliminarUltimoBtn);

        JLabel lblEliminarValor = new JLabel("Valor a eliminar:");
        lblEliminarValor.setBounds(200, 280, 100, 30);
        ventana.add(lblEliminarValor);

        valorField = new JTextField();
        valorField.setBounds(300, 280, 100, 30);
        ventana.add(valorField);

        eliminarValorBtn = new JButton("Eliminar por Valor");
        eliminarValorBtn.setBounds(200, 320, 140, 30);
        eliminarValorBtn.addActionListener(this);
        ventana.add(eliminarValorBtn);

        areaLista = new JTextArea();
        areaLista.setBounds(450, 80, 150, 280);
        areaLista.setEditable(false);
        ventana.add(areaLista);

        add(ventana);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCrearLista) {
            listaCreada = true;
            listaOperaciones = new Operaciones(); 
            JOptionPane.showMessageDialog(this, "Lista creada.");
            actualizarLista();
        } else if (listaCreada) {
            String valor = inputValor.getText();

            if (e.getSource() == btnAgregar && !valor.isEmpty()) {
                listaOperaciones.agregar(valor);
                actualizarLista();
            } else if (e.getSource() == btnAgregarPrimero && !valor.isEmpty()) {
                listaOperaciones.agregarP(valor);
                actualizarLista();
            } else if (e.getSource() == btnAgregarUltimo && !valor.isEmpty()) {
                listaOperaciones.agregarU(valor);
                actualizarLista();
            } else if (e.getSource() == btnAgregarEspecial && !valor.isEmpty()) {
                try {
                    int posicion = Integer.parseInt(inputPosicion.getText());
                    listaOperaciones.agregarE(valor, posicion);
                    actualizarLista();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Error: Posición no válida.");
                }
            } else if (e.getSource() == eliminarPrimeroBtn) {
                listaOperaciones.eliminarPrimero();
                JOptionPane.showMessageDialog(this, "El primer elemento ha sido eliminado.");
                actualizarLista();
            } else if (e.getSource() == eliminarUltimoBtn) {
                listaOperaciones.eliminarUltimo();
                JOptionPane.showMessageDialog(this, "El último elemento ha sido eliminado.");
                actualizarLista();
            } else if (e.getSource() == eliminarValorBtn) {
                String eliminarValor = valorField.getText().trim();
                if (!eliminarValor.isEmpty()) {
                    listaOperaciones.eliminarPorValor(eliminarValor);
                    valorField.setText("");
                    JOptionPane.showMessageDialog(this, "El elemento " + eliminarValor + " ha sido eliminado.");
                    actualizarLista();
                } else {
                    JOptionPane.showMessageDialog(this, "Error: Ingresa un valor a eliminar.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error: Debes llenar el campo de valor.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error: Debes crear la lista primero.");
        }
    }

    private void actualizarLista() {
        StringBuilder contenido = new StringBuilder();
        Nodo temp = listaOperaciones.inicio;
        if (temp == null) {
            areaLista.setText("La lista está vacía.");
        } else {
            while (temp != null) {
                contenido.append(temp.dato).append("\n");
                temp = temp.siguiente;
            }
            areaLista.setText(contenido.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(interfaz::new);
    }
}
