package com.example.glovogabrielml.RInfo.LoadRProducts;

public class LoadRProductsData {
    ////////////////////////////////////////ATRIBUTOS////////////////////////////////////////
    private Integer id_producto;
    private String nombre;
    private String imagen;
    private String descripcion;
    private Integer precio;

    /////////////////////////////////////////MÉTODOS/////////////////////////////////////////
    public Integer getId_producto() {
        return id_producto;
    }
    public void setId_producto(Integer id_producto) {
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
    public Integer getPrecio() {
        return precio;
    }
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
}
