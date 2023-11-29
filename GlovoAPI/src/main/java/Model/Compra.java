package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Date;
import java.util.ArrayList;

public class Compra {
    ////////////////////////////////////////ATRIBUTOS////////////////////////////////////////
    private Integer id_compra;
    private Integer id_usuario;
    private Integer confirmado;
    private String fecha;
    private Integer precio_total;

    //////////////////////////////////////CONSTRUCTORES//////////////////////////////////////
    public Compra(){}
    public Compra(Integer id_compra, String fecha, Integer precio_total) {
        this.id_compra = id_compra;
        this.fecha = fecha;
        this.precio_total = precio_total;
    }

    /////////////////////////////////////////MÉTODOS/////////////////////////////////////////
    public Integer getId_compra() {
        return id_compra;
    }
    public void setId_compra(Integer id_compra) {
        this.id_compra = id_compra;
    }
    public Integer getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
    public Integer getConfirmado() {
        return confirmado;
    }
    public void setConfirmado(Integer confirmado) {
        this.confirmado = confirmado;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public static String arrayToJson(ArrayList<Compra> compras){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String json = gson.toJson(compras);
        return json;
    }

    public static String compraToJson(Compra compra){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String json = gson.toJson(compra);
        return json;
    }
}
