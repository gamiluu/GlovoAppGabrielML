package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Producto {
    ////////////////////////////////////////ATRIBUTOS////////////////////////////////////////
    private Integer id_producto;
    private Integer id_restaurante;
    private String nombre;
    private String imagen;
    private String descripcion;
    private Integer precio;
    private Integer cantidad;

    //////////////////////////////////////CONSTRUCTORES//////////////////////////////////////
    public Producto () {}
    public Producto(int id_producto, int id_restaurante, String nombre, String imagen, String descripcion, int precio) {
        this.id_producto = id_producto;
        this.id_restaurante = id_restaurante;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    public Producto(int id_producto, String nombre, String imagen, String descripcion, int precio) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    public Producto(String nombre, String imagen, int precio, int cantidad) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    /////////////////////////////////////////MÉTODOS/////////////////////////////////////////
    public int getId_producto() {
        return id_producto;
    }
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
    public int getId_restaurante() {
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
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public static String arrayToJson(ArrayList<Producto> productos){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String json = gson.toJson(productos);

        return json;
    }
}
