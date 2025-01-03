package EXAMEND2P;

import EXAMEND2P.Operaciones;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class Interfaz4 extends JFrame implements ActionListener {
	Operaciones operaciones;
	JTextArea areaLista, areaLista2, areaLista3;
	boolean listaCreada = false;
	JButton llenarB, agregarMultiplosB, eliminarImparesB;
	Operaciones listaOperaciones;


    public Interfaz4(){
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 450);
        setLocationRelativeTo(null);
        JPanel ventana = new JPanel();
        ventana.setLayout(null);
        ventana.setBounds(0, 0, 850, 450);
    
        listaOperaciones = new Operaciones();

        JLabel titulo = new JLabel("EXAMEN D");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(480, 20, 200, 30);
        ventana.add(titulo);
    
        llenarB = new JButton("LLENAR");
        llenarB.setBounds(50,50,150,30);
        llenarB.addActionListener(this);
        ventana.add(llenarB);
    
        agregarMultiplosB = new JButton("MULTIPLOS");
        agregarMultiplosB.setBounds(50,100,150,30);
        agregarMultiplosB.addActionListener(this);
        ventana.add(agregarMultiplosB);
    
        eliminarImparesB = new JButton("ELIMINAR IMPARES");
        eliminarImparesB.setBounds(50,150,150,30);
        eliminarImparesB.addActionListener(this);
        ventana.add(eliminarImparesB);
    
        areaLista = new JTextArea();
        areaLista.setBounds(250,80,150,280);
        areaLista.setEditable(false);
        ventana.add(areaLista);

        areaLista2 = new JTextArea();
        areaLista2.setBounds(450,80,150,280);
        areaLista2.setEditable(false);
        ventana.add(areaLista2);

        areaLista3 = new JTextArea();
        areaLista3.setBounds(650,80,150,280);
        areaLista3.setEditable(false);
        ventana.add(areaLista3);
    
        add(ventana);
        setVisible(true);
    }

    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == llenarB) {
        String lista = listaOperaciones.llenar();
        areaLista.setText(lista); // Mostrar la lista principal
    } else if (e.getSource() == agregarMultiplosB) {
        String[] listasMultiplos = listaOperaciones.agregarM();
        areaLista2.setText(listasMultiplos[0]); // Múltiplos de 3
        areaLista3.setText(listasMultiplos[1]); // Múltiplos de 5
    } else if (e.getSource() == eliminarImparesB) {
        String lista = listaOperaciones.eliminarI();
        areaLista.setText(lista); // Actualizar la lista principal
    }
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Interfaz4::new);
    }
}