package com.sistemasnumericos.exceptions;

public class FormatoInvalidoException extends Exception {
    
    private String mensaje;
    
    public FormatoInvalidoException() {
        this.mensaje = "Formato de número inválido para la base especificada";
    }
    
    public FormatoInvalidoException(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    
    @Override
    public String toString() {
        return "FormatoInvalidoException: " + mensaje;
    }
}