package com.sistemasnumericos;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            // Crear y mostrar la ventana principal
            com.sistemasnumericos.ui.VentanaPrincipal ventana = new com.sistemasnumericos.ui.VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}