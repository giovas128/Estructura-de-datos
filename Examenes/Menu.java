package Examenes;

import ExamenA2.Interfaz;
import Agregado.interfaz;
import ExamenC2P.Interfaz3;
import EXAMEND2P.Interfaz4;
import ExamenE2P.Interfaz5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener{

	JButton examenA, examenB, examenC, examenD, examenE;
	Color colorFondo;


	public Menu(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(270, 320);
        setLocationRelativeTo(null);
        JPanel ventana = new JPanel();
        colorFondo = new Color(72, 201, 176);
        ventana.setBackground(colorFondo);
        ventana.setLayout(null);

        JLabel lblTitulo = new JLabel("Examenes");
        lblTitulo.setBounds(80, 20, 300, 50);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        ventana.add(lblTitulo);

        examenA = new JButton("ExamenA");
        examenA.setBounds(10, 90, 100, 50);
        examenA.addActionListener(this);
        examenA.setFont(new Font("Arial", Font.BOLD, 13));
        ventana.add(examenA);

        examenB = new JButton("ExamenB");
        examenB.setBounds(10, 150, 100, 50);
        examenB.setFont(new Font("Arial", Font.BOLD, 13));
        examenB.addActionListener(this);
        ventana.add(examenB);

        examenC = new JButton("ExamenC");
        examenC.setBounds(140, 90, 100, 50);
        examenC.setFont(new Font("Arial", Font.BOLD, 13));
        examenC.addActionListener(this);
        ventana.add(examenC);

        examenD = new JButton("ExamenD");
        examenD.setBounds(140, 150, 100, 50);
        examenD.setFont(new Font("Arial", Font.BOLD, 13));
        examenD.addActionListener(this);
        ventana.add(examenD);

        examenE = new JButton("ExamenE");
        examenE.setBounds(10, 210, 100, 50);
        examenE.setFont(new Font("Arial", Font.BOLD, 13));
        examenE.addActionListener(this);
        ventana.add(examenE);

        add(ventana);
        setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == examenA) {
			this.setVisible(true);
            new ExamenA2.Interfaz().setVisible(true);
		} else if (e.getSource() == examenB) {
			this.setVisible(true);
			new Agregado.interfaz().setVisible(true);
		} else if (e.getSource() == examenC) {
			this.setVisible(true);
            new ExamenC2P.Interfaz3().setVisible(true);
		} else if (e.getSource() == examenD) {
			this.setVisible(true);
            new EXAMEND2P.Interfaz4().setVisible(true);
		} else if (e.getSource() == examenE) {
			this.setVisible(true);
            new ExamenE2P.Interfaz5().setVisible(true);
		}
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(Menu::new);
	}
}