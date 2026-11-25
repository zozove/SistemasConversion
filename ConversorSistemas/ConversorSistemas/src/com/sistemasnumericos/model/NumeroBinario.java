package com.sistemasnumericos.model;

// Modelo para representar un número binario 
public class NumeroBinario {
    
    private String valor;
    private int bits;
    private boolean esNegativo;
    
    public NumeroBinario(String valor, int bits) {
        this.valor = valor;
        this.bits = bits;
        this.esNegativo = (valor.charAt(0) == '1');
    }
    
    public String getValor() {
        return valor;
    }
    
    public void setValor(String valor) {
        this.valor = valor;
        this.esNegativo = (valor.charAt(0) == '1');
    }
    
    public int getBits() {
        return bits;
    }
    
    public void setBits(int bits) {
        this.bits = bits;
    }
    
    public boolean esNegativo() {
        return esNegativo;
    }
    
    public String getValorCompleto() {
        if (valor.length() >= bits) {
            return valor;
        }
        
        StringBuilder resultado = new StringBuilder();
        int cerosFaltantes = bits - valor.length();
        int i = 0;
        while (i < cerosFaltantes) {
            resultado.append('0');
            i++;
        }
        resultado.append(valor);
        
        return resultado.toString();
    }
    
    public int aDecimal() {
        if (esNegativo) {
            // Complemento a 2 inverso
            StringBuilder complemento1 = new StringBuilder();
            int i = 0;
            while (i < valor.length()) {
                char c = valor.charAt(i);
                if (c == '0') {
                    complemento1.append('1');
                } else {
                    complemento1.append('0');
                }
                i++;
            }
            
            // Sumar 1
            String positivo = sumarUno(complemento1.toString());
            int valorPositivo = binarioADecimal(positivo);
            return -valorPositivo;
        } else {
            return binarioADecimal(valor);
        }
    }
    
    private int binarioADecimal(String binario) {
        int decimal = 0;
        int potencia = 1;
        int i = binario.length() - 1;
        
        while (i >= 0) {
            char c = binario.charAt(i);
            if (c == '1') {
                decimal = decimal + potencia;
            }
            potencia = potencia * 2;
            i--;
        }
        
        return decimal;
    }
    
    private String sumarUno(String binario) {
        StringBuilder resultado = new StringBuilder();
        int acarreo = 1;
        int i = binario.length() - 1;
        
        while (i >= 0 || acarreo > 0) {
            int bit = (i >= 0) ? (binario.charAt(i) - '0') : 0;
            int suma = bit + acarreo;
            
            if (suma == 2) {
                resultado.insert(0, '0');
                acarreo = 1;
            } else if (suma == 1) {
                resultado.insert(0, '1');
                acarreo = 0;
            } else {
                resultado.insert(0, '0');
                acarreo = 0;
            }
            i--;
        }
        
        return resultado.toString();
    }
    
    @Override
    public String toString() {
        return getValorCompleto() + (esNegativo ? " (negativo)" : " (positivo)");
    }
}