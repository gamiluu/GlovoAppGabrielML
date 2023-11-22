package com.example.glovogabrielml.Beans;

public class Restaurante {
    ////////////////////////////////////////ATRIBUTOS////////////////////////////////////////
    private int id_restaurante;
    private String nombre;
    private String clave;
    private String descripcion;
    private String ubicacion;
    private String imagen;

    //////////////////////////////////////CONSTRUCTORES//////////////////////////////////////
    public Restaurante(){}
    public Restaurante(String nombre, String clave){
        this.nombre = nombre;
        this.clave = clave;
    }
    public Restaurante(int id_restaurante, String nombre, String clave, String descripcion, String ubicacion) {
        this.id_restaurante = id_restaurante;
        this.nombre = nombre;
        this.clave = clave;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    /////////////////////////////////////////MÉTODOS/////////////////////////////////////////

    public int getId_restaurante() {
        return id_restaurante;
    }
    public void setId_restaurante(int id_restaurante) {
        this.id_restaurante = id_restaurante;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
