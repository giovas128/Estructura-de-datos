package ExamenD;

import EDC.ED;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interCola extends JFrame implements ActionListener{
	Color colorfra;
	JButton llenar, unirA, mostrar, separar;
	JTextField t, a;
	JTextArea aleatorio, aleatorio2, aleatorio3, aleatorio4;
	int[] pila;
    int[] pila2;
    int[] pila3;
    int[] pila4;
	int tope = 0;

	public interCola(){
		setTitle("interfaz de Examen D");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);
        setLocationRelativeTo(null);
        JPanel ventana = new JPanel();
        colorfra = new Color(249, 253, 95);
        ventana.setBackground(colorfra);

        JLabel vr = new JLabel("EXAMEN D");
        vr.setBounds(130, 20, 300, 50);
        vr.setFont(new Font("Arial", Font.BOLD, 20));
        ventana.add(vr);

        JLabel txtT = new JLabel("Tamaño de la pila: ");
        txtT.setBounds(50, 80, 110, 20);
        ventana.add(txtT);

        JLabel txtA = new JLabel("Agregar a la pila: ");
        txtA.setBounds(350, 80, 110, 20);
        ventana.add(txtA);

        JLabel txt1 = new JLabel("valores de la pila: ");
        txt1.setBounds(50, 250, 110, 20);
        txt1.setFont(new Font("Arial",Font.BOLD, 10));
        ventana.add(txt1);

        JLabel txt2 = new JLabel("multiplo de 3: ");
        txt2.setBounds(150, 250, 110, 20);
        txt2.setFont(new Font("Arial",Font.BOLD, 10));
        ventana.add(txt2);

        JLabel txt3 = new JLabel("multiplo de 5: ");
        txt3.setBounds(250, 250, 110, 20);
        txt3.setFont(new Font("Arial",Font.BOLD, 10));
        ventana.add(txt3);

        JLabel txt4 = new JLabel("multiplo de 7: ");
        txt4.setBounds(350, 250, 110, 20);
        txt4.setFont(new Font("Arial",Font.BOLD, 10));
        ventana.add(txt4);

        t = new JTextField();
        t.setBounds(50, 120, 80, 40);
        ventana.add(t);

        a = new JTextField();
        a.setBounds(350, 120, 80, 40);
        ventana.add(a);

        llenar = new JButton("LLENAR");
        llenar.setBounds(50, 180, 90, 40);
        llenar.addActionListener(this);
        ventana.add(llenar);

        unirA = new JButton("AGREGAR");
        unirA.setBounds(150, 180, 90, 40);
        unirA.addActionListener(this);
        ventana.add(unirA);

        mostrar = new JButton("MOSTRAR");
        mostrar.setBounds(250, 180, 90, 40);
        mostrar.addActionListener(this);
        ventana.add(mostrar);

        separar = new JButton("SEPARAR");
        separar.setBounds(350, 180, 90, 40);
        separar.addActionListener(this);
        ventana.add(separar);

        aleatorio = new JTextArea(10, 10);
        aleatorio.setBounds(50, 280, 90, 300);
        aleatorio.setEditable(false);

        JScrollPane barra = new JScrollPane(aleatorio);
        barra.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        barra.setBounds(50, 280, 90, 300);
        ventana.add(barra);

        aleatorio2 = new JTextArea(10, 10);
        aleatorio2.setBounds(150, 280, 90, 300);
        aleatorio2.setEditable(false);

        JScrollPane barra1 = new JScrollPane(aleatorio2);
        barra1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        barra1.setBounds(150, 280, 90, 300);
        ventana.add(barra1);

        aleatorio3 = new JTextArea(10, 10);
        aleatorio3.setBounds(250, 280, 90, 300);
        aleatorio3.setEditable(false);

        JScrollPane barra2 = new JScrollPane(aleatorio3);
        barra2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        barra2.setBounds(250, 280, 90, 300);
        ventana.add(barra2);

        aleatorio4 = new JTextArea(10, 10);
        aleatorio4.setBounds(350, 280, 90, 300);
        aleatorio4.setEditable(false);

        JScrollPane barra3 = new JScrollPane(aleatorio4);
        barra3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        barra3.setBounds(350, 280, 90, 300);
        ventana.add(barra3);

        ventana.setLayout(null);
        ventana.setSize(500, 600);
        add(ventana);
        setVisible(true);
        pila = null;
        pila2 = null;
        pila3 = null;
        pila4 = null;
        tope = 0;
	}

	public void actionPerformed(ActionEvent accion) {
        if (accion.getSource() == llenar) {
            try {
                int tamaño = Integer.parseInt(t.getText());
                pila = new int[tamaño];
                ED.llenar(pila, tamaño);
            } catch (NumberFormatException e) {
                aleatorio.setText("ERROR: Tamaño inválido");
            } catch (Exception e) {
                aleatorio.setText("Error: " + e.getMessage());
            }
        }
        if (accion.getSource() == unirA) {
            try {
                int valor = Integer.parseInt(a.getText()); 
                if (pila == null) {
                    aleatorio.setText("ERROR: La pila no ha sido inicializada.");
                } else if (tope >= pila.length) {
                    aleatorio.setText("ERROR: La pila está llena.");
                } else {
                    boolean existe = false;
                    for (int i = 0; i < tope; i++) {
                        if (pila[i] == valor) {
                            existe = true;
                            break;
                        }
                    }
                    if (!existe) {
                        pila[tope] = valor; 
                        tope++; 
                        aleatorio.append(valor + " agregado a la pila.\n");
                    } else {
                        aleatorio.setText("ERROR: El valor ya existe en la pila.");
                    }
                }
            } catch (NumberFormatException e) {
                aleatorio.setText("ERROR: Valor inválido");
            } catch (Exception e) {
                aleatorio.setText("Error: " + e.getMessage());
            }
        }        
        if (accion.getSource() == mostrar) {
            try {
                aleatorio.setText("");
                ED.mostrar(pila);
                for (int i = 0; i < pila.length; i++) {
                    aleatorio.append(pila[i] + "\n");
                }
            } catch (NumberFormatException e) {
                aleatorio.setText("ERROR: Tamaño inválido");
            } catch (Exception e) {
                aleatorio.setText("Error: " + e.getMessage());
            }
        }
        if (accion.getSource() == separar) {
            try {
                aleatorio2.setText("");
                pila2 = ED.separar3(pila);
                for (int i = 0; i < pila2.length; i++) {
                    aleatorio2.append(pila2[i] + "\n");
                }
            } catch (Exception e) {
                aleatorio2.setText("Error: " + e.getMessage());
            }
            try {
                aleatorio3.setText("");
                pila3 = ED.separar5(pila);
                for (int i = 0; i < pila3.length; i++) {
                    aleatorio3.append(pila3[i] + "\n");
                }
            } catch (Exception e) {
                aleatorio3.setText("Error: " + e.getMessage());
            }
            try {
                aleatorio4.setText("");
                pila4 = ED.separar7(pila);
                for (int i = 0; i < pila4.length; i++) {
                    aleatorio4.append(pila4[i] + "\n");
                }
            } catch (Exception e) {
                aleatorio4.setText("Error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new interCola();
    }
}