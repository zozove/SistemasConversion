package com.sistemasnumericos.exceptions;

public class OverflowException extends Exception {
    
    private String mensaje;
    private int numero;
    private int bits;
    
    public OverflowException() {
        this.mensaje = "Overflow: El número excede el rango permitido";
        this.numero = 0;
        this.bits = 0;
    }
    
    public OverflowException(String mensaje) {
        this.mensaje = mensaje;
        this.numero = 0;
        this.bits = 0;
    }
    
    public OverflowException(int numero, int bits) {
        this.numero = numero;
        this.bits = bits;
        this.mensaje = "Overflow: El número " + numero + " no se puede representar en " + bits + " bits";
    }
    
    public String getMensaje() {
        return mensaje;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public int getBits() {
        return bits;
    }
    
    @Override
    public String toString() {
        return "OverflowException: " + mensaje;
    }
}