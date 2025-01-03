package ExamenE2P;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz5 extends JFrame implements ActionListener {
    Color colorFondo;
    JButton btnCrearLista, btnAgregar, btnMostrar, btnAgregarUltimo, btnAgregarPrimero, btnAgregarEspecial, btnEncontrarMym, btnEliminarRango;
    JTextField inputValor, inputPosicion, valorField, inputRangoInicio, inputRangoFin;
    JTextArea areaLista, areaLista2, areaLista3;
    boolean listaCreada = false;
    Operaciones listaOperaciones;


    public Interfaz5() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 500);
        setLocationRelativeTo(null);
        JPanel ventana = new JPanel();
        colorFondo = new Color(72, 201, 176);
        ventana.setBackground(colorFondo);
        ventana.setLayout(null);
        listaOperaciones = new Operaciones();

        JLabel lblTitulo = new JLabel("Examen E");
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

        btnEncontrarMym = new JButton("Encontrar max y min");
        btnEncontrarMym.setBounds(50, 360, 140, 30);
        btnEncontrarMym.addActionListener(this);
        ventana.add(btnEncontrarMym);

        btnEliminarRango = new JButton("Eliminar Rango");
        btnEliminarRango.setBounds(50, 400, 140, 30);
        btnEliminarRango.addActionListener(this);
        ventana.add(btnEliminarRango);

        JLabel lblRangoInicio = new JLabel("Inicio del rango:");
        lblRangoInicio.setBounds(200, 360, 120, 30);
        ventana.add(lblRangoInicio);

        inputRangoInicio = new JTextField();
        inputRangoInicio.setBounds(330, 360, 100, 30);
        ventana.add(inputRangoInicio);

        JLabel lblRangoFin = new JLabel("Fin del rango:");
        lblRangoFin.setBounds(200, 400, 120, 30);
        ventana.add(lblRangoFin);

        inputRangoFin = new JTextField();
        inputRangoFin.setBounds(330, 400, 100, 30);
        ventana.add(inputRangoFin);

        areaLista = new JTextArea();
        areaLista.setBounds(350, 60, 150, 280);
        areaLista.setEditable(false);
        ventana.add(areaLista);

        areaLista2 = new JTextArea();
        areaLista2.setBounds(550, 60, 150, 280);
        areaLista2.setEditable(false);
        ventana.add(areaLista2);

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
                    listaOperaciones.agregarE(valor, posicion);
                    actualizarLista();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Error: Posición no válida o valor no numérico.");
                }
            } else if (e.getSource() == btnEncontrarMym) {
                String encontrar = listaOperaciones.encontrarMaximoYMinimo();
                areaLista2.setText(encontrar);
            } else if (e.getSource() == btnEliminarRango) {
                try {
                    int inicioRango = Integer.parseInt(inputRangoInicio.getText());
                    int finRango = Integer.parseInt(inputRangoFin.getText());
                    listaOperaciones.eliminarEnRango(inicioRango, finRango);
                    actualizarLista();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Error: Los valores del rango deben ser numéricos.");
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
        SwingUtilities.invokeLater(Interfaz5::new);
    }
}
