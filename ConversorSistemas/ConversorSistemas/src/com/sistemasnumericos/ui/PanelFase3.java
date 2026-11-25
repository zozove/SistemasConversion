package com.sistemasnumericos.ui;

import com.sistemasnumericos.logic.ComplementoADos;
import javax.swing.*;
import java.awt.*;

public class PanelFase3 extends JPanel {
    
    private JTextField txtDecimal;
    private JComboBox<Integer> cbBits;
    private JLabel lblResultado;
    private JLabel lblEstado;
    private JLabel lblRango;
    
    public PanelFase3() {
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        setBackground(new Color(240, 248, 255));
        inicializarComponentes();
    }
    
    private void inicializarComponentes() {
        // Panel de entrada
        JPanel panelEntrada = new JPanel(new GridBagLayout());
        panelEntrada.setBackground(new Color(244, 67, 54));
        panelEntrada.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(211, 47, 47), 2),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        JLabel lblTitulo = new JLabel("FASE 3: COMPLEMENTO A 2");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panelEntrada.add(lblTitulo, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        panelEntrada.add(new JLabel("ENTRADA (Entero Decimal):"), gbc);
        
        gbc.gridx = 1;
        txtDecimal = new JTextField(10);
        txtDecimal.setFont(new Font("Consolas", Font.PLAIN, 16));
        txtDecimal.setHorizontalAlignment(JTextField.CENTER);
        panelEntrada.add(txtDecimal, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelEntrada.add(new JLabel("N bits (8, 16, 32):"), gbc);
        
        gbc.gridx = 1;
        Integer[] bits = {8, 16, 32};
        cbBits = new JComboBox<>(bits);
        cbBits.setFont(new Font("Segoe UI", Font.BOLD, 14));
        cbBits.addActionListener(e -> actualizarRango());
        panelEntrada.add(cbBits, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        JButton btnCalcular = new JButton("CALCULAR COMPLEMENTO A 2");
        btnCalcular.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCalcular.setBackground(new Color(255, 193, 7));
        btnCalcular.setForeground(new Color(211, 47, 47));
        btnCalcular.setFocusPainted(false);
        btnCalcular.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCalcular.addActionListener(e -> calcular());
        panelEntrada.add(btnCalcular, gbc);
        
        // Panel de resultado
        JPanel panelResultado = new JPanel(new BorderLayout(10, 10));
        panelResultado.setBackground(Color.WHITE);
        panelResultado.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(244, 67, 54), 3),
            BorderFactory.createEmptyBorder(25, 25, 25, 25)
        ));
        
        JLabel lblResTexto = new JLabel("RESULTADO EN COMPLEMENTO A 2");
        lblResTexto.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblResTexto.setForeground(new Color(244, 67, 54));
        lblResTexto.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel panelResultadoCentral = new JPanel(new GridBagLayout());
        panelResultadoCentral.setBackground(Color.WHITE);
        
        GridBagConstraints gbcRes = new GridBagConstraints();
        gbcRes.insets = new Insets(10, 10, 10, 10);
        
        lblResultado = new JLabel("00000000");
        lblResultado.setFont(new Font("Consolas", Font.BOLD, 32));
        lblResultado.setForeground(new Color(33, 150, 243));
        lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblEstado = new JLabel(" ");
        lblEstado.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblEstado.setForeground(new Color(76, 175, 80));
        
        lblRango = new JLabel();
        lblRango.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblRango.setForeground(Color.GRAY);
        actualizarRango();
        
        gbcRes.gridx = 0;
        gbcRes.gridy = 0;
        panelResultadoCentral.add(lblResultado, gbcRes);
        gbcRes.gridy = 1;
        panelResultadoCentral.add(lblEstado, gbcRes);
        gbcRes.gridy = 2;
        panelResultadoCentral.add(lblRango, gbcRes);
        
        panelResultado.add(lblResTexto, BorderLayout.NORTH);
        panelResultado.add(panelResultadoCentral, BorderLayout.CENTER);
        
        add(panelEntrada, BorderLayout.NORTH);
        add(panelResultado, BorderLayout.CENTER);
        
        // Panel de información
        JPanel panelInfo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelInfo.setBackground(new Color(240, 248, 255));
        JLabel lblInfo = new JLabel("ℹ El complemento a 2 solo opera con números ENTEROS");
        lblInfo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblInfo.setForeground(Color.GRAY);
        panelInfo.add(lblInfo);
        
        add(panelInfo, BorderLayout.SOUTH);
    }
    
    private void actualizarRango() {
        int bits = (int) cbBits.getSelectedItem();
        int min = calcularPotencia(bits - 1);
        min = -min;
        int max = calcularPotencia(bits - 1) - 1;
        lblRango.setText("Rango válido para " + bits + " bits: [" + min + ", " + max + "]");
    }
    
    private int calcularPotencia(int exponente) {
        int resultado = 1;
        for (int i = 0; i < exponente; i++) {
            resultado = resultado * 2;
        }
        return resultado;
    }
    
    private void calcular() {
        String texto = txtDecimal.getText().trim();
        
        // Validar campo vacío
        if (texto.equals("")) {
            JOptionPane.showMessageDialog(this, 
                "Error: Ingrese un número entero", 
                "Campo vacío", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Validar que no tenga punto decimal
        boolean tienePunto = false;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == '.') {
                tienePunto = true;
                break;
            }
        }
        
        if (tienePunto) {
            JOptionPane.showMessageDialog(this, 
                "Error: Solo se permiten números ENTEROS\n" +
                "El complemento a 2 no opera con números decimales", 
                "Formato inválido", 
                JOptionPane.ERROR_MESSAGE);
            txtDecimal.setText("");
            lblResultado.setText("ERROR");
            lblEstado.setText("");
            return;
        }
        
        // Validar que solo tenga dígitos y signo menos
        boolean esValido = true;
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (i == 0 && c == '-') {
                continue;
            }
            if (c < '0' || c > '9') {
                esValido = false;
                break;
            }
        }
        
        if (!esValido) {
            JOptionPane.showMessageDialog(this, 
                "Error: Ingrese un número entero válido\n" +
                "Use solo dígitos y opcionalmente el signo menos al inicio", 
                "Formato inválido", 
                JOptionPane.ERROR_MESSAGE);
            txtDecimal.setText("");
            lblResultado.setText("ERROR");
            lblEstado.setText("");
            return;
        }
        
        try {
            int decimal = Integer.parseInt(texto);
            int bits = (int) cbBits.getSelectedItem();
            
            String resultado = ComplementoADos.calcular(decimal, bits);
            
            if (resultado.startsWith("ERROR")) {
                JOptionPane.showMessageDialog(this, 
                    resultado, 
                    "Error de Overflow", 
                    JOptionPane.ERROR_MESSAGE);
                lblResultado.setText("ERROR");
                lblEstado.setText("");
            } else {
                lblResultado.setText(resultado);
                if (decimal >= 0) {
                    lblEstado.setText("✓ Número POSITIVO - Representación directa");
                } else {
                    lblEstado.setText("✓ Número NEGATIVO - Complemento a 2 aplicado");
                }
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Error: Número fuera del rango permitido\n" +
                "Para " + bits + " bits el rango es " + lblRango.getText(), 
                "Número inválido", 
                JOptionPane.ERROR_MESSAGE);
            lblResultado.setText("ERROR");
            lblEstado.setText("");
        }
    }
}