package com.sistemasnumericos.ui;

import com.sistemasnumericos.logic.ConversorDecimal;
import java.awt.*;
import javax.swing.*;

public class PanelFase1 extends JPanel {
    
    private JTextField txtDecimal;
    private JLabel lblBinario, lblOctal, lblHexadecimal;
    
    public PanelFase1() {
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        setBackground(new Color(240, 248, 255));
        inicializarComponentes();
    }
    
    private void inicializarComponentes() {
        // Panel entrada
        JPanel panelEntrada = new JPanel();
        panelEntrada.setLayout(new BoxLayout(panelEntrada, BoxLayout.Y_AXIS));
        panelEntrada.setBackground(new Color(25, 118, 210));
        panelEntrada.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel lblTitulo = new JLabel("FASE 1: CONVERSIÓN DE DECIMAL");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPanel panelInput = new JPanel(new FlowLayout());
        panelInput.setOpaque(false);
        
        JLabel lblEntrada = new JLabel("ENTRADA DECIMAL (Base 10):");
        lblEntrada.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblEntrada.setForeground(Color.WHITE);
        
        txtDecimal = new JTextField(10);
        txtDecimal.setFont(new Font("Consolas", Font.PLAIN, 16));
        txtDecimal.setHorizontalAlignment(JTextField.CENTER);
        
        JButton btnConvertir = new JButton("CONVERTIR");
        btnConvertir.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnConvertir.setBackground(new Color(255, 193, 7));
        btnConvertir.setForeground(new Color(25, 118, 210));
        btnConvertir.setFocusPainted(false);
        btnConvertir.addActionListener(e -> convertir());
        
        panelInput.add(lblEntrada);
        panelInput.add(txtDecimal);
        panelInput.add(btnConvertir);
        
        panelEntrada.add(lblTitulo);
        panelEntrada.add(Box.createRigidArea(new Dimension(0, 20)));
        panelEntrada.add(panelInput);
        
        // Panel resultados
        JPanel panelResultados = new JPanel(new GridLayout(1, 3, 20, 20));
        panelResultados.setBackground(new Color(240, 248, 255));
        panelResultados.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Binario
        JPanel pBinario = new JPanel(new BorderLayout());
        pBinario.setBackground(Color.WHITE);
        pBinario.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 243), 3));
        
        JLabel lBinTit = new JLabel("BINARIO (Base 2)", SwingConstants.CENTER);
        lBinTit.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lBinTit.setForeground(new Color(33, 150, 243));
        lBinTit.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        lblBinario = new JLabel("0", SwingConstants.CENTER);
        lblBinario.setFont(new Font("Consolas", Font.BOLD, 24));
        lblBinario.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        
        pBinario.add(lBinTit, BorderLayout.NORTH);
        pBinario.add(lblBinario, BorderLayout.CENTER);
        
        // Octal
        JPanel pOctal = new JPanel(new BorderLayout());
        pOctal.setBackground(Color.WHITE);
        pOctal.setBorder(BorderFactory.createLineBorder(new Color(76, 175, 80), 3));
        
        JLabel lOctTit = new JLabel("OCTAL (Base 8)", SwingConstants.CENTER);
        lOctTit.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lOctTit.setForeground(new Color(76, 175, 80));
        lOctTit.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        lblOctal = new JLabel("0", SwingConstants.CENTER);
        lblOctal.setFont(new Font("Consolas", Font.BOLD, 24));
        lblOctal.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        
        pOctal.add(lOctTit, BorderLayout.NORTH);
        pOctal.add(lblOctal, BorderLayout.CENTER);
        
        // Hexadecimal
        JPanel pHex = new JPanel(new BorderLayout());
        pHex.setBackground(Color.WHITE);
        pHex.setBorder(BorderFactory.createLineBorder(new Color(255, 87, 34), 3));
        
        JLabel lHexTit = new JLabel("HEXADECIMAL (Base 16)", SwingConstants.CENTER);
        lHexTit.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lHexTit.setForeground(new Color(255, 87, 34));
        lHexTit.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        lblHexadecimal = new JLabel("0", SwingConstants.CENTER);
        lblHexadecimal.setFont(new Font("Consolas", Font.BOLD, 24));
        lblHexadecimal.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        
        pHex.add(lHexTit, BorderLayout.NORTH);
        pHex.add(lblHexadecimal, BorderLayout.CENTER);
        
        panelResultados.add(pBinario);
        panelResultados.add(pOctal);
        panelResultados.add(pHex);
        
        add(panelEntrada, BorderLayout.NORTH);
        add(panelResultados, BorderLayout.CENTER);
    }
    
    private void convertir() {
        try {
            String texto = txtDecimal.getText().trim();
            
            if (texto.equals("")) {
                JOptionPane.showMessageDialog(this, "Ingrese un número decimal", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            int decimal = Integer.parseInt(texto);
            
            if (decimal < 0) {
                JOptionPane.showMessageDialog(this, "Ingrese un número positivo", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String binario = ConversorDecimal.aBinario(decimal);
            String octal = ConversorDecimal.aOctal(decimal);
            String hex = ConversorDecimal.aHexadecimal(decimal);
            
            lblBinario.setText(binario);
            lblOctal.setText(octal);
            lblHexadecimal.setText(hex);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número decimal válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}