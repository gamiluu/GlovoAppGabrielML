package com.example.glovogabrielml.RestauranteLogin;

public class RLoginData {
    /////////////////////////////ATRIBUTOS/////////////////////////////
    private int id_restaurante;

    /////////////////////////////ATRIBUTOS/////////////////////////////
    public Integer getId() {
        return id_restaurante;
    }
    public void setId(int id) {
        this.id_restaurante = id_restaurante;
    }
    @Override
    public String toString() {
        return "RLoginData{" +
                "id=" + id_restaurante +
                '}';
    }
}
