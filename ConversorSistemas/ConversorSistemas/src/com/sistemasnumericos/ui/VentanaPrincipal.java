package com.sistemasnumericos.ui;

import java.awt.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    
    public VentanaPrincipal() {
        setTitle("Conversor de Sistemas Numéricos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 750);
        setLocationRelativeTo(null);
        setResizable(true);
        
        iniciarComponentes();
    }
    
    private void iniciarComponentes() {
        // Crear el panel de pestañas
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 13));
        
        // Crear los paneles de cada fase
        PanelFase1 panelFase1 = new PanelFase1();
        PanelFase2 panelFase2 = new PanelFase2();
        PanelFase3 panelFase3 = new PanelFase3();
        PanelFase4 panelFase4 = new PanelFase4();
        
        // Agregar las pestañas
        tabbedPane.addTab("FASE 1: Decimal → Bin/Oct/Hex", panelFase1);
        tabbedPane.addTab("FASE 2: Bin/Oct/Hex → Decimal", panelFase2);
        tabbedPane.addTab("FASE 3: Complemento a 2", panelFase3);
        tabbedPane.addTab("FASE 4: Suma y Resta Binaria", panelFase4);
        
        add(tabbedPane);
    }
}