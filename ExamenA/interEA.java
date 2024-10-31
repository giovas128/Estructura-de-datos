package ExamenA;

import EA.ExamenA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interEA extends JFrame implements ActionListener{
	Color colorfra;
	JButton llenar, unirA, mostrar, sumar;
	JTextField t, a;
	JTextArea aleatorio, aleatorio2, aleatorio3, aleatorio4;
	char[] pila;
    char[] pila2;
    char[] pila3;
    char[] pila4;
	int tope = 0;

	public interEA(){
		setTitle("interfaz de examenA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);
        setLocationRelativeTo(null);
        JPanel ventana = new JPanel();
        colorfra = new Color(231, 149, 82);
        ventana.setBackground(colorfra);

        JLabel vr = new JLabel("EXAMEN A");
        vr.setBounds(130, 20, 300, 50);
        vr.setFont(new Font("Arial", Font.BOLD, 20));
        ventana.add(vr);

        JLabel txtT = new JLabel("Tamaño de la pila: ");
        txtT.setBounds(50, 80, 110, 20);
        ventana.add(txtT);

        JLabel txt2 = new JLabel("Unir A:");
        txt2.setBounds(150, 250, 110, 20);
        txt2.setFont(new Font("Arial",Font.BOLD, 10));
        ventana.add(txt2);

        JLabel txt3 = new JLabel("Mostrar:");
        txt3.setBounds(250, 250, 110, 20);
        txt3.setFont(new Font("Arial",Font.BOLD, 10));
        ventana.add(txt3);

        JLabel txt4 = new JLabel("Sumar: ");
        txt4.setBounds(350, 250, 110, 20);
        txt4.setFont(new Font("Arial",Font.BOLD, 10));
        ventana.add(txt4);

        t = new JTextField();
        t.setBounds(50, 120, 80, 40);
        ventana.add(t);

        llenar = new JButton("LLENAR");
        llenar.setBounds(50, 180, 90, 40);
        llenar.addActionListener(this);
        ventana.add(llenar);

        unirA = new JButton("UNIRA");
        unirA.setBounds(150, 180, 90, 40);
        unirA.addActionListener(this);
        ventana.add(unirA);

        mostrar = new JButton("MOSTRAR");
        mostrar.setBounds(250, 180, 90, 40);
        mostrar.addActionListener(this);
        ventana.add(mostrar);

        sumar = new JButton("SUMAR");
        sumar.setBounds(350, 180, 90, 40);
        sumar.addActionListener(this);
        ventana.add(sumar);

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
        
            int tamaño = Integer.parseInt(t.getText());
            if (tamaño <= 0) {
                aleatorio.setText("ERROR: El tamaño debe ser un número positivo.");
                return;
            }
            pila = new char[tamaño];
            pila2 = new char[tamaño];
            pila3 = new char[tamaño];

            // Crear un SwingWorker para realizar el llenado en segundo plano
            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    // Ejecutar el método llenar de ExamenA en un hilo separado
                    ExamenA.llenar(pila, pila2, pila3, tamaño);
                    return null;
                }
            };

            // Iniciar el proceso en segundo plano
            worker.execute();

        
    }

    if (accion.getSource() == unirA) {
        try {
            if (pila == null || pila2 == null || pila3 == null) {
                aleatorio.setText("ERROR: Primero llena las pilas.");
                return;
            }

            aleatorio2.setText(""); // Limpiar el área de texto antes de mostrar los valores
            
            // Unir las pilas usando el método de ExamenA
            ExamenA.unir(pila, pila2, pila3);
            
            // Mostrar los valores de las pilas de manera organizada
            aleatorio2.append("Pila 1:\n");
            for (char c : pila) {
                aleatorio2.append(c + "\n");
            }
            
            aleatorio2.append("\nPila 2:\n");
            for (char c : pila2) {
                aleatorio2.append(c + "\n");
            }

            aleatorio2.append("\nPila 3 (Unida):\n");
            for (char c : pila3) {
                aleatorio2.append(c + "\n");
            }
            
        } catch (Exception e) {
            aleatorio.setText("Error: " + e.getMessage());
        }
    }

    if (accion.getSource() == mostrar) {
        try {
            if (pila == null || pila2 == null || pila3 == null) {
                aleatorio.setText("ERROR: Primero llena las pilas.");
                return;
            }

            aleatorio3.setText(""); // Limpiar el área de texto antes de mostrar los valores
            
            // Mostrar el contenido de las pilas con etiquetas
            aleatorio3.append("Contenido de la pila 1:\n");
            for (char c : pila) {
                aleatorio3.append(c + "\n");
            }

            aleatorio3.append("\nContenido de la pila 2:\n");
            for (char c : pila2) {
                aleatorio3.append(c + "\n");
            }

            aleatorio3.append("\nContenido de la pila 3:\n");
            for (char c : pila3) {
                aleatorio3.append(c + "\n");
            }
        } catch (NumberFormatException e) {
            aleatorio3.setText("ERROR: Tamaño inválido");
        } catch (Exception e) {
            aleatorio3.setText("Error: " + e.getMessage());
        }
    }

    if (accion.getSource() == sumar) {
    try {
        if (pila == null || pila2 == null || pila3 == null) {
            aleatorio4.setText("ERROR: Primero llena las pilas.");
            return;
        }

        // Llamamos al método sumar de ExamenA
        String[] resultado = ExamenA.sumar(pila, pila2, pila3);

        // Mostramos el resultado en aleatorio4
        aleatorio4.setText(""); // Limpiamos el área de texto antes de mostrar los resultados
        aleatorio4.append("Contenido de la suma de las pilas:\n");
        for (String linea : resultado) {
            aleatorio4.append(linea + "\n");
        }

    } catch (Exception e) {
        aleatorio4.setText("Error: " + e.getMessage());
    }
}


}


    public static void main(String[] args) {
        new interEA();
    }
}