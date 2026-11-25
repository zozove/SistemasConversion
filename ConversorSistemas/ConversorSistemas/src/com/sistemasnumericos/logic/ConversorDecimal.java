package com.sistemasnumericos.logic;

public class ConversorDecimal {
    //Zoe Cartuche
    private static final char[] HEX_DIGITS = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    
    public static String aBinario(int decimal) {
        if (decimal == 0) {
            return "0";
        }
        
        int num = decimal;
        String resultado = "";
        
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
    
    public static String aOctal(int decimal) {
        if (decimal == 0) {
            return "0";
        }
        
        int num = decimal;
        String resultado = "";
        
        while (num > 0) {
            int residuo = num % 8;
            resultado = residuo + resultado;
            num = num / 8;
        }
        
        return resultado;
    }
    
    public static String aHexadecimal(int decimal) {
        if (decimal == 0) {
            return "0";
        }
        
        int num = decimal;
        String resultado = "";
        
        while (num > 0) {
            int residuo = num % 16;
            resultado = HEX_DIGITS[residuo] + resultado;
            num = num / 16;
        }
        
        return resultado;
    }
}