package com.sistemasnumericos.utils;

//Clase de utilidad para validar números en diferentes bases
 
public class ValidadorNumerico {
    
    // Valida si un string es un número binario válido
     
    public static boolean esBinarioValido(String numero) {
        return numero != null && numero.matches("[01]+");
    }
    
    // Valida si un string es un número octal válido
     
    public static boolean esOctalValido(String numero) {
        return numero != null && numero.matches("[0-7]+");
    }
    
    // Valida si un string es un número hexadecimal válido
     
    public static boolean esHexadecimalValido(String numero) {
        return numero != null && numero.matches("[0-9A-Fa-f]+");
    }
    
    //Valida si un número decimal está dentro del rango para una cantidad de bits
     
    public static boolean estaEnRangoParaBits(int numero, int bits) {
        int min = -(int)Math.pow(2, bits-1);
        int max = (int)Math.pow(2, bits-1) - 1;
        return numero >= min && numero <= max;
    }
    
    // Obtiene el rango válido para una cantidad de bits
    public static String obtenerRangoBits(int bits) {
        int min = -(int)Math.pow(2, bits-1);
        int max = (int)Math.pow(2, bits-1) - 1;
        return "[" + min + ", " + max + "]";
    }
    
    //
    public static boolean esPositivo(int numero) {
        return numero >= 0;
    }
}