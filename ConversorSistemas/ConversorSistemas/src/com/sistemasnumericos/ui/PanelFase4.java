package com.sistemasnumericos.ui;

import com.sistemasnumericos.logic.OperacionesBinarias;
import java.awt.*;
import javax.swing.*;

public class PanelFase4 extends JPanel {
    
    private JTextField txtBin1, txtBin2;
    private JComboBox<Integer> cbBits;
    private JRadioButton rbSuma, rbResta;
    private JLabel lblResultadoBinario;
    private JLabel lblOperacion;
    private JLabel lblAcarreo;
    
    public PanelFase4() {
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        setBackground(new Color(240, 248, 255));
        inicializarComponentes();
    }
    
    private void inicializarComponentes() {
        // Panel de entrada
        JPanel panelEntrada = new JPanel(new GridBagLayout());
        panelEntrada.setBackground(new Color(0, 150, 136));
        panelEntrada.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(0, 121, 107), 2),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        JLabel lblTitulo = new JLabel("FASE 4: ARITMÉTICA AVANZADA");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panelEntrada.add(lblTitulo, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        panelEntrada.add(new JLabel("Número 1:"), gbc);
        
        gbc.gridx = 1;
        txtBin1 = new JTextField(12);
        txtBin1.setFont(new Font("Consolas", Font.PLAIN, 14));
        txtBin1.setHorizontalAlignment(JTextField.CENTER);
        panelEntrada.add(txtBin1, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelEntrada.add(new JLabel("Número 2:"), gbc);
        
        gbc.gridx = 1;
        txtBin2 = new JTextField(12);
        txtBin2.setFont(new Font("Consolas", Font.PLAIN, 14));
        txtBin2.setHorizontalAlignment(JTextField.CENTER);
        panelEntrada.add(txtBin2, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelEntrada.add(new JLabel("Bits:"), gbc);
        
        gbc.gridx = 1;
        Integer[] bits = {8, 16, 32};
        cbBits = new JComboBox<>(bits);
        cbBits.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panelEntrada.add(cbBits, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        panelEntrada.add(new JLabel("Operación:"), gbc);
        
        gbc.gridx = 1;
        JPanel panelRadio = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        panelRadio.setOpaque(false);
        rbSuma = new JRadioButton("SUMA (+)", true);
        rbResta = new JRadioButton("RESTA (-)", false);
        rbSuma.setForeground(Color.WHITE);
        rbResta.setForeground(Color.WHITE);
        rbSuma.setOpaque(false);
        rbResta.setOpaque(false);
        ButtonGroup group = new ButtonGroup();
        group.add(rbSuma);
        group.add(rbResta);
        panelRadio.add(rbSuma);
        panelRadio.add(rbResta);
        panelEntrada.add(panelRadio, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        JButton btnCalcular = new JButton("CALCULAR");
        btnCalcular.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCalcular.setBackground(new Color(255, 193, 7));
        btnCalcular.setForeground(new Color(0, 121, 107));
        btnCalcular.setFocusPainted(false);
        btnCalcular.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCalcular.addActionListener(e -> calcular());
        panelEntrada.add(btnCalcular, gbc);
        
        // Panel de resultado
        JPanel panelResultado = new JPanel(new BorderLayout(10, 10));
        panelResultado.setBackground(Color.WHITE);
        panelResultado.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(0, 150, 136), 3),
            BorderFactory.createEmptyBorder(25, 25, 25, 25)
        ));
        
        JLabel lblResTexto = new JLabel("RESULTADO DE LA OPERACIÓN");
        lblResTexto.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblResTexto.setForeground(new Color(0, 150, 136));
        lblResTexto.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel panelOperacion = new JPanel();
        panelOperacion.setBackground(Color.WHITE);
        lblOperacion = new JLabel(" ");
        lblOperacion.setFont(new Font("Consolas", Font.PLAIN, 14));
        lblOperacion.setForeground(new Color(44, 62, 80));
        panelOperacion.add(lblOperacion);
        
        JPanel panelBinario = new JPanel();
        panelBinario.setBackground(Color.WHITE);
        JLabel lblBinarioTexto = new JLabel("RESULTADO BINARIO:");
        lblBinarioTexto.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblBinarioTexto.setForeground(new Color(255, 87, 34));
        
        lblResultadoBinario = new JLabel("0");
        lblResultadoBinario.setFont(new Font("Consolas", Font.BOLD, 28));
        lblResultadoBinario.setForeground(new Color(33, 150, 243));
        panelBinario.add(lblBinarioTexto);
        panelBinario.add(lblResultadoBinario);
        
        JPanel panelAcarreo = new JPanel();
        panelAcarreo.setBackground(Color.WHITE);
        lblAcarreo = new JLabel(" ");
        lblAcarreo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblAcarreo.setForeground(Color.RED);
        panelAcarreo.add(lblAcarreo);
        
        panelResultado.add(lblResTexto, BorderLayout.NORTH);
        panelResultado.add(panelOperacion, BorderLayout.CENTER);
        panelResultado.add(panelBinario, BorderLayout.SOUTH);
        
        add(panelEntrada, BorderLayout.NORTH);
        add(panelResultado, BorderLayout.CENTER);
        
        JPanel panelInfo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelInfo.setBackground(new Color(240, 248, 255));
        JLabel lblInfo = new JLabel("ℹ Ingrese números binarios (solo 0 y 1)");
        lblInfo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblInfo.setForeground(Color.GRAY);
        panelInfo.add(lblInfo);
        
        add(panelInfo, BorderLayout.SOUTH);
    }
    
    private void calcular() {
        String bin1 = txtBin1.getText().trim();
        String bin2 = txtBin2.getText().trim();
        
        if (bin1.equals("") || bin2.equals("")) {
            JOptionPane.showMessageDialog(this, "Error: Ingrese ambos números binarios", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!esBinarioValido(bin1)) {
            JOptionPane.showMessageDialog(this, "Error: '" + bin1 + "' no es un número binario válido.\nUse solo dígitos 0 y 1", "Formato inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!esBinarioValido(bin2)) {
            JOptionPane.showMessageDialog(this, "Error: '" + bin2 + "' no es un número binario válido.\nUse solo dígitos 0 y 1", "Formato inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int bits = (int) cbBits.getSelectedItem();
        boolean esResta = rbResta.isSelected();
        
        String resultadoBinario;
        String sumaCompleta = "";
        
        if (esResta) {
            resultadoBinario = OperacionesBinarias.restarBinario(bin1, bin2, bits);
            lblOperacion.setText(bin1 + "  -  " + bin2 + "  =  " + resultadoBinario);
            lblAcarreo.setText("");
        } else {
            String b1 = rellenarCeros(bin1, bits);
            String b2 = rellenarCeros(bin2, bits);
            sumaCompleta = sumarBinarioCompleto(b1, b2);
            resultadoBinario = OperacionesBinarias.sumarBinarioConBits(bin1, bin2, bits);
            lblOperacion.setText(bin1 + "  +  " + bin2 + "  =  " + resultadoBinario);
            
            if (sumaCompleta.length() > bits) {
                lblAcarreo.setText("⚠ Acarreo descartado: " + sumaCompleta.substring(0, sumaCompleta.length() - bits));
            } else {
                lblAcarreo.setText("");
            }
        }
        
        if (resultadoBinario.startsWith("ERROR")) {
            JOptionPane.showMessageDialog(this, resultadoBinario, "Error en operación", JOptionPane.ERROR_MESSAGE);
            lblResultadoBinario.setText("ERROR");
            return;
        }
        
        lblResultadoBinario.setText(resultadoBinario);
        
        if (!esResta && sumaCompleta.length() > bits) {
            JOptionPane.showMessageDialog(this, 
                "⚠ ADVERTENCIA: Overflow detectado!\n" +
                "Suma completa: " + sumaCompleta + "\n" +
                "Resultado en " + bits + " bits: " + resultadoBinario + "\n" +
                "El acarreo fue descartado.", 
                "Overflow", 
                JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private String sumarBinarioCompleto(String bin1, String bin2) {
        int maxLen = bin1.length();
        if (bin2.length() > maxLen) maxLen = bin2.length();
        
        String b1 = rellenarCeros(bin1, maxLen);
        String b2 = rellenarCeros(bin2, maxLen);
        
        String resultado = "";
        int acarreo = 0;
        
        for (int i = maxLen - 1; i >= 0; i--) {
            char c1 = b1.charAt(i);
            char c2 = b2.charAt(i);
            
            int bit1 = (c1 == '1') ? 1 : 0;
            int bit2 = (c2 == '1') ? 1 : 0;
            
            int suma = bit1 + bit2 + acarreo;
            
            if (suma == 0) {
                resultado = "0" + resultado;
                acarreo = 0;
            } else if (suma == 1) {
                resultado = "1" + resultado;
                acarreo = 0;
            } else if (suma == 2) {
                resultado = "0" + resultado;
                acarreo = 1;
            } else {
                resultado = "1" + resultado;
                acarreo = 1;
            }
        }
        
        if (acarreo == 1) {
            resultado = "1" + resultado;
        }
        
        return resultado;
    }
    
    private String rellenarCeros(String binario, int bits) {
        if (binario.length() >= bits) {
            return binario;
        }
        
        String resultado = "";
        int cerosFaltantes = bits - binario.length();
        
        for (int i = 0; i < cerosFaltantes; i++) {
            resultado = resultado + "0";
        }
        
        resultado = resultado + binario;
        
        return resultado;
    }
    
    private boolean esBinarioValido(String binario) {
        if (binario == null || binario.length() == 0) {
            return false;
        }
        
        for (int i = 0; i < binario.length(); i++) {
            char c = binario.charAt(i);
            if (c != '0' && c != '1') {
                return false;
            }
        }
        
        return true;
    }
}