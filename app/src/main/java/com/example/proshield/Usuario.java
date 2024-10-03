package com.example.proshield;

public class Usuario {
    private String nombre;
    private String correo;
    private String contrasena;
    private String cargo;
    private String telefono;
    private String enfermedad;

    public Usuario(String nombre, String correo, String contrasena, String cargo, String telefono, String enfermedad) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.cargo = cargo;
        this.telefono = telefono;
        this.enfermedad = enfermedad;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getCargo() {
        return cargo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", cargo='" + cargo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", enfermedad='" + enfermedad + '\'' +
                '}';
    }
}
