package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Puntuacion {
    ////////////////////////////////////////ATRIBUTOS////////////////////////////////////////
    private Integer id_usuario;
    private Integer id_restaurante;
    private Integer nota;


    //////////////////////////////////////CONSTRUCTORES//////////////////////////////////////
    public Puntuacion(){}
    public Puntuacion(Integer id_usuario, Integer id_restaurante, Integer nota) {
        this.id_usuario = id_usuario;
        this.id_restaurante = id_restaurante;
        this.nota = nota;
    }

    /////////////////////////////////////////MÉTODOS/////////////////////////////////////////
    public Integer getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
    public Integer getId_restaurante() {
        return id_restaurante;
    }
    public void setId_restaurante(Integer id_restaurante) {
        this.id_restaurante = id_restaurante;
    }
    public Integer getNota() {
        return nota;
    }
    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public static String arrayToJson(ArrayList<Puntuacion> puntuaciones){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String json = gson.toJson(puntuaciones);

        return json;
    }

    public static String puntuacionToJson(Puntuacion puntuacion){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String json = gson.toJson(puntuacion);

        return json;
    }

}
