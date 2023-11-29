package com.example.glovogabrielml.Carrito.LoadCarrito;

public class LoadCarritoData {
    //ATRIBUTOS
    private String nombre;
    private String imagen;
    private Integer precio;
    private Integer cantidad;

    //MÉTODOS
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
    public Integer getPrecio() {
        return precio;
    }
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
