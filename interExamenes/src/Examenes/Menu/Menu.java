package Examenes.Menu;

import ExamenA.interEA;
import ExamenB.interEB;
import ExamenC.InterEC;
import ExamenD.interCola;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;


public class Menu extends JFrame implements ActionListener {
    Color colorfra;
    JPanel panel;
    JButton ExamenA, ExamenB, ExamenC, ExamenD;
    public Menu(){
    	setTitle("Menu");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(270, 270);
        setLocationRelativeTo(null);
        JPanel ventana = new JPanel();
        colorfra = new Color(231, 149, 82);
        ventana.setBackground(colorfra);

        JLabel vr = new JLabel("MENU");
        vr.setBounds(100, 20, 300, 50);
        vr.setFont(new Font("Arial", Font.BOLD, 20));
        ventana.add(vr);

        ExamenA = new JButton("ExamenA");
        ExamenA.setBounds(10, 90, 100, 50);
        ExamenA.addActionListener(this);
        ExamenA.setFont(new Font("Arial", Font.BOLD, 13));
        ventana.add(ExamenA);

        ExamenB = new JButton("ExamenB");
        ExamenB.setBounds(10, 150, 100, 50);
        ExamenB.setFont(new Font("Arial", Font.BOLD, 13));
        ExamenB.addActionListener(this);
        ventana.add(ExamenB);

        ExamenC = new JButton("ExamenC");
        ExamenC.setBounds(140, 90, 100, 50);
        ExamenC.setFont(new Font("Arial", Font.BOLD, 13));
        ExamenC.addActionListener(this);
        ventana.add(ExamenC);

        ExamenD = new JButton("ExamenD");
        ExamenD.setBounds(140, 150, 100, 50);
        ExamenD.setFont(new Font("Arial", Font.BOLD, 13));
        ExamenD.addActionListener(this);
        ventana.add(ExamenD);

        ventana.setLayout(null);
        ventana.setSize(500, 600);
        add(ventana);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent accion){
    	if (accion.getSource() == ExamenA) {
    		this.setVisible(true);
    		new ExamenA.interEA().setVisible(true);
    	}
    	if (accion.getSource() == ExamenB) {
    		this.setVisible(true);
    		new ExamenB.interEB().setVisible(true);
    	}
    	if (accion.getSource() == ExamenC) {
    		this.setVisible(true);
    		new ExamenC.InterEC().setVisible(true);
    	}
    	if (accion.getSource() == ExamenD) {
    		this.setVisible(true);
    		new ExamenD.interCola().setVisible(true);
    	}
    }

    public static void main(String[] args) {
    	new Menu();
    }
}