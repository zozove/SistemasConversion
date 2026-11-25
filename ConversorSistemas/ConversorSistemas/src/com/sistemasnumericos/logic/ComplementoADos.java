package com.sistemasnumericos.logic;
//Nicolas Bustamante

public class ComplementoADos {
    
    public static String calcular(int decimal, int bits) {
        // Validar bits
        if (bits != 8 && bits != 16 && bits != 32) {
            return "ERROR: Bits no válidos (use 8, 16 o 32)";
        }
        
        // Calcular rango
        int potencia = 1;
        for (int i = 0; i < bits - 1; i++) {
            potencia = potencia * 2;
        }
        
        int min = -potencia;
        int max = potencia - 1;
        
        // Validar overflow
        if (decimal < min || decimal > max) {
            return "ERROR: Overflow - El número " + decimal + " está fuera del rango para " + bits + " bits [" + min + ", " + max + "]";
        }
        
        if (decimal >= 0) {
            // Número positivo: convertir a binario y rellenar
            String binario = decimalABinario(decimal);
            return rellenarCeros(binario, bits);
        } else {
            // Número negativo: complemento a 2
            int positivo = -decimal;
            String binarioPositivo = decimalABinario(positivo);
            String padded = rellenarCeros(binarioPositivo, bits);
            
            // Complemento a 1 (invertir bits)
            String complemento1 = "";
            for (int i = 0; i < padded.length(); i++) {
                if (padded.charAt(i) == '0') {
                    complemento1 = complemento1 + "1";
                } else {
                    complemento1 = complemento1 + "0";
                }
            }
            
            // Sumar 1
            return sumarUno(complemento1);
        }
    }
    
    private static String decimalABinario(int decimal) {
        if (decimal == 0) return "0";
        
        String resultado = "";
        int num = decimal;
        
        while (num > 0) {
            int residuo = num % 2;
            if (residuo == 0) {
                resultado = "0" + resultado;
            } else {
                resultado = "1" + resultado;
            }
            num = num / 2;
        }
        
        return resultado;
    }
    
    private static String rellenarCeros(String binario, int bits) {
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
    
    private static String sumarUno(String binario) {
        char[] bits = new char[binario.length()];
        for (int i = 0; i < binario.length(); i++) {
            bits[i] = binario.charAt(i);
        }
        
        int acarreo = 1;
        
        for (int i = bits.length - 1; i >= 0; i--) {
            if (acarreo == 0) break;
            
            if (bits[i] == '0') {
                bits[i] = '1';
                acarreo = 0;
            } else {
                bits[i] = '0';
                acarreo = 1;
            }
        }
        
        String resultado = "";
        for (int i = 0; i < bits.length; i++) {
            resultado = resultado + bits[i];
        }
        
        if (acarreo == 1) {
            resultado = "1" + resultado;
        }
        
        return resultado;
    }
}