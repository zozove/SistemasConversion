package com.sistemasnumericos.logic;
//Angela Cevallos
public class OperacionesBinarias {
    
    
    public static String sumarBinario(String bin1, String bin2) {
        if (bin1 == null || bin1.length() == 0) bin1 = "0";
        if (bin2 == null || bin2.length() == 0) bin2 = "0";
        
        // Igualar longitudes
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
        
        // Agregar acarreo final si existe
        if (acarreo == 1) {
            resultado = "1" + resultado;
        }
        
        return resultado;
    }
    
    
    public static String sumarBinarioConBits(String bin1, String bin2, int bits) {
        String resultado = sumarBinario(bin1, bin2);
        
        // Si el resultado tiene más bits que el límite, descartar el acarreo
        if (resultado.length() > bits) {
            resultado = resultado.substring(resultado.length() - bits);
        }
        
        return resultado;
    }
    
    
    public static String restarBinario(String bin1, String bin2, int bits) {
        if (bits != 8 && bits != 16 && bits != 32) {
            return "ERROR: Bits no válidos (use 8, 16 o 32)";
        }
        
        if (!esBinarioValido(bin1) || !esBinarioValido(bin2)) {
            return "ERROR: Los números deben ser binarios (solo 0 y 1)";
        }
        
        // Rellenar a la cantidad de bits
        String b1 = rellenarCeros(bin1, bits);
        String b2 = rellenarCeros(bin2, bits);
        
        // Obtener complemento a 2 del sustraendo
        String ca2 = complementoADos(b2);
        
        // Sumar
        String suma = sumarBinario(b1, ca2);
        
        // Descartar el acarreo (quedarnos solo con 'bits' bits)
        if (suma.length() > bits) {
            suma = suma.substring(suma.length() - bits);
        }
        
        return suma;
    }
    
    
    private static String complementoADos(String binario) {
        String complemento1 = "";
        for (int i = 0; i < binario.length(); i++) {
            if (binario.charAt(i) == '0') {
                complemento1 = complemento1 + "1";
            } else {
                complemento1 = complemento1 + "0";
            }
        }
        return sumarBinario(complemento1, "1");
    }
    
    
    public static boolean esBinarioValido(String binario) {
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
    
    
    public static int binarioADecimal(String binario) {
        int decimal = 0;
        int potencia = 1;
        
        for (int i = binario.length() - 1; i >= 0; i--) {
            if (binario.charAt(i) == '1') {
                decimal = decimal + potencia;
            }
            potencia = potencia * 2;
        }
        
        return decimal;
    }
    
   
    public static String decimalABinario(int decimal) {
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
}