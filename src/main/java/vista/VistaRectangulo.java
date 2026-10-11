/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorRectangulo;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VistaRectangulo extends JFrame implements ActionListener {
    private ControladorRectangulo controlador;

    private JTextField txtX1 = new JTextField("0");
    private JTextField txtY1 = new JTextField("0");
    private JTextField txtX2 = new JTextField("4");
    private JTextField txtY2 = new JTextField("3");
    private JTextField txtDx = new JTextField("1");
    private JTextField txtDy = new JTextField("1");
    private JTextField txtFactor = new JTextField("2");
    private JTextField txtPx = new JTextField("1");
    private JTextField txtPy = new JTextField("1");

    private JButton btnCrear = new JButton("Crear rectángulo");
    private JButton btnArea = new JButton("Calcular área");
    private JButton btnMover = new JButton("Mover");
    private JButton btnEscalar = new JButton("Escalar");
    private JButton btnPunto = new JButton("¿Punto dentro?");

    private JTextArea areaSalida = new JTextArea(8, 30);

    public VistaRectangulo(ControladorRectangulo controlador) {
        this.controlador = controlador;
        setTitle("Gestor de Figuras - Rectángulo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        JPanel panelCampos = new JPanel(new GridLayout(0, 4, 5, 5));
        panelCampos.add(new JLabel("X1:")); panelCampos.add(txtX1);
        panelCampos.add(new JLabel("Y1:")); panelCampos.add(txtY1);
        panelCampos.add(new JLabel("X2:")); panelCampos.add(txtX2);
        panelCampos.add(new JLabel("Y2:")); panelCampos.add(txtY2);
        panelCampos.add(new JLabel("Mover dx:")); panelCampos.add(txtDx);
        panelCampos.add(new JLabel("Mover dy:")); panelCampos.add(txtDy);
        panelCampos.add(new JLabel("Factor:")); panelCampos.add(txtFactor);
        panelCampos.add(new JLabel("")); panelCampos.add(new JLabel(""));
        panelCampos.add(new JLabel("Punto X:")); panelCampos.add(txtPx);
        panelCampos.add(new JLabel("Punto Y:")); panelCampos.add(txtPy);

        JPanel panelBotones = new JPanel(new GridLayout(1, 5, 5, 5));
        panelBotones.add(btnCrear);
        panelBotones.add(btnArea);
        panelBotones.add(btnMover);
        panelBotones.add(btnEscalar);
        panelBotones.add(btnPunto);

        btnCrear.addActionListener(this);
        btnArea.addActionListener(this);
        btnMover.addActionListener(this);
        btnEscalar.addActionListener(this);
        btnPunto.addActionListener(this);

        areaSalida.setEditable(false);

        add(panelCampos, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(new JScrollPane(areaSalida), BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private double leer(JTextField campo) {
        return Double.parseDouble(campo.getText().trim().replace(',', '.'));
    }

    private void mostrar(String texto) {
        areaSalida.append(texto + "\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btnCrear) {
                boolean ok = controlador.crear(leer(txtX1), leer(txtY1), leer(txtX2), leer(txtY2));
                if (ok) {
                    mostrar("Creado: " + controlador.descripcion());
                } else {
                    mostrar("Error: los vértices deben ser opuestos (X1≠X2 y Y1≠Y2).");
                }
                return;
            }

            if (!controlador.hayRectangulo()) {
                mostrar("Primero cree un rectángulo.");
                return;
            }

            if (e.getSource() == btnArea) {
                mostrar("Área = " + controlador.calcularArea());
            } else if (e.getSource() == btnMover) {
                controlador.mover(leer(txtDx), leer(txtDy));
                mostrar("Movido: " + controlador.descripcion());
            } else if (e.getSource() == btnEscalar) {
                if (controlador.escalar(leer(txtFactor))) {
                    mostrar("Escalado: " + controlador.descripcion());
                } else {
                    mostrar("El factor debe ser mayor que 0.");
                }
            } else if (e.getSource() == btnPunto) {
                boolean dentro = controlador.puntoDentro(leer(txtPx), leer(txtPy));
                mostrar("El punto (" + txtPx.getText() + ", " + txtPy.getText() + ") "
                        + (dentro ? "SÍ está" : "NO está") + " dentro del rectángulo.");
            }
        } catch (NumberFormatException ex) {
            mostrar("Error: ingrese solo números válidos.");
        }
    }
}