package com.example.glovogabrielml.PuntuarRestaurante;

public class PuntuarData {
    //ATRIBUTOS
    private int lineas_afectadas;

    //MÉTODOS
    public int getLineas_afectadas() {
        return lineas_afectadas;
    }
    public void setLineas_afectadas(int lineas_afectadas) {
        this.lineas_afectadas = lineas_afectadas;
    }
    @Override
    public String toString() {
        return "PuntuarData{" +
                "lineas_aceftadas=" + lineas_afectadas +
                '}';
    }
}
