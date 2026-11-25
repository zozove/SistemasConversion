package com.sistemasnumericos.ui;

import com.sistemasnumericos.logic.ConversorADecimal;
import java.awt.*;
import javax.swing.*;

public class PanelFase2 extends JPanel {
    
    private JTextField txtNumero;
    private JComboBox<Integer> cbBase;
    private JLabel lblResultado;
    private JLabel lblExpresion;
    
    public PanelFase2() {
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        setBackground(new Color(240, 248, 255));
        inicializarComponentes();
    }
    
    private void inicializarComponentes() {
        // Panel superior
        JPanel panelEntrada = new JPanel(new GridBagLayout());
        panelEntrada.setBackground(new Color(103, 58, 183));
        panelEntrada.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(81, 45, 168), 2),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        JLabel lblTitulo = new JLabel("FASE 2: CONVERSIÓN A DECIMAL");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        panelEntrada.add(lblTitulo, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        panelEntrada.add(new JLabel("ENTRADA (Base 2, 8, 16):"), gbc);
        gbc.gridx = 1;
        txtNumero = new JTextField(15);
        txtNumero.setFont(new Font("Consolas", Font.PLAIN, 16));
        txtNumero.setHorizontalAlignment(JTextField.CENTER);
        panelEntrada.add(txtNumero, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        panelEntrada.add(new JLabel("BASE:"), gbc);
        gbc.gridx = 1;
        Integer[] bases = {2, 8, 16};
        cbBase = new JComboBox<>(bases);
        cbBase.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panelEntrada.add(cbBase, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        JButton btnConvertir = new JButton("CONVERTIR");
        btnConvertir.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnConvertir.setBackground(new Color(255, 193, 7));
        btnConvertir.setForeground(new Color(81, 45, 168));
        btnConvertir.setFocusPainted(false);
        btnConvertir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnConvertir.addActionListener(e -> convertir());
        panelEntrada.add(btnConvertir, gbc);
        
        // Panel de resultado
        JPanel panelResultado = new JPanel(new GridBagLayout());
        panelResultado.setBackground(Color.WHITE);
        panelResultado.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(103, 58, 183), 3),
            BorderFactory.createEmptyBorder(30, 30, 30, 30)
        ));
        
        GridBagConstraints gbcRes = new GridBagConstraints();
        gbcRes.insets = new Insets(10, 10, 10, 10);
        
        JLabel lblResTexto = new JLabel("RESULTADO EN DECIMAL");
        lblResTexto.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblResTexto.setForeground(new Color(103, 58, 183));
        
        lblResultado = new JLabel("0");
        lblResultado.setFont(new Font("Consolas", Font.BOLD, 48));
        lblResultado.setForeground(new Color(255, 87, 34));
        lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblExpresion = new JLabel(" ");
        lblExpresion.setFont(new Font("Consolas", Font.PLAIN, 12));
        lblExpresion.setForeground(Color.GRAY);
        
        gbcRes.gridx = 0; gbcRes.gridy = 0;
        panelResultado.add(lblResTexto, gbcRes);
        gbcRes.gridy = 1;
        panelResultado.add(lblResultado, gbcRes);
        gbcRes.gridy = 2;
        panelResultado.add(lblExpresion, gbcRes);
        
        add(panelEntrada, BorderLayout.NORTH);
        add(panelResultado, BorderLayout.CENTER);
    }
    
    private void convertir() {
        try {
            String numero = txtNumero.getText().trim().toUpperCase();
            int base = (int) cbBase.getSelectedItem();
            int resultado = ConversorADecimal.aDecimal(numero, base);
            lblResultado.setText(String.valueOf(resultado));
            lblExpresion.setText(generarExpresion(numero, base));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Número inválido para la base seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private String generarExpresion(String numero, int base) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numero.length(); i++) {
            char c = numero.charAt(i);
            int potencia = numero.length() - 1 - i;
            sb.append(c).append("·").append(base).append("^").append(potencia);
            if (i < numero.length() - 1) sb.append(" + ");
        }
        return sb.toString();
    }
}