package com.example.glovogabrielml.Beans;

public class Usuario {
    ////////////////////////////////////////ATRIBUTOS////////////////////////////////////////
    private Integer id_usuario;
    private String nombre;
    private String contrasena;

    public Usuario(String nombre, String contrasena){
        this.nombre=nombre;
        this.contrasena=contrasena;
    }

    /////////////////////////////////////////MÉTODOS/////////////////////////////////////////
    public Integer getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
