package practica1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Practica1 extends JFrame {

    private JTextField txtNombre, txtEspecialidad, txtCurp;
    private JTextField txtInscripcion, txtMensualidad, txtLibros, txtUniformes;
    private JTextField txtTotal;
    private JButton btnCalcular, btnLimpiar;

    public Practica1() {
        // Configuración de la ventana principal
        setTitle("Práctica 1 - Registro de Alumnos");
        setSize(460, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Título del formulario
        JLabel lblTitulo = new JLabel("Sistema de Inscripción", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBounds(20, 15, 400, 30);
        add(lblTitulo);

        // Datos del alumno
        JLabel lblNombre = new JLabel("Nombre del alumno:");
        lblNombre.setBounds(30, 60, 140, 25);
        add(lblNombre);
        txtNombre = new JTextField();
        txtNombre.setBounds(180, 60, 220, 25);
        add(txtNombre);

        JLabel lblEspecialidad = new JLabel("Especialidad:");
        lblEspecialidad.setBounds(30, 95, 140, 25);
        add(lblEspecialidad);
        txtEspecialidad = new JTextField();
        txtEspecialidad.setBounds(180, 95, 220, 25);
        add(txtEspecialidad);

        JLabel lblCurp = new JLabel("CURP:");
        lblCurp.setBounds(30, 130, 140, 25);
        add(lblCurp);
        txtCurp = new JTextField();
        txtCurp.setBounds(180, 130, 220, 25);
        add(txtCurp);

        // Subtítulo: Cuota y Gastos de inscripción
        JLabel lblGastos = new JLabel("Cuota y Gastos de inscripción", SwingConstants.CENTER);
        lblGastos.setFont(new Font("Arial", Font.BOLD, 14));
        lblGastos.setBounds(20, 175, 400, 25);
        add(lblGastos);

        // Campos de costos
        JLabel lblInscripcion = new JLabel("Inscripción: $");
        lblInscripcion.setBounds(30, 210, 140, 25);
        add(lblInscripcion);
        txtInscripcion = new JTextField();
        txtInscripcion.setBounds(180, 210, 220, 25);
        add(txtInscripcion);

        JLabel lblMensualidad = new JLabel("Mensualidad: $");
        lblMensualidad.setBounds(30, 245, 140, 25);
        add(lblMensualidad);
        txtMensualidad = new JTextField();
        txtMensualidad.setBounds(180, 245, 220, 25);
        add(txtMensualidad);

        JLabel lblLibros = new JLabel("Libros: $");
        lblLibros.setBounds(30, 280, 140, 25);
        add(lblLibros);
        txtLibros = new JTextField();
        txtLibros.setBounds(180, 280, 220, 25);
        add(txtLibros);

        JLabel lblUniformes = new JLabel("Uniformes: $");
        lblUniformes.setBounds(30, 315, 140, 25);
        add(lblUniformes);
        txtUniformes = new JTextField();
        txtUniformes.setBounds(180, 315, 220, 25);
        add(txtUniformes);

        JLabel lblTotal = new JLabel("Total a pagar: $");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 13));
        lblTotal.setBounds(30, 360, 140, 25);
        add(lblTotal);
        txtTotal = new JTextField();
        txtTotal.setBounds(180, 360, 220, 25);
        txtTotal.setEditable(false);
        add(txtTotal);

        btnCalcular = new JButton("Calcular Total");
        btnCalcular.setBounds(70, 415, 140, 30);
        add(btnCalcular);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(230, 415, 140, 30);
        add(btnLimpiar);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularTotal();
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
    }

    private void calcularTotal() {
        try {
            double inscripcion = Double.parseDouble(txtInscripcion.getText().trim());
            double mensualidad = Double.parseDouble(txtMensualidad.getText().trim());
            double libros = Double.parseDouble(txtLibros.getText().trim());
            double uniformes = Double.parseDouble(txtUniformes.getText().trim());

            double total = inscripcion + mensualidad + libros + uniformes;
            txtTotal.setText(String.format("%.2f", total));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Por favor ingrese valores numéricos válidos en los campos de dinero.", 
                "Error de entrada", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtEspecialidad.setText("");
        txtCurp.setText("");
        txtInscripcion.setText("");
        txtMensualidad.setText("");
        txtLibros.setText("");
        txtUniformes.setText("");
        txtTotal.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Practica1().setVisible(true);
        });
    }
}