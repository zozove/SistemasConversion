package com.sistemasnumericos.logic;
// Dominique Vallejo
public class ConversorADecimal {
    
    public static int aDecimal(String numero, int base) {
        if (numero == null || numero.length() == 0) {
            return 0;
        }
        
        // Convertir string a char array manualmente
        char[] digitos = new char[numero.length()];
        for (int i = 0; i < numero.length(); i++) {
            digitos[i] = numero.charAt(i);
        }
        
        int decimal = 0;
        int potencia = 1;
        
        // Recorrer de derecha a izquierda
        for (int i = digitos.length - 1; i >= 0; i--) {
            char c = digitos[i];
            int digito;
            
            if (c >= '0' && c <= '9') {
                digito = c - '0';
            } else if (c >= 'A' && c <= 'F') {
                digito = 10 + (c - 'A');
            } else {
                return -1; // Error
            }
            
            decimal = decimal + (digito * potencia);
            potencia = potencia * base;
        }
        
        return decimal;
    }
}