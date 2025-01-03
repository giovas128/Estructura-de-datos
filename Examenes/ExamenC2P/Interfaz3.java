package ExamenC2P;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz3 extends JFrame implements ActionListener {
    Color colorFondo;
    JButton btnCrearLista, btnAgregar, btnMostrar, btnAgregarUltimo, btnAgregarPrimero, btnAgregarEspecial, btnAgregarMultiplos;
    JTextField inputValor, inputPosicion, valorField, inputContarValor;
    JTextArea areaLista, areaLista2, areaLista3;
    boolean listaCreada = false;
    Operaciones listaOperaciones;

    public Interfaz3() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 450);
        setLocationRelativeTo(null);
        JPanel ventana = new JPanel();
        colorFondo = new Color(72, 201, 176);
        ventana.setBackground(colorFondo);
        ventana.setLayout(null);
        listaOperaciones = new Operaciones();

        JLabel lblTitulo = new JLabel("ExamenC");
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

        btnAgregarMultiplos = new JButton("Agregar Multiplos");
        btnAgregarMultiplos.setBounds(50, 360, 140, 30);
        btnAgregarMultiplos.addActionListener(this);
        ventana.add(btnAgregarMultiplos);

        areaLista = new JTextArea();
        areaLista.setBounds(350, 80, 150, 280);
        areaLista.setEditable(false);
        ventana.add(areaLista);

        areaLista2 = new JTextArea();
        areaLista2.setBounds(550, 80, 150, 280);
        areaLista2.setEditable(false);
        ventana.add(areaLista2);

        areaLista3 = new JTextArea();
        areaLista3.setBounds(750, 80, 150, 280);
        areaLista3.setEditable(false);
        ventana.add(areaLista3);

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
                    int numero = Integer.parseInt(valor);
                    if (numero % 2 != 0) {
                        JOptionPane.showMessageDialog(this, "Error: No se puede agregar un número impar en una posición específica.");
                    } else {
                        listaOperaciones.agregarE(valor, posicion);
                        actualizarLista();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Error: Posición no válida o valor no numérico.");
                }
            } else if (e.getSource() == btnAgregarMultiplos) {
                String[] listasMultiplos = listaOperaciones.agregarM();
                areaLista2.setText(listasMultiplos[0]); 
                areaLista3.setText(listasMultiplos[1]); 
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
        SwingUtilities.invokeLater(Interfaz3::new);
    }
}
