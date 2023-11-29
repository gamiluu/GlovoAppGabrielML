package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Categoria {
    ////////////////////////////////////////ATRIBUTOS////////////////////////////////////////
    private Integer id_categoria;
    private String categoria;

    //////////////////////////////////////CONSTRUCTORES//////////////////////////////////////
    public Categoria(){}
    public Categoria(String categoria) {
        this.categoria = categoria;
    }
    public Categoria(Integer id_categoria, String categoria) {
        this.id_categoria = id_categoria;
        this.categoria = categoria;
    }

    /////////////////////////////////////////MÉTODOS/////////////////////////////////////////
    public Integer getId_categoria() {
        return id_categoria;
    }
    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public static String arrayToJson(ArrayList<Categoria> categorias){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String json = gson.toJson(categorias);

        return json;
    }
}
