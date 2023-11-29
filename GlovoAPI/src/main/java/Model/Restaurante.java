package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Restaurante {
    ////////////////////////////////////////ATRIBUTOS////////////////////////////////////////
    private Integer id_restaurante;
    private String nombre;
    private String clave;
    private String descripcion;
    private String ubicacion;
    private String imagen;
    private Double nota_media;

    //////////////////////////////////////CONSTRUCTORES//////////////////////////////////////
    public Restaurante(){}
    public Restaurante(int id_restaurante, String nombre, String clave, String descripcion, String ubicacion, String imagen) {
        this.id_restaurante = id_restaurante;
        this.nombre = nombre;
        this.clave = clave;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.imagen = imagen;
    }
    public Restaurante(int id_restaurante, String nombre, String imagen){
        this.id_restaurante = id_restaurante;
        this.nombre = nombre;
        this.imagen = imagen;
    }
    public Restaurante(int id_restaurante, String nombre, String imagen, Double nota_media){
        this.id_restaurante = id_restaurante;
        this.nombre = nombre;
        this.imagen = imagen;
        this.nota_media = nota_media;
    }

    /////////////////////////////////////////MÉTODOS/////////////////////////////////////////

    public Integer getId_restaurante() {
        return id_restaurante;
    }
    public void setId_restaurante(int id_restaurante) {
        this.id_restaurante = id_restaurante;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public static String arrayToJson(ArrayList<Restaurante> restaurantes){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String json = gson.toJson(restaurantes);

        return json;
    }

    public static String restauranteToJson(Restaurante restaurante){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String json = gson.toJson(restaurante);

        return json;
    }
}
