package ExamenA2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame implements ActionListener {
    private JButton btnLlenar, btnSumar;
    private JTextArea areaListaA, areaListaB, areaListaC, areaUnionB;
    private Operaciones operaciones;

    public Interfaz() {
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 500, 600);


        JLabel titulo = new JLabel("EXAMEN A");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(150, 20, 200, 30);
        panel.add(titulo);

        btnLlenar = new JButton("Llenar");
        btnLlenar.setBounds(50, 80, 150, 30);
        btnLlenar.addActionListener(this);
        panel.add(btnLlenar);

        btnSumar = new JButton("Sumar");
        btnSumar.setBounds(220, 80, 150, 30);
        btnSumar.addActionListener(this);
        panel.add(btnSumar);
        
        areaListaA = new JTextArea();
        areaListaA.setEditable(false);

        JScrollPane scrollA = new JScrollPane(areaListaA);
        scrollA.setBounds(50, 130, 150, 150);
        panel.add(scrollA);

        areaListaB = new JTextArea();
        areaListaB.setEditable(false);

        JScrollPane scrollB = new JScrollPane(areaListaB);
        scrollB.setBounds(220, 130, 150, 150);
        panel.add(scrollB);

        areaListaC = new JTextArea();
        areaListaC.setEditable(false);

        JScrollPane scrollC = new JScrollPane(areaListaC);
        scrollC.setBounds(50, 300, 150, 150);
        panel.add(scrollC);

        areaUnionB = new JTextArea();
        areaUnionB.setEditable(false);

        JScrollPane scrollUnion = new JScrollPane(areaUnionB);
        scrollUnion.setBounds(220, 300, 150, 150);
        panel.add(scrollUnion);

        add(panel);
        operaciones = new Operaciones();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLlenar) {
            operaciones.llenar();
            mostrarListas();
        } else if (e.getSource() == btnSumar) {
            operaciones.sumar();
            mostrarUnionB();

        }
    }

    private void mostrarListas() {
        areaListaA.setText(obtenerContenidoLista(operaciones.listaA));
        areaListaB.setText(obtenerContenidoLista(operaciones.listaB));
        areaListaC.setText(obtenerContenidoLista(operaciones.listaC));
    }

    private void mostrarUnionB() {
        areaUnionB.setText(obtenerContenidoLista(operaciones.UnionB));
    }

    private String obtenerContenidoLista(Nodo cabeza) {
        StringBuilder sb = new StringBuilder();
        Nodo actual = cabeza;
        while (actual != null) {
            sb.append((char) actual.dato).append(" ");
            actual = actual.sig;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Interfaz gui = new Interfaz();
            gui.setVisible(true);
        });
    }
}
