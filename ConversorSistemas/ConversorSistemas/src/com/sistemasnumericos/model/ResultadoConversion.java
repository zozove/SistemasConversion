package com.sistemasnumericos.model;

public class ResultadoConversion {
    
    private int decimalOriginal;
    private String binario;
    private String octal;
    private String hexadecimal;
    private String complementoA2;
    private int bitsUtilizados;
    private long timestamp;
    
    public ResultadoConversion() {
        this.timestamp = obtenerTiempoActual();
        this.decimalOriginal = 0;
        this.bitsUtilizados = 0;
    }
    
    public ResultadoConversion(int decimalOriginal) {
        this.decimalOriginal = decimalOriginal;
        this.timestamp = obtenerTiempoActual();
        this.bitsUtilizados = 0;
    }
    
    private long obtenerTiempoActual() {
        return System.currentTimeMillis();
    }
    
    public int getDecimalOriginal() {
        return decimalOriginal;
    }
    
    public void setDecimalOriginal(int decimalOriginal) {
        this.decimalOriginal = decimalOriginal;
    }
    
    public String getBinario() {
        return binario;
    }
    
    public void setBinario(String binario) {
        this.binario = binario;
    }
    
    public String getOctal() {
        return octal;
    }
    
    public void setOctal(String octal) {
        this.octal = octal;
    }
    
    public String getHexadecimal() {
        return hexadecimal;
    }
    
    public void setHexadecimal(String hexadecimal) {
        this.hexadecimal = hexadecimal;
    }
    
    public String getComplementoA2() {
        return complementoA2;
    }
    
    public void setComplementoA2(String complementoA2) {
        this.complementoA2 = complementoA2;
    }
    
    public int getBitsUtilizados() {
        return bitsUtilizados;
    }
    
    public void setBitsUtilizados(int bitsUtilizados) {
        this.bitsUtilizados = bitsUtilizados;
    }
    
    public long getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    public boolean hayOverflow() {
        if (complementoA2 != null) {
            // Verificar si contiene "ERROR"
            if (complementoA2.length() >= 5) {
                char[] chars = convertirAArray(complementoA2);
                if (chars[0] == 'E' && chars[1] == 'R' && chars[2] == 'R' && chars[3] == 'O' && chars[4] == 'R') {
                    return true;
                }
            }
        }
        return false;
    }
    
    private char[] convertirAArray(String texto) {
        char[] resultado = new char[texto.length()];
        for (int i = 0; i < texto.length(); i++) {
            resultado[i] = texto.charAt(i);
        }
        return resultado;
    }
    
    public String obtenerResumen() {
        String resumen = "";
        
        resumen = resumen + "=== RESULTADO DE CONVERSIÓN ===\n";
        resumen = resumen + "Decimal original: " + decimalOriginal + "\n";
        
        if (binario != null) {
            resumen = resumen + "Binario: " + binario + "\n";
        }
        
        if (octal != null) {
            resumen = resumen + "Octal: " + octal + "\n";
        }
        
        if (hexadecimal != null) {
            resumen = resumen + "Hexadecimal: " + hexadecimal + "\n";
        }
        
        if (complementoA2 != null) {
            resumen = resumen + "Complemento a 2 (" + bitsUtilizados + " bits): ";
            resumen = resumen + complementoA2 + "\n";
        }
        
        return resumen;
    }
    
    public void limpiar() {
        this.decimalOriginal = 0;
        this.binario = null;
        this.octal = null;
        this.hexadecimal = null;
        this.complementoA2 = null;
        this.bitsUtilizados = 0;
        this.timestamp = obtenerTiempoActual();
    }
    
    public boolean estaCompleto() {
        if (binario == null) return false;
        if (octal == null) return false;
        if (hexadecimal == null) return false;
        return true;
    }
}