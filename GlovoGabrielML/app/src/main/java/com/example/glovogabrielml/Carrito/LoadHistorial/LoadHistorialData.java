package com.example.glovogabrielml.Carrito.LoadHistorial;

import java.sql.Date;

public class LoadHistorialData {
    //ATRIBUTOS
    private Integer id_compra;
    private String fecha;
    private Integer precio_total;

    //MÉTODOS
    public Integer getId_compra() {
        return id_compra;
    }
    public void setId_compra(Integer id_compra) {
        this.id_compra = id_compra;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public Integer getPrecio() {
        return precio_total;
    }
    public void setPrecio(Integer precio_total) {
        this.precio_total = precio_total;
    }
}
