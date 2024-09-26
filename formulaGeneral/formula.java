
package formulaGeneral;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;




public class formula extends JFrame implements ActionListener {
    static int valor = 0;
    Color colorfra;
    JButton calcular;
    JTextField a, b, c;
    JLabel resultadoLabel, resultadoLabel1;

    public formula() {
        setTitle("FORMULA GENERAL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLocationRelativeTo(null);
        JPanel ventana = new JPanel();
        colorfra = new Color(109, 249, 145);
        ventana.setBackground(colorfra);
        
        JLabel fg = new JLabel("FORMULA GENERAL");
        fg.setBounds(90, 20, 300, 50);
        fg.setFont(new Font("Arial", Font.BOLD, 20));
        ventana.add(fg);
        
        JLabel txta = new JLabel("Valor de A:");
        txta.setBounds(50, 80, 110, 20);
        ventana.add(txta);
        
        a = new JTextField();
        a.setBounds(50, 120, 80, 40);
        ventana.add(a);
        
        JLabel txtb = new JLabel("Valor de B:");
        txtb.setBounds(150, 80, 110, 20);
        ventana.add(txtb);
        
        b = new JTextField();
        b.setBounds(150, 120, 80, 40);
        ventana.add(b);
        
        JLabel txtc = new JLabel("Valor de C:");
        txtc.setBounds(250, 80, 110, 20);
        ventana.add(txtc);
        
        c = new JTextField();
        c.setBounds(250, 120, 80, 40);
        ventana.add(c);
        
        calcular = new JButton("calcular");
        calcular.setBounds(50, 200, 100, 50);
        calcular.addActionListener(this);
        ventana.add(calcular);
        
        resultadoLabel = new JLabel("");
        resultadoLabel.setBounds(200, 180, 350, 50);
        resultadoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        ventana.add(resultadoLabel);

        resultadoLabel1 = new JLabel("");
        resultadoLabel1.setBounds(200, 200, 350, 50);
        resultadoLabel1.setFont(new Font("Arial", Font.PLAIN, 16));
        ventana.add(resultadoLabel1);
        
        ventana.setLayout(null);
        ventana.setSize(500, 600);
        add(ventana);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent accion) {
        if (accion.getSource() == calcular) {
            try {
                int valA = Integer.parseInt(a.getText());
                int valB = Integer.parseInt(b.getText());
                int valC = Integer.parseInt(c.getText());

                double[] resultados = Resultado.f(valA, valB, valC);
                resultadoLabel.setText("valor de x1:  " + resultados[0]);
                resultadoLabel1.setText("valor de x2:  " + resultados[1]);
            } catch (NumberFormatException e) {
                resultadoLabel.setText("ERROR");
                resultadoLabel1.setText("ERROR");
            } catch (Exception e) {
                resultadoLabel.setText("Error: " + e.getMessage());
                resultadoLabel1.setText("Error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new formula();
    }
}
