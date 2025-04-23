package com.example.demo.model;

public class Contacto {
    private String nombre;
    private String correo;
    private String mensaje;
    private String asunto;

    public Contacto(String nombre, String correo, String mensaje, String asunto) {
        this.nombre = nombre;
        this.correo = correo;
        this.mensaje = mensaje;
        this.asunto = asunto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

}
