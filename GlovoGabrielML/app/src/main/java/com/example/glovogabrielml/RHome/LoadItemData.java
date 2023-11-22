package com.example.glovogabrielml.RHome;

public class LoadItemData {
    ////////////////////////////////////////ATRIBUTOS////////////////////////////////////////
    private Integer id_producto;
    private String nombre;
    private String imagen;
    private String descripcion;
    private Integer precio;

    /////////////////////////////////////////MÉTODOS/////////////////////////////////////////
    public int getId_producto() {
        return id_producto;
    }
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String toString() {
        return "RLoginData{" +
                "id=" + id_producto +
                "nombre=" + nombre +
                "imagen=" + imagen +
                "descripcion=" + descripcion +
                "precio=" + precio +
                '}';
    }
}
