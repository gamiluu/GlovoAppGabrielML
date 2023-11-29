package com.example.glovogabrielml.CategoryList;

public class LoadByCatData {
    //ATRIBUTOS
    private Integer id_restaurante;
    private String nombre;
    private String imagen;
    private Double nota_media;

    //MÉTODOS
    public Integer getId_restaurante() {
        return id_restaurante;
    }
    public void setId_restaurante(Integer id_restaurante) {
        this.id_restaurante = id_restaurante;
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
    public Double getNota_media() {
        return nota_media;
    }
    public void setNota_media(Double nota_media) {
        this.nota_media = nota_media;
    }
}
